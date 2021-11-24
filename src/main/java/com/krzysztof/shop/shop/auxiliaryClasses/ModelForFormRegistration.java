package com.krzysztof.shop.shop.auxiliaryClasses;

import lombok.Getter;

@Getter
public class ModelForFormRegistration {
    private String userName;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;

    public ModelForFormRegistration(String userName, String surname, String email, String password, String phoneNumber) {
        this.userName = userName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
