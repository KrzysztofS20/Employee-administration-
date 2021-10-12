package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {

    List<Basket> findByUser(User user);
}
