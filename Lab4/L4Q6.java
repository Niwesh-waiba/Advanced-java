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
public class L4Q6 {

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/neuu", "root", "");

            PreparedStatement updateStmt = conn.prepareStatement("UPDATE student "
                    + "SET Firstname = 'Ram', Lastname = 'Sharma' "
                    + "WHERE RollNo = (SELECT RollNo FROM (SELECT RollNo FROM student ORDER BY RollNo LIMIT 4,1) AS subquery)");
            updateStmt.executeUpdate();
            updateStmt.close();
            System.out.println("update successful");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
