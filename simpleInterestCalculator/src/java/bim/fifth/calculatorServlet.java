/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package bim.fifth;

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
@WebServlet(name = "calculatorServlet", urlPatterns = {"/calculatorServlet"})
public class calculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            double principalValue = Double.parseDouble(request.getParameter("principal"));

            double timeValue = Double.parseDouble(request.getParameter("time"));

            double rateValue = Double.parseDouble(request.getParameter("rate"));

            double result = (principalValue * timeValue * rateValue) / 100;

            out.write(" result is " + result);

        }
    }

}
