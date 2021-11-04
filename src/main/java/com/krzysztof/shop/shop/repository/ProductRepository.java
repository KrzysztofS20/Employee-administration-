package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Modifying
    @Query("select u from Product u where u.category.name=:name")
    List<Product> getProductsByCategoryLv1(@Param("name") String categoryName);

    @Query("select u from Product u where u.category.category.name=:name")
    List<Product> getProductsByCategoryLv2(@Param("name") String categoryName);

    @Query("select u from Product u where u.category.category.category.name=:name")
    List<Product> getProductsByCategoryLv3(@Param("name") String categoryName);

}
