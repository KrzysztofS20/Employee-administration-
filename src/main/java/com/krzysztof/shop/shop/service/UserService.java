package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.repository.UserReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposiotry userReposiotry;


    public List<User> findAll(){
        return userReposiotry.findAll();
    }

    public void createUser(UserDetails user){
        userReposiotry.save((User) user);
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
}
