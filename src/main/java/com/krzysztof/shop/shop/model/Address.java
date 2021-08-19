package com.krzysztof.shop.shop.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String city;
    private String street;
    private String postcode;

    @OneToOne(mappedBy = "address")
    private User user;
}
