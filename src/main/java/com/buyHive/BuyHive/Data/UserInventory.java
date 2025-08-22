package com.buyHive.BuyHive.Data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class UserInventory {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JsonBackReference
    private UserDetails user;

    @ManyToOne
    private Product product;

    private int quantity;

    public UserInventory(){}

    public UserInventory(int id, UserDetails user, Product product, int quantity) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDetails getUser() {
        return user;
    }

    public void setUser(UserDetails user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "UserInventory{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
