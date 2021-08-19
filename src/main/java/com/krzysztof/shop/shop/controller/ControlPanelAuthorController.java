package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.model.Author;
import com.krzysztof.shop.shop.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ControlPanelAuthorController {

    private final AuthorService authorService;

    public ControlPanelAuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/controlPanelAuthor")
    public String getControlPanelAuthor(Model model) {
        List<Author> authorList = authorService.findAll();
        model.addAttribute("authorsList",authorList);
        return "controlPanelAuthor";
    }


    @PostMapping("/addAuthor")
    public RedirectView addAuthor(@ModelAttribute Author author) {
        authorService.saveAuthor(author);
        return new RedirectView("/controlPanelAuthor");
    }


    @PostMapping("/deleteAuthor/{id}")
    public RedirectView deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return new RedirectView("/controlPanelAuthor");
    }

    @PostMapping("/editAuthor/{id}")
    public RedirectView editAuthor(@ModelAttribute Author author, @PathVariable("id") Long id) {
        authorService.editAuthor(author, id);
        return new RedirectView("/controlPanelAuthor");
    }
}
