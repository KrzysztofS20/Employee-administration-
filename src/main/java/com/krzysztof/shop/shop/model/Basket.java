package com.krzysztof.shop.shop.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Basket {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(mappedBy = "basket" , cascade = CascadeType.ALL)
    private List<ProductOrderToBasket> productOrderToBasketList = new ArrayList<>();



    public Basket(User users) {
    }
    private Double summaryToPay;
}
