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
 * @author neuu
 */
@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userEmail = request.getParameter("userEmail");
        String userPassword = request.getParameter("userPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lab6", "root", "");

            String sqlInsert = "INSERT INTO registerform (firstName,lastName,userEmail,userPassword,confirmPassword) VALUES (?,?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(sqlInsert);
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, userEmail);
            pst.setString(4, userPassword);
            pst.setString(5, confirmPassword);
           
            pst.execute();
            con.close();
            
            
           
            RequestDispatcher rd=request.getRequestDispatcher("loginForm.html");
             rd.include (request, response);
            out.print("<div class=\"dispatchOut\" style=\"text-align: center;\">registration successfull. you can login </div>");
       

        } catch (SQLException | ClassNotFoundException e) {
            
             RequestDispatcher rd=request.getRequestDispatcher("registerForm.html");
             rd.include (request, response);
             out.print("<div class=\"dispatchOut\" style=\"text-align: center;\">registration error: " + e.getMessage()+ "</div>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
