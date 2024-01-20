package com.example.sdaproject;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class PaymentUI implements Initializable {

    @FXML
    private Button ppB;
    @FXML
    private AnchorPane DP;
    @FXML
    private TextField t1, t2, t3, t4, t6;
    @FXML
    private TextField TF5;
    @FXML
    private Button b1;
    private String cardNum;
    private String cardName;
    private int CVV;
    private Date expDate;
    private double amount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void home(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AutoheimerApp.class.getResource("Homepage.fxml"));
        com.example.sdaproject.AutoheimerApp controller = fxmlLoader.getController();
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load(), 663, 495);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void b1Click(ActionEvent actionEvent) {
        ObservableList<String>o = FXCollections.observableArrayList();
        o.add(t1.getText());
        o.add(t2.getText());
        o.add(t3.getText());
        o.add(t4.getText());
        PaymentOOP p=new PaymentOOP();
        p.makePayment(o);

    }
}
