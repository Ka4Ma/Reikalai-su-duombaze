package com.company;

import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Connection connection ;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mts", "root",
//            "");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM `students` ORDER BY `name` ASC;");
//
//            while(resultSet.next()){
//                System.out.print(resultSet.getInt("id")+"\t");
//                System.out.print(resultSet.getString("name")+"\t");
//                System.out.print(resultSet.getString("surname")+"\t");
//                System.out.print(resultSet.getString("phone")+"\t");
//                System.out.print(resultSet.getString("email")+"\t");
//                System.out.print("\n");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        Main programa = new Main();
        Scanner skaneris = new Scanner(System.in);
        while (true){
            programa.rodykMeniu();
            int veiksmas = skaneris.nextInt();
            switch (veiksmas){
                case 0:
                    return;
                case 1:
                    new StudentasInsert();
                    break;
                case 2:
                    new AdresasInsert();
                    break;
                case 3:
                    new MarksInsert();
                    break;
                case 4:
                    new VisiStudentai();
                    break;

            }
        }
    }

    public void rodykMeniu(){
        System.out.println("__________________________________________________");
        System.out.println("| Sveiki, pasirinkite koki veiksma norite atlikti |");
        System.out.println("| 0-Baigti programos darba                        |");
        System.out.println("| 1-Iveskite Nauja Studenta                       |");
        System.out.println("| 2-Iveskite Nauja Adresa                         |");
        System.out.println("| 3-Iveskite Nauja Pazimi                         |");
        System.out.println("| 4-Atspausdinti visus Studentus                  |");
        System.out.println("|_________________________________________________|");
    }

}
