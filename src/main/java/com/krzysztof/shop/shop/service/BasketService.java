package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.repository.BasketRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public void save(Basket basket) {
        basketRepository.save(basket);
    }

    public Basket getById(Long id) {
        return basketRepository.findById(id).get();
    }

    public void delete(Long id) {
        basketRepository.deleteById(id);
    }
}
