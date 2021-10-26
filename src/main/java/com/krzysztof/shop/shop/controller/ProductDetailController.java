package com.krzysztof.shop.shop.controller;


import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProductDetailController {

    private final ProductService productService;

    public ProductDetailController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public String getProductDetail(@PathVariable Long id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "productDetail";
    }
//    @PostMapping("/addItem")
//    public String addItemIntoBasket(){
//
//    }
}
