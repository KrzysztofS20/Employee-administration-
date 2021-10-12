package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.service.BasketService;
import com.krzysztof.shop.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;
    @Autowired
    private UserService userService;

    @GetMapping("/basket")
    public String getBasket(Model model, Neo4jProperties.Authentication authentication) {
        return "basket";
    }
}
