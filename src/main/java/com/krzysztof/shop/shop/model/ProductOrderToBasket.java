package com.krzysztof.shop.shop.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductOrderToBasket {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private Testowy test;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "basket_id", nullable = false)
    private Basket basket;

    private Double toPay;

    public ProductOrderToBasket(User user, int quantity, Product product, Basket basket, Double toPay) {
        this.user = user;
        this.quantity = quantity;
        this.product = product;
        this.basket = basket;
        this.toPay = toPay;
    }
}
