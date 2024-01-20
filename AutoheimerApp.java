package com.example.sdaproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AutoheimerApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("AutoHeimer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println("hey");
        launch();
    }
}