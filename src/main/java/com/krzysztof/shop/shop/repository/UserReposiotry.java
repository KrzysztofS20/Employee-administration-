package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserReposiotry extends JpaRepository<User, Long> {
    @Modifying
    @Query("select u from User u where u.userName=:name")
    List<User> findUserByName(@Param("name") String name);


    Optional<User> findUserByUserName(String userName);


}
