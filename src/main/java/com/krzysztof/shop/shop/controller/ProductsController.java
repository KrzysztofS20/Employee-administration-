package com.krzysztof.shop.shop.controller;

import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.service.CategoryService;
import com.krzysztof.shop.shop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductsController {

private final CategoryService categoryService;
private final ProductService productService;

    public ProductsController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> productList = productService.findAll();
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("productList",productList);
        model.addAttribute("categoryList", categoryList);
        return "products";
    }


}
