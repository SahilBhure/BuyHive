package com.buyHive.BuyHive.Service;

import com.buyHive.BuyHive.Data.UserDetailsRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UserDetailsRepository userRepository;

    public CustomUserDetailsService(UserDetailsRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.buyHive.BuyHive.Data.UserDetails user = userRepository.findByMail(email);

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getMail())
                .password(user.getPassword())
                .build();
    }


}
