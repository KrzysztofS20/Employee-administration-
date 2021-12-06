package com.krzysztof.shop.shop.service;


import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormEditUserWithAddres;
import com.krzysztof.shop.shop.auxiliaryClasses.ModelForFormRegistration;
import com.krzysztof.shop.shop.model.Address;
import com.krzysztof.shop.shop.model.Basket;
import com.krzysztof.shop.shop.model.Person;
import com.krzysztof.shop.shop.repository.BasketRepository;
import com.krzysztof.shop.shop.repository.PersonReposiotry;
import com.krzysztof.shop.shop.security.ApplicationUserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonReposiotry personReposiotry;
    private final AddressService addressService;
    private final BasketRepository basketRepository;


    public List<Person> findAll() {
        return personReposiotry.findAll();
    }

    public void createPerson(ModelForFormRegistration model) {
        Person person = new Person(model.getPersonName(),
                model.getSurName(),
                model.getEmail(),
                model.getPassword(),
                model.getPhoneNumber(),
                ApplicationUserRole.CUSTOMER,
                true);
        save(person);

        Basket basket = new Basket(person);
        basketRepository.save(basket);
        Address address = new Address(person);
        addressService.save(address);
    }

    public void save(Person person) {
        personReposiotry.save(person);
    }

    public Person getById(Long id) {
        return personReposiotry.findById(id).get();
    }

    public void delete(Long id) {
        personReposiotry.deleteById(id);
    }

    public Long getUserIdByName(String name) {
        return personReposiotry.findPersonByName(name)
                .stream()
                .findFirst()
                .get()
                .getId();
    }

    public Optional<Person> getByName(String name) {
        return personReposiotry.findPersonByPersonName(name);
    }

    public void update(ModelForFormEditUserWithAddres personWithAddres, Long id) {
        Person person = getById(id);
        addressService.update(person, personWithAddres);
        person.setPhoneNumber(personWithAddres.getPhoneNumber());
        person.setEmail(personWithAddres.getEmail());
        save(person);
    }
}

