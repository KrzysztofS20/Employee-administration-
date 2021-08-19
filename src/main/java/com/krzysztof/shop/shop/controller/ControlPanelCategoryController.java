package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.repository.CategoryRepository;
import com.krzysztof.shop.shop.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class ControlPanelCategoryController {

    private final CategoryService categoryService;

    public ControlPanelCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/controlPanelCategory")
    public String getControlPanelCategory(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "controlPanelCategory";
    }


    @PostMapping("/addCategory")
    public RedirectView addCategory(@ModelAttribute("newCategory") Category category) {
        categoryService.saveCategory(category);
        return new RedirectView("/controlPanelCategory");
    }


    @PostMapping("/deleteCategory/{id}")
    public RedirectView deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new RedirectView("/controlPanelCategory");
    }

    @PostMapping("/editCategory/{id}")
    public RedirectView editCategory(@ModelAttribute("abc") Category category, @PathVariable("id") Long id) {
        categoryService.editCategory(category, id);
        return new RedirectView("/controlPanelCategory");
    }
}
