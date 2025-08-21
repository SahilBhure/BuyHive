package com.buyHive.BuyHive.Service;

import com.buyHive.BuyHive.Data.UserDetails;
import com.buyHive.BuyHive.Data.UserDetailsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDetailsRepository userDetailsRepository;

    public UserService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }




    public void registerUser(UserDetails user) {
        userDetailsRepository.save(user);

    }


    //ONLY AVAIL FOR ADMIN
    public List<UserDetails> getUsersDetails() {
        return userDetailsRepository.findAll();
    }

    public UserDetails getUserDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        return userDetailsRepository.findByName(userName);
    }
}
