package com.krzysztof.shop.shop.service;

import com.krzysztof.shop.shop.ShopApplication;
import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.Person;
import com.krzysztof.shop.shop.model.Product;
import com.krzysztof.shop.shop.repository.BasketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = ShopApplication.class)
@ExtendWith(SpringExtension.class)
public class BasketTest {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private ProductService productService;

    @Test
    public void testAddOneItemIntoBasket() {
        Person person = personService.getById(17L);
        Product product = productService.getById(20L);
        Basket newItem = new Basket();
      //  newItem.setUser(user);
     //   newItem.setProduct(product);
   //     newItem.setQuantity(1);

        Basket saveBasketItem = basketRepository.save(newItem);

          assertTrue(saveBasketItem.getId() > 0);
    }
@Test
    public void testGetBasketByUser(){
        Person person = personService.getById(17L);

   //     List<Basket> baskets = basketRepository.findByUser(user);

    //    assertEquals(1,baskets.size());
    }
}
