package com.krzysztof.shop.shop.repository;

import com.krzysztof.shop.shop.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonReposiotry extends JpaRepository<Person, Long> {
    @Modifying
    @Query("select u from Person u where u.personName=:name")
    List<Person> findPersonByName(@Param("name") String name);

    Optional<Person> findPersonByPersonName(String personName);


}
