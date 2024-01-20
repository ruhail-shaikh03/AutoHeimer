package com.example.sdaproject;

import javafx.collections.ObservableList;

public class CompareCarOOP {
    public ObservableList<String> getSpecs(String str){
        CompareCarDB c = new CompareCarDB();
        return c.GetCarDetails(str);
    }
}
