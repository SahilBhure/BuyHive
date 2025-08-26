package com.buyHive.BuyHive.Service;

import com.buyHive.BuyHive.Data.ProductRepository;
import com.buyHive.BuyHive.Data.UserDetails;
import com.buyHive.BuyHive.Data.UserDetailsRepository;
import com.buyHive.BuyHive.Data.UserInventory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserDetailsRepository userDetailsRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserDetailsRepository userDetailsRepository,PasswordEncoder passwordEncoder,ProductRepository productRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.passwordEncoder = passwordEncoder;
        this.productRepository = productRepository;
    }



    //Get All User's From Database
    public List<UserDetails> findAllUsers() {
        return userDetailsRepository.findAll();
    }

    //Get Current Authenticated User
    public UserDetails retrieveUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userDetailsRepository.findByMail(userEmail);
    }

    //Get User Based on Mail Address
    public UserDetails getByMail(String mail) {
        return userDetailsRepository.findByMail(mail);
    }


    //Add User To Database
    public void addAUser(UserDetails users) {
        String hashedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(hashedPassword);
        users.setRole(users.getRole());
        userDetailsRepository.save(users);
    }


    //Delete User from Database
    public void deleteUser(Authentication authentication) {
        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            userDetailsRepository.delete(retrieveUser());
        }
    }

    //Update User Info
    public void updateUser(@RequestBody UserDetails users) {
        UserDetails temporaryUser = retrieveUser();

        temporaryUser.setMail(users.getMail());
        temporaryUser.setPassword(passwordEncoder.encode(users.getPassword()));
        temporaryUser.setName(users.getName());
        temporaryUser.setBalance(users.getBalance());
        userDetailsRepository.save(temporaryUser);

    }

    //View Inventory
    public List<UserInventory> viewInventory(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        UserDetails user = userDetailsRepository.findByMail(userEmail);
        return user.getInventory();
    }

}
