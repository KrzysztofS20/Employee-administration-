package com.krzysztof.shop.shop.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

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
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
