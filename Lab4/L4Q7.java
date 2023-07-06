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
public class L4Q7 {
     public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/neuu", "root", "");

           String  sql = "DELETE FROM student ORDER BY rollno DESC LIMIT 1";
  
            PreparedStatement pst1 = conn.prepareStatement(sql);
                pst1.execute();
                System.out.println(" last student data deleted succesfully");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
