package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
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
        saveProduct(edited);
    }
}
