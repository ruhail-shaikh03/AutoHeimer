package com.example.sdaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class myUse {
    public ObservableList<String>o1;
    public ObservableList<String>o2;

    public ObservableList<String>o3;


    myUse(ObservableList<String>o3,ObservableList<String>o4){
        o1=o3;
        o2=o4;
        o3=FXCollections.observableArrayList();
    }
    myUse(){
        o3=FXCollections.observableArrayList();
        o1 = FXCollections.observableArrayList();
        o2 = FXCollections.observableArrayList();
    }
}
