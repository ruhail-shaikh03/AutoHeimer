package com.example.sdaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class CompareCarDB {
    public ObservableList<String> makeConnection(){
        ObservableList<String> cars = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");
            String query = "Select * from Autoheimer.Cars";
            try (PreparedStatement preparedStatement = con.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                // Populate the companyNames list with results from the query
                while (resultSet.next()) {

                    String car = resultSet.getString("make");
                    car += " ";
                    car += resultSet.getString("model");

                    car += " ";


                    car += resultSet.getString("year");

                    cars.add(car);
                    System.out.println(car);
                }
                return cars;

            } catch (SQLException e) {
                e.printStackTrace();
                return cars;
            }

        } catch (Exception e) {
            System.out.println(e);
            return cars;
        }

    }
    public ObservableList<String> GetCarDetails(String str){
        ObservableList<String> modelNames = FXCollections.observableArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");

            String query = "Select make,model,cars.year,enginecc,price,transmission,car_type,mileage from autoheimer.cars where concat(make,\" \",model,\" \",cars.year)=?;";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, str);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {


                    resultSet.next();
                    modelNames.add(resultSet.getString("make"));
                    modelNames.add(resultSet.getString("model"));
                    modelNames.add(resultSet.getString("year"));
                    modelNames.add(resultSet.getString("enginecc"));
                    modelNames.add(resultSet.getString("price"));
                    modelNames.add(resultSet.getString("transmission"));
                    modelNames.add(resultSet.getString("car_type"));
                    modelNames.add(resultSet.getString("mileage"));

                    return modelNames;



                } catch (SQLException e) {
                    e.printStackTrace();
                    return modelNames;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return modelNames;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return modelNames;
        }
    }
}
