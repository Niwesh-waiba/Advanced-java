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
public class L4Q5 {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/neuu", "root", "");
            
            String sqlSel = "SELECT * FROM STUDENT WHERE Address = 'kathmandu'";
            PreparedStatement pst = con.prepareStatement(sqlSel);
            ResultSet data = pst.executeQuery();
            while(data.next()){
                int RN = data.getInt("RollNo");
                String FN = data.getString("FirstName");
                String LN = data.getString("LastName");
                String Ad = data.getString("Address");
                String Em = data.getString("Email");
                String DOB = data.getString("DateOfBirth");
                System.out.println(RN+ " " + FN + " " + LN + " " + Ad + " " + Em + " " + DOB );
            }
            
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
    }
}
