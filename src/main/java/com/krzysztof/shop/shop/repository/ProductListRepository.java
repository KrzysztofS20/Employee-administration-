package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList,Long> {
}
