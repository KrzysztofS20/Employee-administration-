package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.service.BasketService;
import com.krzysztof.shop.shop.service.ProductOrderToBasketService;
import com.krzysztof.shop.shop.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;
    @Autowired
    private PersonService personService;
    @Autowired
    private ProductOrderToBasketService productOrderToBasketService;

    public BasketController(BasketService basketService, PersonService personService, ProductOrderToBasketService productOrderToBasketService) {
        this.basketService = basketService;
        this.personService = personService;
        this.productOrderToBasketService = productOrderToBasketService;
    }

    @GetMapping("/basket")
    public String getBasket(Model model, @CurrentSecurityContext(expression = "authentication?.name") String name) {
        Long userId = personService.getUserIdByName(name);
        Basket basket = basketService.findByUserId(userId);
        basketService.checkTotalAmountOfBasket(basket);
        Basket checkedBasket = basketService.findByUserId(userId);
        model.addAttribute("userBasket",checkedBasket);
        return "basket";
    }
    @PostMapping("/delete/{id}")
    public RedirectView deleteOrderFromBasket(@PathVariable Long id){
        productOrderToBasketService.delete(id);
        return new RedirectView("/basket");
    }
}
