package com.krzysztof.shop.shop.auxiliaryClasses;

import lombok.Getter;

@Getter
public class ModelForFormRegistration {
    private String userName;
    private String surName;
    private String email;
    private String password;
    private String phoneNumber;

    public ModelForFormRegistration(String userName, String surName, String email, String password, String phoneNumber) {
        this.userName = userName;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
