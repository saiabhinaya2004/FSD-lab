/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 *
 * @author dell
 */
@WebServlet(urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve existing session
        HttpSession session = request.getSession();
         PrintWriter out = response.getWriter();
        // Redirect to login page if no session exists or if the session is invalid
        
        // Retrieve username and loginTime from the session
        String username = (String) session.getAttribute("username");
        Date loginTime = (Date) session.getAttribute("loginTime"); // Correctly cast to Date
       

        // Generate HTML response
        response.setContentType("text/html");
        out.println("<html><body>");
        out.println("<h2>Welcome, " + username + "</h2>");
        out.println("<div style='position: absolute; top: 10px; right: 10px;'>Start Time: " + loginTime + "</div>");
        out.println("<form action='logout' method='post'>");
        out.println("<button type='submit'>Logout</button>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
