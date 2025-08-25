package com.buyHive.BuyHive.Service;

import com.buyHive.BuyHive.Data.*;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private ProductRepository productRepository;
    private UserDetailsRepository userDetailsRepository;

    public CustomerService(ProductRepository productRepository,UserDetailsRepository userDetailsRepository) {
        this.productRepository = productRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public Optional<Product> getSpecificProduct(Integer id){return productRepository.findById(id);}

    @Transactional
    public void purchaseProduct(Integer productId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        // find user
        UserDetails user = userDetailsRepository.findByMail(userEmail);
        if (user == null) {
            throw new RuntimeException("User not found with email: " + userEmail);
        }

        // find product
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + productId));

        //Get product owner
        UserDetails seller = productRepository.findSellerByProductId(productId);

        // check balance
        if (user.getBalance() < product.getPrice()) {
            throw new RuntimeException("Insufficient balance!");
        }

        // deduct balance
        user.setBalance(user.getBalance() - product.getPrice());

        // check if product already exists in user inventory
        Optional<UserInventory> existingInventoryOpt = user.getInventory()
                .stream()
                .filter(inv -> inv.getProduct().getId() == product.getId())
                .findFirst();

        if (existingInventoryOpt.isPresent()) {
            // increase quantity
            UserInventory inventory = existingInventoryOpt.get();
            inventory.setQuantity(inventory.getQuantity() + 1);
        } else {
            // create new inventory entry
            UserInventory newInventory = new UserInventory();
            newInventory.setUser(user);
            newInventory.setProduct(product);
            newInventory.setQuantity(1);
            user.getInventory().add(newInventory);
        }

        //add amount to seller's balance
        seller.setBalance(seller.getBalance() + product.getPrice());

        //deduct the product from sellers inventory
        //TODO


        // save user
        userDetailsRepository.save(user);
    }


}
