/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package LR;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Neuu
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class dbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        
        if(!userPassword.equals(confirmPassword)){
            
            RequestDispatcher rd = request.getRequestDispatcher("registerForm.html");
            rd.include(request, response);
            out.print("<div  style=\"text-align: center;\">confirm password </div>");
        }

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "");
            String createDb = " CREATE DATABASE IF NOT EXISTS lab3; ";
            PreparedStatement pst0 = con.prepareStatement(createDb);
            pst0.execute();
            
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/lab3", "root", "");
            String sql = "CREATE TABLE IF NOT EXISTS users ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "firstName VARCHAR(50),"
                    + "lastName VARCHAR(50),"
                    + "userEmail VARCHAR(50) UNIQUE,"
                    + "userPassword VARCHAR(50));";

            PreparedStatement pst = con1.prepareStatement(sql);

            pst.execute();

            String sqlInsert = "INSERT INTO users (firstName,lastName,userEmail,userPassword) VALUES (?,?,?,?)";

            PreparedStatement pst1 = con1.prepareStatement(sqlInsert);
            pst1.setString(1, firstName);
            pst1.setString(2, lastName);
            pst1.setString(3, userEmail);
            pst1.setString(4, userPassword);

            pst1.execute();
            con.close();
            con1.close();

            RequestDispatcher rd = request.getRequestDispatcher("registerForm.html");
            rd.include(request, response);
            out.print("<div  style=\"text-align: center;\">registration successfull. you can login </div>");

        } catch (SQLException | ClassNotFoundException e) {

            RequestDispatcher rd = request.getRequestDispatcher("registerForm.html");
            rd.include(request, response);
            out.print("<div style=\"text-align: center;\">registration error: " + e.getMessage() + "</div>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
