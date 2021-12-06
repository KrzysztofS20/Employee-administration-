package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormEditUserWithAddres;
import com.krzysztof.shop.shop.model.Person;
import com.krzysztof.shop.shop.service.PersonService;
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

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/person")
    public String getPerson(Model model, @CurrentSecurityContext(expression = "authentication?.name") String name) {
        Optional<Person> person = personService.getByName(name);
        model.addAttribute("user",person);
        return "person";
    }
    @GetMapping("/personEdit")
    public String getPersonEdit(Model model,@CurrentSecurityContext(expression = "authentication?.name") String name){
        Optional<Person> person = personService.getByName(name);
        model.addAttribute("user",person);
        return "personEdit";
    }

    @PostMapping("/editUser")
    public RedirectView addProduct(@ModelAttribute ModelForFormEditUserWithAddres personWithAddres,@CurrentSecurityContext(expression = "authentication?.name") String name) {
        Optional<Person> person = personService.getByName(name);
        Long id =person.get().getId();
        personService.update(personWithAddres,id);
        return new RedirectView("/person");
    }
}
