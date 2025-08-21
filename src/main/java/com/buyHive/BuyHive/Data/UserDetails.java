package com.buyHive.BuyHive.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String mail;

    private Roles role;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;


    private String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserInventory> inventory = new ArrayList<>();


    private Float Balance;

    public UserDetails(int id, String name, String mail, Roles role, String password, String address, List<UserInventory> inventory, Float balance) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.role = role;
        this.password = password;
        this.address = address;
        this.inventory = inventory;
        Balance = balance;
    }

    public UserDetails(){}



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

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<UserInventory> getInventory() {
        return inventory;
    }

    public void setInventory(List<UserInventory> inventory) {
        this.inventory = inventory;
    }

    public Float getBalance() {
        return Balance;
    }

    public void setBalance(Float balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", inventory=" + inventory +
                ", Balance=" + Balance +
                '}';
    }
}
