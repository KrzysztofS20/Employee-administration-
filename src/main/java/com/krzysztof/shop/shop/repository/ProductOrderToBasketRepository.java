package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.ProductOrderToBasket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderToBasketRepository extends JpaRepository<ProductOrderToBasket,Long> {
}
