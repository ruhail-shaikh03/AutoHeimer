package com.example.sdaproject;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdServiceUI implements Initializable {
    @FXML
    private ImageView bgAD;
    @FXML
    private Button ADBT,BTAD1;
    @FXML
    private ComboBox<String> CBAD,CBAD1;
    @FXML
    private ListView<String> listvAD,adlist;
    @FXML
    private Label head;
    @FXML
    private SplitPane SP1;
    int pid;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        display();
    }
    public void display(){
        AutoHeimerOOP a = new AutoHeimerOOP();
        pid = a.getPid();
        myUse m = a.adService();

        adlist.getItems().addAll(m.o1);
        CBAD1.getItems().addAll(m.o2);
        adlist.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);

                            // decide to add a new styleClass
                            // getStyleClass().add("costume style");
                            // decide the new font size
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });

    }
    public void getAds(){
        AdServiceOOP a = new AdServiceOOP();
        myUse m = a.getPackages();
        listvAD.getItems().addAll(m.o1);
        CBAD.getItems().addAll(m.o2);
        listvAD.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> p) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);

                            // decide to add a new styleClass
                            // getStyleClass().add("costume style");
                            // decide the new font size
                            setFont(Font.font(16));
                        }
                    }
                };
            }
        });

    }
    public void Submit(ActionEvent actionEvent) throws IOException {
        int ad_id = Integer.parseInt(String.valueOf(CBAD1.getValue().charAt(CBAD1.getValue().length()-1)));
        int adv_id = Integer.parseInt(String.valueOf(CBAD.getValue().charAt(CBAD.getValue().length()-1)));
        AdServiceOOP a = new AdServiceOOP();
        a.updateAdvertDB(ad_id,adv_id,pid);
        AutoHeimerOOP aa = new AutoHeimerOOP();
        aa.makePayment(adv_id,ad_id);
    }

    public void Click(ActionEvent actionEvent) {
        int ad_id = Integer.parseInt(String.valueOf(CBAD1.getValue().charAt(CBAD1.getValue().length()-1)));
        AdServiceOOP a = new AdServiceOOP();
        a.updateAd(ad_id,pid);
        SP1.setVisible(false);
        ADBT.setVisible(true);
        listvAD.setVisible(true);
        CBAD.setVisible(true);

        getAds();
    }
}
