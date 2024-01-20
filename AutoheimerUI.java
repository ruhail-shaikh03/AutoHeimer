package com.example.sdaproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AutoheimerUI implements Initializable {


    public TextField usernameField;
    public PasswordField passwordField;
    public Button CompareCar;
    public Button EditAddButton;
    public Button searchVehicleButton;

    public void checkCredentials(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        AutoHeimerOOP a = new AutoHeimerOOP();
        boolean l = a.login(usernameField.getText(),passwordField.getText());
        if(l){
            goHome();
        }
    }
    public void goHome() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("Homepage.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void SVClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("SearchCar.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void GetADs(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("AdServices.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void CCClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("CompareCar.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    public static void payment() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("payment.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("login.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}

