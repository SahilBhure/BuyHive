package com.buyHive.BuyHive.Controller;

import com.buyHive.BuyHive.Data.UserDetails;
import com.buyHive.BuyHive.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/register")
    public void registerUser(@RequestBody UserDetails user){
        userService.registerUser(user);
    }

    //ONLY FOR ADMIN
    @GetMapping("/users")
    public List<UserDetails> getUsersDetails(){
        return userService.getUsersDetails();
    }

    @GetMapping("/user")
    public UserDetails getUserDetails(){
        return userService.getUserDetails();
    }


}
