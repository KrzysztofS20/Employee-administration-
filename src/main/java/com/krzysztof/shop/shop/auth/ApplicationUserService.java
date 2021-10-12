package com.krzysztof.shop.shop.auth;


import com.krzysztof.shop.shop.model.User;
import com.krzysztof.shop.shop.repository.UserReposiotry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApplicationUserService implements UserDetailsService {


    private final UserReposiotry userReposiotry;

    public ApplicationUserService(UserReposiotry userReposiotry) {
        this.userReposiotry = userReposiotry;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userReposiotry.findUserByUserName(username);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found " + username));

        return user.map(ApplicationUser::new).get();
    }
}
