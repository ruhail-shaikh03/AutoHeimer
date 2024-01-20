package com.example.sdaproject;

import java.sql.*;

public class AutoheimerDB {

    public int login(String user, String pass) throws SQLException, ClassNotFoundException {
        String query = "select * from autoheimer.user";
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Autoheimer", "root", "87654321");
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                //preparedStatement.setInt(1, ci++);

                try {
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        if(user.equalsIgnoreCase(resultSet.getString("username"))&&pass.equalsIgnoreCase(resultSet.getString("password")))
                            return resultSet.getInt("userid");
                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Query");
                    return -1;

                }

            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("prepareStatement");
                return -1;

            }
        }
        catch (Exception e) {
            System.out.println(e);
            return -1;
        }

       return -1;
    }
}
