package com.buyHive.BuyHive.Controller;


import com.buyHive.BuyHive.Service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }




    @GetMapping("/login")
    public void loginUser(){
        authenticationService.loginUser();
    }

    @GetMapping("/logout")
    public void logoutUser(){
        authenticationService.logoutUser();
    }





}
