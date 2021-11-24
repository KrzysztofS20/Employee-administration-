package com.krzysztof.shop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = {"https://spring-boot-shop.herokuapp.com/","index"})
    public String getIndex(){
        return "index";
    }
}
