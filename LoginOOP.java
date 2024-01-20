package com.example.sdaproject;

import java.sql.SQLException;

public class LoginOOP {
    String user;
    String pass;

    LoginOOP(){
        user="";
        pass="";
    }
    public void setPass(String s){
        pass=s;
    }
    public void setUser(String s){
        user=s;
    }
    public int login() throws SQLException, ClassNotFoundException {
        AutoheimerDB a = new AutoheimerDB();
        //a.makeConnection();
        return a.login(user,pass);
    }
}
