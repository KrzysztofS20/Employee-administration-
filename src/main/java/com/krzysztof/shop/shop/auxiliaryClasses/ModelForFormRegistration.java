package com.krzysztof.shop.shop.auxiliaryClasses;

import lombok.Getter;

@Getter
public class ModelForFormRegistration {
  final   private String personName;
    final private String surName;
    final private String email;
    final private String password;
    final private String phoneNumber;

    public ModelForFormRegistration(String personName, String surName, String email, String password, String phoneNumber) {
        this.personName = personName;
        this.surName = surName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
