package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.service.BasketService;
import com.krzysztof.shop.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;
    @Autowired
    private UserService userService;

    public BasketController(BasketService basketService, UserService userService) {
        this.basketService = basketService;
        this.userService = userService;
    }

    @GetMapping("/basket")
    public String getBasket(Model model, @CurrentSecurityContext(expression = "authentication?.name") String name) {
        Long userId = userService.getByName(name);
        Basket basket = basketService.getById(userId);
        model.addAttribute("basket",basket);
        return "basket";
    }
}
