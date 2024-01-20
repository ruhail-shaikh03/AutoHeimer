package com.example.sdaproject;

import java.sql.*;

public class AdPackage {
    private int id;
    private int price;
    private String desc;

    // Default constructor
    public AdPackage() {
    }

    // Parameterized constructor
    public AdPackage(int id, int price, String desc) {
        this.id = id;
        this.price = price;
        this.desc = desc;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }

    // Getter for desc
    public String getDesc() {
        return desc;
    }

    // Setter for desc
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void displayAdPackages(){};
}
