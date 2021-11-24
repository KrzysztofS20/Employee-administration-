package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormEditUserWithAddres;
import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormRegistration;
import com.krzysztof.shop.shop.model.Address;
import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.repository.BasketRepository;
import com.krzysztof.shop.shop.repository.UserReposiotry;
import com.krzysztof.shop.shop.security.ApplicationUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposiotry userReposiotry;
    private final AddressService addressService;
    private final BasketRepository basketRepository;




    public List<User> findAll() {
        return userReposiotry.findAll();
    }

    public void createUser(ModelForFormRegistration model) {
       User user = new User(model.getUserName(),
               model.getSurname(),
               model.getEmail(),
               model.getPassword(),
               model.getPhoneNumber(),
               ApplicationUserRole.CUSTOMER,
               true);
       save(user);
       Basket basket = new Basket(user);
       basketRepository.save(basket);
    }

    public void save(User user) {
        userReposiotry.save(user);
    }

    public User getById(Long id) {
        return userReposiotry.findById(id).get();
    }

    public void delete(Long id) {
        userReposiotry.deleteById(id);
    }

    public Long getUserIdByName(String name) {
        return userReposiotry.findUserByName(name)
                .stream()
                .findFirst()
                .get()
                .getId();
    }

    public Optional<User> getByName(String name){
        return userReposiotry.findUserByUserName(name);
    }
    public void update(ModelForFormEditUserWithAddres userWithAddres,Long id){
        User oldUser = getById(id);
        if (oldUser.getAddress()==null){
            Address address = new Address(userWithAddres.getCountry(),
                    userWithAddres.getCity(),
                    userWithAddres.getStreet(),
                    userWithAddres.getPostCode());
            addressService.save(address);

            User newUser = new User(id,
                    oldUser.getUserName(),
                    oldUser.getSurname(),
                    userWithAddres.getEmail(),
                    oldUser.getPassword(),
                    userWithAddres.getPhoneNumber(),
                    oldUser.getRole(),
                    oldUser.isActive(),
                    address,
                    oldUser.getProductOrderToBasketList(),
                    oldUser.getBasket()
            );
            save(newUser);

        }else {Address OldAdress = oldUser.getAddress();
            Address address = new Address(oldUser.getAddress().getId(),
                    userWithAddres.getCountry(),
                    userWithAddres.getCity(),
                    userWithAddres.getStreet(),
                    userWithAddres.getPostCode());
            addressService.save(address);

            User newUser = new User(id,
                    oldUser.getUserName(),
                    oldUser.getSurname(),
                    userWithAddres.getEmail(),
                    oldUser.getPassword(),
                    userWithAddres.getPhoneNumber(),
                    oldUser.getRole(),
                    oldUser.isActive(),
                    address,
                    oldUser.getProductOrderToBasketList(),
                    oldUser.getBasket()
            );
            save(newUser);
        }




    }
}
