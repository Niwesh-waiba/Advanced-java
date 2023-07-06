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
public class L4Q2 {

    public static void main(String[] args) {
        System.out.println("Enter the name for database: ");
        Scanner sc = new Scanner(System.in);
        String dbName = sc.nextLine();
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");

            String sql = "CREATE DATABASE " +dbName ;
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();

            con.close();
            System.out.println(dbName  +" database created successfully");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
