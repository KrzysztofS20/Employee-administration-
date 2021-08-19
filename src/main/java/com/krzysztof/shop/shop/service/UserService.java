package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.repository.UserReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposiotry userReposiotry;


    public List<User> findAll(){
        return userReposiotry.findAll();
    }

    public void saveUser(User user) {
        userReposiotry.save(user);
    }

    public User getUserById(Long id) {
        return userReposiotry.findById(id).get();
    }

    public void deleteUser(Long id) {
        userReposiotry.deleteById(id);
    }
}
