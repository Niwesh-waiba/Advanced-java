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

        if (userEmail.equals("abc@abc") && userPassword.equals("abc123")) {
            RequestDispatcher rd = request.getRequestDispatcher("welcome.html");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("loginForm.html");
            rd.include(request, response);
            out.print("<div style=\"text-align: center;\">Invalid Username or Password error:  </div>");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
