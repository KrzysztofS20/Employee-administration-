package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }


    public void save(Category category) {
        categoryRepository.save(category);
    }

    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public void edit(Category category, Long id) {
        categoryRepository.save(category);
    }

    public List<Category> getByName(String name) {
        return categoryRepository.findCategoryByName(name);
    }

}
