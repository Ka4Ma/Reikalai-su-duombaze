package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class MarksInsert {
    public MarksInsert() {
        String name;
        String surname;
        int mark=-1;
        String textMark;
        String title;
        Scanner skaneris = new Scanner(System.in);
        System.out.println("Iveaskite Studento varda: ");
        name = skaneris.nextLine();
        System.out.println("Iveskite studento pavarde: ");
        surname = skaneris.nextLine();

        boolean yraSkaicius = false;
        while (yraSkaicius==false) {
            System.out.println("Iveskite studento Pazymi: ");
            textMark = skaneris.nextLine();
            try {
                mark = Integer.parseInt(textMark);
                yraSkaicius = true;
            } catch (NumberFormatException ex) {
                System.out.println("Ivestas ne skaicius");
                //handle exception here
            }
        }
        System.out.println("Kokiame Dalyke Ji gavo: ");
        title = skaneris.next();

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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` " + "" +
                    "WHERE `name` = '" + name + "' AND `surname` = '" + surname + "'");
            if (resultSet.next() == true) {

                int studdentID = resultSet.getInt("id");
                statement.execute(
                        "INSERT INTO " +
                                "`students_marks` (`id`, `student_id`, `mark`, `title`, `time_stamp`)" +
                                " VALUES (NULL, '" + studdentID + "', '" + mark + "', '" + title + "', NULL);");
            } else {
                System.out.println("Studentas su tokiu vardu ir pavarde nerastas");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
