package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.Category;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public void save(Product product) {
        productRepository.save(product);
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void editProduct(Product product, Long id) {
        Product edited = new Product(
                id,
                product.getName(),
                product.getDescription(),
                product.getPhoto(),
                product.getPrice(),
                product.getAuthor(),
                product.getCategory()
        );
        save(edited);
    }

    public List<Product> findByCategoryId(String name) {
        Optional<Category> category = categoryService.getByName(name).stream().findFirst();
        List<Category> categoryList = category.get().getCategories();
        List<Product> productList = new ArrayList<>();
        List<Product> productListLv1 = category.get().getProducts();
        for (Product productLv1 : productListLv1) {
            productList.add(productLv1);
        }
        if (!categoryList.isEmpty()) {
            for (Category category1 : categoryList) {
                List<Product> productListLv2 = category1.getProducts();
                for (Product productLv2 : productListLv2) {
                    productList.add(productLv2);
                }
                List<Category> deepCategoryList = category1.getCategories();
                if (!deepCategoryList.isEmpty()) {
                    for (Category category2 : deepCategoryList) {
                        List<Product> productListLv3 = category2.getProducts();
                        for (Product productLv3 : productListLv3) {
                            productList.add(productLv3);
                        }
                    }

                }
            }
        }
        return productList;
    }
}