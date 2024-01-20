package com.example.sdaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.util.Callback;

import java.sql.*;

public class AdServiceDB {

    public myUse getListings(int i){
        myUse m = new myUse();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");

            String query = "Select * from autoheimer.advehicle where dealer_id=?;";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1,i);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ObservableList<String> o11 = FXCollections.observableArrayList();
                    ObservableList<String> o21 = FXCollections.observableArrayList();
                    while(resultSet.next()){
                        VehicleAD v = new VehicleAD();
                        v.passString(resultSet);
                        o11.add(v.passString(resultSet));
                        o21.add("Listing no "+String.valueOf(resultSet.getInt("carid")));
                    }
                    m.o1=o11;
                    m.o2=o21;
                    return m;

                } catch (SQLException e) {
                    e.printStackTrace();
                    return m;

                }

            } catch (SQLException e) {
                e.printStackTrace();
                return m;

            }

        } catch (Exception e) {
            System.out.println(e);
            return m;

        }

    }
    public void updateAdvertData(int ad_id, int adv_id,int pid){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");

            String query = "INSERT INTO advservice (packageid, advservice.adid,pid) VALUES (?,?,?);";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                //preparedStatement.setInt(1, ci++);
                preparedStatement.setInt(1, ad_id);
                preparedStatement.setInt(2, adv_id);
                preparedStatement.setInt(3, pid);

                try  {
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
    public void updateAdvert(int ad_id,int pid){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");

            String query = "UPDATE advehicle SET adService = 1  WHERE carid = ? and dealer_id=?;";
                System.out.println(ad_id);
                System.out.println(pid);
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setInt(1, ad_id);
                preparedStatement.setInt(2, pid);

                try  {
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
    public myUse DisplayAvailablePackages(){
        try {
            myUse m = new myUse();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");

            String query = "Select * from autoheimer.advservicedesc;";

            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                //preparedStatement.setString(1, str);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ObservableList<String> o11 = FXCollections.observableArrayList();
                    ObservableList<String> o22 = FXCollections.observableArrayList();
                    while(resultSet.next()){
                        String Desc = "Package "+String.valueOf(resultSet.getInt("packageid")) +" ";
                        Desc+= "\nPrice =" + String.valueOf(resultSet.getInt("price"));
                        Desc+= "\n"+resultSet.getString("packagedesc");
                        o11.add(Desc);
                        o22.add("Package "+String.valueOf(resultSet.getInt("packageid")));
                    }
                    m.o1=o11;
                    m.o2=o22;
                    return m;


                } catch (SQLException e) {
                    e.printStackTrace();
                    return m;

                }

            } catch (SQLException e) {
                e.printStackTrace();
                return m;
            }

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
