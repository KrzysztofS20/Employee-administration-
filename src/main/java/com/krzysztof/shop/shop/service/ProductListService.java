package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.ProductList;
import com.krzysztof.shop.shop.repository.ProductListRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListService {

    private final ProductListRepository productListRepository;

    public List<ProductList> findAll(){
        return productListRepository.findAll();
    }

    public void saveProductList(ProductList productList) {
        productListRepository.save(productList);
    }

    public ProductList getProductListById(Long id) {
        return productListRepository.findById(id).get();
    }

    public void deleteProductList(Long id) {
        productListRepository.deleteById(id);
    }
}
