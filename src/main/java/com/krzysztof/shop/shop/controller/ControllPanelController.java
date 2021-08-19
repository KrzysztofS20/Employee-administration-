package com.krzysztof.shop.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllPanelController {

    @GetMapping("/controlPanel")
    public String getControlPanel(){
        return "controlPanel";
    }
}
