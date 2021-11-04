package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Modifying
    @Query("select u from Category  u where u.name=:name")
    List<Category> findCategoryByName(@Param("name")String name);
}
