package com.krzysztof.shop.shop.auxiliaryClasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelForFormEditUserWithAddres {
    private String phoneNumber;
    private String email;
    private String country;
    private String city;
    private String street;
    private String postCode;

    public ModelForFormEditUserWithAddres(String phoneNumber, String email, String country, String city, String street, String postCode) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
    }
}
