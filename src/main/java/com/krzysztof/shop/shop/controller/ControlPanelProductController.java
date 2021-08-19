package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.model.Author;
import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.service.AuthorService;
import com.krzysztof.shop.shop.service.CategoryService;
import com.krzysztof.shop.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ControlPanelProductController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    public ControlPanelProductController(ProductService productService, CategoryService categoryService, AuthorService authorService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @GetMapping("/controlPanelProduct")
    public String getControlPanelProduct(Model model){
        List<Product> products = productService.findAll();
        List<Category> categorys = categoryService.findAll();
        List<Author> authors = authorService.findAll();
        model.addAttribute("productsList",products);
        model.addAttribute("categoryList",categorys);
        model.addAttribute("authorList",authors);
        return "controlPanelProduct";
    }

    @PostMapping("/addProduct")
    public RedirectView addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return new RedirectView("/controlPanelProduct");
    }


    @PostMapping("/deleteProduct/{id}")
    public RedirectView deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return new RedirectView("/controlPanelProduct");
    }

    @PostMapping("/editProduct/{id}")
    public RedirectView editProduct(@ModelAttribute Product product, @PathVariable("id") Long id) {
        productService.editProduct(product, id);
        return new RedirectView("/controlPanelProduct");
    }
}
