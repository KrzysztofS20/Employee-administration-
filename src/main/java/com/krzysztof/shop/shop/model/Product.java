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
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String photo;
    private Double price;

    @ManyToOne
    @JoinColumn(name="author_id" , nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name="category_id" , nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<ProductOrderToBasket> productOrderToBasketList = new ArrayList<>();

    public Product(Long id, String name, String description, String photo, Double price, Author author, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.author = author;
        this.category = category;
    }

    public Product(String name, String description, String photo, Double price, Author author, Category category) {
        this.name = name;
        this.description = description;
        this.photo = photo;
        this.price = price;
        this.author = author;
        this.category = category;
    }
}
