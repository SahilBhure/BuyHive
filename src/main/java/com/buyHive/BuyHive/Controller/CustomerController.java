package com.buyHive.BuyHive.Controller;

import com.buyHive.BuyHive.Data.Product;
import com.buyHive.BuyHive.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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


    //View Specific Product
    @GetMapping("/products/{id}")
    public Product retrieveSpecificProduct(@PathVariable Integer id){
        return customerService.getSpecificProduct(id);
    }

    //Purchase Product
    @GetMapping("/products/{id}/purchase")
    public void purchaseProduct(@PathVariable Integer id){
        customerService.purchaseProduct(id);
    }




}
