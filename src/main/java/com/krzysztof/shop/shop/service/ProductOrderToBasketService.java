package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.*;
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
    public  void addNewOrder(User user, int quantity, Product product, Basket basket){
        Double toPay = quantity*product.getPrice();
        ProductOrderToBasket order = new ProductOrderToBasket(user,quantity,product,basket,toPay);
        save(order);
    }
}
