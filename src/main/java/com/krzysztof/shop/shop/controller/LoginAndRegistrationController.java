package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormRegistration;
import com.krzysztof.shop.shop.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginAndRegistrationController {

    private final PersonService personService;

    public LoginAndRegistrationController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegister() {
        return "registration";
    }

    @PostMapping("/createUser")
    public RedirectView createUser(@ModelAttribute ModelForFormRegistration model) {
        personService.createPerson(model);
        return new RedirectView("/login");
    }
}
