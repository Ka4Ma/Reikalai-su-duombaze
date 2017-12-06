package com.company;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;
import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentasInsert {

    public StudentasInsert() {
        String name;
        String surname;
        String phone;
        String email;
        Scanner skaneris = new Scanner(System.in);
        System.out.println("Iveaskite Studento varda: ");
        name = skaneris.nextLine();
        System.out.println("Iveskite studento pavarde: ");
        surname = skaneris.nextLine();
        System.out.println("Iveskite studento numeri: ");
        phone = skaneris.nextLine();
        System.out.println("Iveskite Studento Elektronini Pasta: ");
        email = skaneris.nextLine();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection ;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mts", "root",
            "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` WHERE `name` = '"+name+"' AND `surname` = '"+surname+"';");
            if (resultSet.next()==true){
                System.out.println("Toks Studentas su tokiu vardu ir pavarde jau ivestas.");
            }
            else{
                statement.execute("INSERT INTO `students` " +
                        "(`id`, `name`, `surname`, `phone`, `email`)" +
                        " VALUES " +
                        "(NULL, '"+name+"', '"+surname+"', '"+phone+"', '"+email+"')" +
                        ";");

                            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
