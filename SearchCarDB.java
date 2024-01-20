package com.example.sdaproject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.sql.*;
public class SearchCarDB {
    public ObservableList<String> searchCar(String str){
        ObservableList<String> observableList = FXCollections.observableArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");
            String query = "Select* from advehicle left join pictures_path on carid=adid where company=?or modelname=? or advehicle.year=? or advehicle.type=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, str);
                preparedStatement.setString(2, str);
                preparedStatement.setString(3, str);
                preparedStatement.setString(4, str);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ObservableList<String> modelNames = FXCollections.observableArrayList();
                    while(resultSet.next()){

                        VehicleAD v = new VehicleAD();
                        String x = v.passString(resultSet);

                        System.out.println(x);
                        observableList.add(x+resultSet.getString("adid"));
                    }
                    return observableList;
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Inner");
                    return observableList;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Outer");
                return observableList;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Full");
            return observableList;
        }
    }
    public myUse searchCarPath(String str){
        myUse m = new myUse();
        ObservableList<String> paths = FXCollections.observableArrayList();
        ObservableList<String> p = FXCollections.observableArrayList();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");
            String query = "Select* from advehicle left join pictures_path on carid=adid where company=?or modelname=? or advehicle.year=? or advehicle.type=?";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                preparedStatement.setString(1, str);
                preparedStatement.setString(2, str);
                preparedStatement.setString(3, str);
                preparedStatement.setString(4, str);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ObservableList<String> modelNames = FXCollections.observableArrayList();
                    while(resultSet.next()){
                        String path= resultSet.getString("adid")+"file:"+resultSet.getString("picturPath");
                        paths.add(path);
                        p.add(resultSet.getString("carid"));
                    }
                   m.o2=paths;
                    m.o3=p;
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
}
