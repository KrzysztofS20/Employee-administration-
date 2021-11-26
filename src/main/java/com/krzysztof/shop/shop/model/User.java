package com.krzysztof.shop.shop.model;

import com.krzysztof.shop.shop.security.ApplicationUserRole;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User{
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String surname;
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private ApplicationUserRole role;
    private boolean active;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<ProductOrderToBasket> productOrderToBasketList = new ArrayList<>();

    @OneToOne(mappedBy = "users",cascade = CascadeType.ALL)
    private Basket basket;


    public User(String userName, String surname, String email, String password, String phoneNumber, ApplicationUserRole role,boolean active) {
        this.userName = userName;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.active = active;
    }


}
