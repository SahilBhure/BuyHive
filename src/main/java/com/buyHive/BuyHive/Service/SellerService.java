package com.buyHive.BuyHive.Service;

import com.buyHive.BuyHive.Data.ProductRepository;
import com.buyHive.BuyHive.Data.UserDetailsRepository;
import com.buyHive.BuyHive.Data.UserInventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final UserDetailsRepository userDetailsRepository;

    private final ProductRepository productRepository;

    public SellerService(UserDetailsRepository userDetailsRepository, ProductRepository productRepository) {
        this.userDetailsRepository = userDetailsRepository;
        this.productRepository = productRepository;
    }



    //Maintain Products

    //View Sell's History


}
