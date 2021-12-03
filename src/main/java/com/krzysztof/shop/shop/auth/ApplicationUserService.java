package com.krzysztof.shop.shop.auth;



import com.krzysztof.shop.shop.model.Person;
import com.krzysztof.shop.shop.repository.PersonReposiotry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {


    private final PersonReposiotry personReposiotry;

    public ApplicationUserService(PersonReposiotry personReposiotry) {
        this.personReposiotry = personReposiotry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personReposiotry.findPersonByPersonName(username);

        person.orElseThrow(() -> new UsernameNotFoundException("Person not found " + username));

        return person.map(ApplicationUser::new).get();
    }
}
