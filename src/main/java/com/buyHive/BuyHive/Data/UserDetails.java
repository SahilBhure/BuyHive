package com.buyHive.BuyHive.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Roles role;

    private String password;

    private String address;

    public UserDetails(){}

    public UserDetails(int id, String name, Roles role, String password, String address) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.address = address;
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

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
