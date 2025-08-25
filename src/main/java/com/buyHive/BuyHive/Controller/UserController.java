package com.buyHive.BuyHive.Controller;

import com.buyHive.BuyHive.Data.UserDetails;
import com.buyHive.BuyHive.Data.UserInventory;
import com.buyHive.BuyHive.Service.JwtService;
import com.buyHive.BuyHive.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    //Root Page

//    @GetMapping("/")
//    public String hello(Authentication authentication) {
//        return userService.HelloUser(authentication);
//    }



    ///Get,Add,Remove,Update User


    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserDetails> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/user")
    public UserDetails getUser(){
        return userService.retrieveUser();
    }


    @PostMapping("/register")
    @Transactional
    public void addAUser(@RequestBody UserDetails user){
        userService.addAUser(user);
    }



    @DeleteMapping("/user")
    public void deleteUser(HttpServletRequest request, HttpServletResponse response,
                           Authentication authentication) {
        userService.deleteUser(authentication);
        new SecurityContextLogoutHandler().logout(request, response, authentication);
    }


    @PutMapping("/user")
    public void updateUser(@RequestBody UserDetails user) {
        userService.updateUser(user);
    }


    @GetMapping("/user/inventory")
    public List<UserInventory> retrieveUserInventory(){
        return userService.viewInventory();
    }


}
