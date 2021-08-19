package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void editCategory(Category category, Long id) {
//        Category editCategory = new Category();
//        editCategory.setId(id);
//        editCategory.setName(category.getName());
//
//        if (!category.getCategories().isEmpty()) {
//            editCategory.setCategories(category.getCategories());
//        }
        categoryRepository.save(category);
    }


}
