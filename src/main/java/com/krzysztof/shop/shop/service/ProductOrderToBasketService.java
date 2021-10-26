package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.Address;
import com.krzysztof.shop.shop.model.ProductOrderToBasket;
import com.krzysztof.shop.shop.repository.ProductOrderToBasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderToBasketService {

    private final ProductOrderToBasketRepository productOrderToBasketRepository;

    public ProductOrderToBasketService(ProductOrderToBasketRepository productOrderToBasketRepository) {
        this.productOrderToBasketRepository = productOrderToBasketRepository;
    }


    public List<ProductOrderToBasket> findAll(){
        return productOrderToBasketRepository.findAll();
    }

    public void save(ProductOrderToBasket productOrderToBasket) {
        productOrderToBasketRepository.save(productOrderToBasket);
    }

    public ProductOrderToBasket getById(Long id) {
        return productOrderToBasketRepository.findById(id).get();
    }

    public void delete(Long id) {
        productOrderToBasketRepository.deleteById(id);
    }
}
