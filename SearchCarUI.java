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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javafx.fxml.FXML;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SearchCarUI implements Initializable {
    @FXML
    private ImageView SChome;
    @FXML
    private Button SearchBT;
    @FXML
    private ListView<String> List1;
    @FXML
    private Button filterBT;
    @FXML
    private TextField Min,Max;
    @FXML
    private TextField SearchBar;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SearchBar.setText("");
        //VehicleAD v = new VehicleAD();
        Min.setText("0");
        Max.setText("100000000");


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

    public void SearchBTClick(ActionEvent actionEvent) throws Exception {
        List1.getItems().clear();
        String str  = SearchBar.getText();
        AutoHeimerOOP a = new AutoHeimerOOP();
        myUse m = a.SearchCar(str);
        List1.getItems().addAll(m.o1);
        ObservableList<String> path = m.o2;
        ObservableList<String> p = m.o3;
        for(int i=0;i<path.size();i++){
            int finalI = i;
            int finalI1 = i;
            int finalI2 = i;

            String s = path.get(finalI1).substring(1);
            List1.setCellFactory(param -> new ListCell<String>() {

            private ImageView imageView = new ImageView();

            @Override
            public void updateItem(String name, boolean empty) {
                super.updateItem(name, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    //System.out.println(path.get(finalI2));
                    //System.out.println(p.get(finalI1));

                    imageView.setImage(new Image(func(path,name)));
                    imageView.setFitWidth(100);
                    imageView.setFitHeight(100);
                    setGraphic(imageView);
                    setText(name);
                    setFont(Font.font(18));
                    setBackground(Background.fill(Paint.valueOf("FFFFF0")));
                }

            }
        });}

    }

    public void filter(ActionEvent actionEvent) {
        int min = Integer.parseInt(Min.getText());
        int max = Integer.parseInt(Max.getText());
        ObservableList<String> observableList = List1.getItems();
        SearchCarOOP s = new SearchCarOOP();
        ObservableList<String> o = s.filter(min,max,observableList);
        List1.getItems().clear();
        List1.getItems().addAll(o);
    }
    public String func(ObservableList<String> o,String i){
        for (String s : o) {
            System.out.println(i);
            if (s.charAt(0) == i.charAt(i.length()-1))
                return s.substring(1);
        }
        return "";
    }
}
