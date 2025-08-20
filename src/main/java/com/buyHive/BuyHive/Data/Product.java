package com.buyHive.BuyHive.Data;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String description;

    private Float price;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserDetails sellerId;

    public Product(){}

    public Product(int id, String name, String description, Float price, UserDetails sellerId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.sellerId = sellerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public UserDetails getSellerId() {
        return sellerId;
    }

    public void setSellerId(UserDetails sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", sellerId=" + sellerId +
                '}';
    }
}
