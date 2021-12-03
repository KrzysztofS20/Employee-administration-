package com.krzysztof.shop.shop.model;

import lombok.*;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "address" ,cascade = CascadeType.ALL)
    private Person person;


    public Address(String country, String city, String street, String postcode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }

    public Address(Long id, String country, String city, String street, String postcode) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postcode = postcode;
    }
}
