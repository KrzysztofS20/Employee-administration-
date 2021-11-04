package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.ShopApplication;
import com.krzysztof.shop.shop.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ShopApplication.class)
class CategoryServiceTestIT {


    @Autowired
    CategoryService categoryService;

    @Autowired
    AuthorService authorService;

    @Test
    void saveCategory() {
        Category elektronika = new Category("Elektronika");
        Category smartphone = new Category("Smartphone", elektronika);

        categoryService.save(elektronika);
        categoryService.save(smartphone);

    }
}