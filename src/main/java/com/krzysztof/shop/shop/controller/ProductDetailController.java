package com.krzysztof.shop.shop.controller;


import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormInProductDetail;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.service.BasketService;
import com.krzysztof.shop.shop.service.ProductOrderToBasketService;
import com.krzysztof.shop.shop.service.ProductService;
import com.krzysztof.shop.shop.service.UserService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ProductDetailController {

    private final ProductService productService;
    private final UserService userService;
    private final BasketService basketService;
    private  final ProductOrderToBasketService productOrderToBasketService;

    public ProductDetailController(ProductService productService, UserService userService, BasketService basketService, ProductOrderToBasketService productOrderToBasketService) {
        this.productService = productService;
        this.userService = userService;
        this.basketService = basketService;
        this.productOrderToBasketService = productOrderToBasketService;
    }

    @GetMapping("/products/{id}")
    public String getProductDetail(@PathVariable Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "productDetail";
    }
    @PostMapping("/addItem/{id}")
    public RedirectView addItemIntoBasket(@ModelAttribute ModelForFormInProductDetail model, @CurrentSecurityContext(expression = "authentication?.name") String name, @PathVariable Long id){
                productOrderToBasketService.addNewOrder(
                        userService.getById(userService.getUserIdByName(name)),
                        model.getQuantityOfProduct(),
                        productService.getById(id),
                        basketService.findByUserId(userService.getUserIdByName(name)));
        return new RedirectView("/products");
    }
}
