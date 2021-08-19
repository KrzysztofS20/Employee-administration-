package com.krzysztof.shop.shop.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductOrder {
    @Id
    @GeneratedValue
    private Long id;
    private Long quantity;
    private Double price;

    @ManyToOne
    @JoinColumn(name="product_id" , nullable = false)
    private Product product;

    @OneToMany(mappedBy = "productOrder")
    private List<ProductList> productLists = new ArrayList<>();
}
