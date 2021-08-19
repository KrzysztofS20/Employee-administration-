package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.ProductOrder;
import com.krzysztof.shop.shop.repository.ProductOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductOrderService {

    private final ProductOrderRepository productOrderRepository;

    public List<ProductOrder> findAll(){
        return productOrderRepository.findAll();
    }

    public void saveProductOrder(ProductOrder productOrder) {
        productOrderRepository.save(productOrder);
    }

    public ProductOrder getProductOrderById(Long id) {
        return productOrderRepository.findById(id).get();
    }

    public void deleteProductOrder(Long id) {
        productOrderRepository.deleteById(id);
    }
}
