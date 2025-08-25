package com.buyHive.BuyHive.Controller;


import com.buyHive.BuyHive.Data.UserDetails;
import com.buyHive.BuyHive.Service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }




    @PostMapping("/login")
    public void loginUser(@RequestBody UserDetails userDetails){
        authenticationService.loginUser(userDetails);
    }

    @GetMapping("/logout")
    public void logoutUser(){
        authenticationService.logoutUser();
    }





}
