package com.company;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class AdresasInsert {
     public AdresasInsert() {
        String name;
        String surname;
        String country;
        String city;
        String street;
        String post_code;
        Scanner skaneris = new Scanner(System.in);
        System.out.println("Iveaskite Studento varda: ");
        name = skaneris.nextLine();
        System.out.println("Iveskite studento pavarde: ");
        surname = skaneris.nextLine();
        System.out.println("Iveskite studento adresa: ");
        System.out.println("Salis:");
        country = skaneris.nextLine();
        System.out.println("Miestas:");
        city = skaneris.nextLine();
        System.out.println("Gatve:");
        street = skaneris.nextLine();
        System.out.println("Post Kodas:");
        post_code = skaneris.nextLine();


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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` " +"" +
                    "WHERE `name` = '" + name + "' AND `surname` = '" + surname + "'");
            if (resultSet.next() == true) {

                int studdentID = resultSet.getInt("id");
                statement.execute(
                        "INSERT INTO `student_address` " +
                                "(`id`, `student_id`, `country`,`city`,`street`,`post_code`)" +
                                " VALUES " +
                                "(NULL, '" + studdentID + "', '" + country + "', '" + city + "'," +
                                " '" + street + "', '" + post_code + "')" +
                                ";");
            } else {
                System.out.println("Studentas su tokiu vardu ir pavarde nerastas");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
