package com.example.sdaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class SearchCarOOP {
    public String func(ObservableList<String> o, String i){
        for (String s : o) {
            if (s.charAt(0) == i.charAt(0))
                return s.substring(1);
        }
        return "";
    }
    public ObservableList<String> filter(int min,int max, ObservableList<String>observableList){
        ObservableList<String> o = FXCollections.observableArrayList();
        for(int i=0;i<observableList.size();i++){
            int c = Integer.parseInt(observableList.get(i).substring(observableList.get(i).indexOf("Price")+7,observableList.get(i).indexOf("Price")+14));
            System.out.println(c);
            if(c>min&&c<max)
                o.add(observableList.get(i));
        }
        return o;
    }
    public ObservableList<String> searchCar(String keyword) throws SQLException,Exception {
        SearchCarDB s = new SearchCarDB();
        return s.searchCar(keyword);


    }
    public myUse searchCarPath(String keyword){
        SearchCarDB s = new SearchCarDB();
        return s.searchCarPath(keyword);
    }
}
