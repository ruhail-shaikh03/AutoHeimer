package com.example.sdaproject;

import javafx.scene.image.Image;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleAD {
    public String model;
    public String Company;
    public Image image;
    String passString(ResultSet rs) throws SQLException {
        String d=rs.getString(2);
        d+=" ";
        d+=rs.getString(3);
        d+=" \n";
        d+= String.valueOf(rs.getInt(4));
        d+=" \n";
        d+= String.valueOf(rs.getInt(5));
        d+=" KM driven Price= ";
        d+= String.valueOf(rs.getInt(11));
        d+="\nContact Number = ";
        d+=rs.getString("contnumber");
        return d;



    }
}
