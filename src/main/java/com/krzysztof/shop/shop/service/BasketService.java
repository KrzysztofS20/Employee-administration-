package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.ProductOrderToBasket;
import com.krzysztof.shop.shop.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final PersonService personService;

    public List<Basket> findAll() {
        return basketRepository.findAll();
    }

    public void save(Basket basket) {
        basketRepository.save(basket);
    }

    public Basket getById(Long id) {
        return basketRepository.findById(id).get();
    }

    public void delete(Long id) {
        basketRepository.deleteById(id);
    }

    public Basket findByUserId(Long id) {
        Long basketId = personService
                .getById(id)
                .getBasket()
                .getId();
        return basketRepository.getById(basketId);
    }

//    public void updateSummaryToPay(Double monetToPay, Basket basket) {
//        Basket newBasket = new Basket(basket.getId(), basket.getProductOrderToBasketList(), basket.getUsers(), monetToPay);
//        save(newBasket);
//    }

    public void checkTotalAmountOfBasket(Basket basket) {
        Double moneyToPay = 0D;
        List<ProductOrderToBasket> list = basket.getProductOrderToBasketList();
        for (ProductOrderToBasket product : list) {
            moneyToPay += product.getToPay();
        }
//        updateSummaryToPay(moneyToPay, basket);
    }
}
