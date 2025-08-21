package com.buyHive.BuyHive.Controller;

import com.buyHive.BuyHive.Data.Product;
import com.buyHive.BuyHive.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/Customer")
@RestController
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //View all products

    @GetMapping("/products")
    public List<Product> retrieveAllProducts(){
      return customerService.getAllProducts();
    }


    //Purchase


    //Manage Inventory




}
