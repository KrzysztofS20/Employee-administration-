package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormEditUserWithAddres;
import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.service.UserService;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class PersonController {

    private final UserService userService;

    public PersonController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/person")
    public String getPerson(Model model, @CurrentSecurityContext(expression = "authentication?.name") String name) {
        Optional<User> user = userService.getByName(name);
        model.addAttribute("user",user);
        return "person";
    }
    @GetMapping("/personEdit")
    public String getPersonEdit(Model model,@CurrentSecurityContext(expression = "authentication?.name") String name){
        Optional<User> user = userService.getByName(name);
        model.addAttribute("user",user);
        return "personEdit";
    }

    @PostMapping("/editUser")
    public RedirectView addProduct(@ModelAttribute ModelForFormEditUserWithAddres userWithAddres,@CurrentSecurityContext(expression = "authentication?.name") String name) {
        Optional<User> user = userService.getByName(name);
        Long id =user.get().getId();
        userService.update(userWithAddres,id);
        return new RedirectView("/person");
    }
}
