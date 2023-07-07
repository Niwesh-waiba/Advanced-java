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
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userEmail = request.getParameter("userEmail");

        String userPassword = request.getParameter("userPassword");

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/lab6", "root", "");

            String sqlsel = "SELECT * FROM registerform WHERE userEmail = '" + userEmail + "'";
            PreparedStatement pst = con.prepareStatement(sqlsel);

            ResultSet data = pst.executeQuery();
            while (data.next()) {
                String EMAIL = data.getString("userEmail");
                String PASSWORD = data.getString("userPassword");

                if (userEmail.equals(EMAIL) && userPassword.equals(PASSWORD)) {
                    RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
                    rd.forward(request, response);

                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
                    rd.include(request, response);
                    
                        out.print("<div style=\"text-align: center;\">Invalid Username or Password error:  </div>");
        
                }
            }

            pst.execute();
            con.close();

        } catch (SQLException | ClassNotFoundException e) {

            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.include(request, response);
            out.print("<div class=\"dispatchOut\" style=\"text-align: center;\">registration error: " + e.getMessage() + "</div>");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
