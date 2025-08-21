package com.buyHive.BuyHive.Service;

import com.buyHive.BuyHive.Data.Product;
import com.buyHive.BuyHive.Data.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private ProductRepository productRepository;

    public CustomerService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
