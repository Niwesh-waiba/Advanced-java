/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Neuu
 */
public class L4Q4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/neuu", "root", "");

            boolean insertMore = false;
            do {
                System.out.println("Enter Roll No. :");
                int RN = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter First Name :");
                String FN = sc.nextLine();

                System.out.println("Enter Last Name :");
                String LN = sc.nextLine();

                System.out.println("Enter Address :");
                String Ad = sc.nextLine();

                System.out.println("Enter Email :");
                String Em = sc.nextLine();

                System.out.println("Enter Date Of Birth :");
                String DOB = sc.nextLine();

                var sqlIns = "INSERT INTO STUDENT"
                        + "(RollNo, Firstname, Lastname, Address,Email, DateOfBirth) "
                        + "VALUES ('" + RN + "','" + FN + "','" + LN + "','" + Ad + "','" + Em + "','" + DOB + "' )";

                PreparedStatement pst1 = con1.prepareStatement(sqlIns);
                pst1.execute();

                System.out.println("Do you want to insert more data? y/n");
                String choice = sc.next().toLowerCase();
                if ("y".equals(choice)) {
                    insertMore = true;
                }

            } while (insertMore);

            con1.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
