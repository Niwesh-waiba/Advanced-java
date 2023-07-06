/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab4;

import java.sql.*;

/**
 *
 * @author Neuu
 */
public class L4Q1 {

    public static void main(String[] args) {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bim5th", "root", "");

            System.out.println("Connection successful");
            con.close();

        } catch (SQLException e) {
            System.out.println( e.getMessage());
        }

    }
}
