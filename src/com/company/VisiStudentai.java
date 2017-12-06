package com.company;

import java.sql.*;
import java.sql.ResultSet;

public class VisiStudentai {
    public void VisiStudentai() {



        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mts", "root",
                    "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` ORDER BY `name` ASC;");
            int i = 0;
            while(resultSet.next()){
                System.out.print(resultSet.getInt("id")+"\t");
                System.out.print(resultSet.getString("name")+"\t");
                System.out.print(resultSet.getString("surname")+"\t");
                System.out.print(resultSet.getString("phone")+"\t");
                System.out.print(resultSet.getString("email")+"\t");
                System.out.print("\n");
                i++;
            }
            if (i==0){
                System.out.println("Studentu nera");
            }


        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}