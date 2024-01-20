package com.example.sdaproject;

import javafx.collections.ObservableList;

import java.sql.*;

public class PaymentDB {
    public void makePayment(ObservableList<String> o ,int adv_id,int amount){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");

            String query = "INSERT INTO Payment (cardnumber,name,cvv,exp_date,amount,advid) VALUES (?,?,?,?,?,?);";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                //preparedStatement.setInt(1, ci++);
                preparedStatement.setString(1, o.get(0));
                preparedStatement.setString(2, o.get(1));
                preparedStatement.setInt(3, Integer.parseInt(o.get(2)));
                preparedStatement.setDate(4, Date.valueOf(o.get(3)));
                preparedStatement.setDouble(5, amount);
                preparedStatement.setInt(6, adv_id);

                try {
                    preparedStatement.executeUpdate();


                } catch (SQLException e) {
                    e.printStackTrace();

                }

            } catch (SQLException e) {
                e.printStackTrace();

            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

}
