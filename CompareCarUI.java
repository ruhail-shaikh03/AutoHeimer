package com.example.sdaproject;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompareCarUI implements Initializable {
    @FXML
    public Label CCHeading;
    @FXML
    private ImageView image1;
    @FXML
    private Label L1, L2, L3, L4, L5, L6, L7, L8, L11, L21, L31, L41, L51, L61, L71, L81, Hid1, Hid2;
    @FXML
    private Button BT1;
    @FXML
    private Button BT2;
    public Button HomeButton;
    @FXML
    private GridPane G1,G2;
    @FXML
    private ComboBox<String> CB1;
    @FXML
    private ComboBox<String> CB2;
    @FXML
    private SplitPane S1,S2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image1.setImage(new Image("file:D:\\Downloads\\autpic.jpg"));
        CompareCarDB c = new CompareCarDB();
        CB1.setItems(c.makeConnection());
        CB2.setItems(c.makeConnection());
    }

    public void BT1Click(ActionEvent actionEvent) {
        S2.setLayoutY(78);
        S1.setVisible(true);
        G1.setVisible(true);
        AutoHeimerOOP a = new AutoHeimerOOP();
        ObservableList<String> cars = a.compareCarSpecs(CB1.getValue());
        L1.setText(cars.get(0));
        L2.setText(cars.get(1));
        L3.setText(cars.get(2));
        L4.setText(cars.get(3));
        L5.setText(cars.get(4));
        L6.setText(cars.get(5));
        L7.setText(cars.get(6));
        L8.setText(cars.get(7));
    }

    public void BT2Click(ActionEvent actionEvent) {
        S2.setLayoutY(78);
        S1.setVisible(true);
        G2.setVisible(true);
        AutoHeimerOOP a = new AutoHeimerOOP();
        ObservableList<String> cars = a.compareCarSpecs(CB2.getValue());
        L11.setText(cars.get(0));
        L21.setText(cars.get(1));
        L31.setText(cars.get(2));
        L41.setText(cars.get(3));
        L51.setText(cars.get(4));
        L61.setText(cars.get(5));
        L71.setText(cars.get(6));
        L81.setText(cars.get(7));
    }

    public void GoHome(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("Homepage.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}

