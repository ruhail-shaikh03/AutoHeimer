package com.example.sdaproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class AutoHeimerOOP {
     static int pid;
     public boolean login(String user, String pass) throws SQLException, ClassNotFoundException {
          LoginOOP l = new LoginOOP();
          l.setUser(user);
          l.setPass(pass);
          int i = l.login();
          pid = i;
          return i != -1;
     }
     public ObservableList<String> compareCarSpecs(String car){
          CompareCarOOP c = new CompareCarOOP();
          return c.getSpecs(car);
     }
     public myUse SearchCar(String keyword)throws SQLException,Exception{
          SearchCarOOP s = new SearchCarOOP();
         // ObservableList<String> o = FXCollections.observableArrayList();
          myUse m = new myUse();
          m.o1=s.searchCar(keyword);
          m.o2=s.searchCarPath(keyword).o2;
          m.o3=s.searchCarPath(keyword).o3;
          return m;
     }
     int getPid(){
          return pid;
     }
     public myUse adService(){
          AdServiceOOP a = new AdServiceOOP(pid);
          return a.getListings(pid);
     }

     public void makePayment(int i, int p) throws IOException {
          System.out.println(p);
          PaymentOOP pp = new PaymentOOP(i,p);


     }


}