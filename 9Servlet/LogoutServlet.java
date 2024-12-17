

import java.io.IOException;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve existing session
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Retrieve username and loginTime from session
            String username = (String) session.getAttribute("username");
            Date loginTime = (Date) session.getAttribute("loginTime");
            Date logoutTime = new Date();
            PrintWriter out = response.getWriter();
            // Calculate the session duration in milliseconds
            long durationInMillis = logoutTime.getTime() - loginTime.getTime();
            
            // Convert the duration to hours, minutes, seconds
            long hours = (durationInMillis / (1000 * 60 * 60)) % 24;
            long minutes = (durationInMillis / (1000 * 60)) % 60;
            long seconds = (durationInMillis / 1000) % 60;

            // Invalidate the session
            session.invalidate();
            
            // Generate HTML response
            response.setContentType("text/html");
            out.println("<html><body>");
            out.println("<h2>Thank You, " + username + "!</h2>");
            out.println("<p>Your session lasted for: " + hours + " hours: " + minutes + " minutes: " + seconds + " seconds.</p>");
            out.println("<a href='index.html'>Login Again</a>");
            out.println("</body></html>");
        } else {
            // Redirect to login page if no session exists
            response.sendRedirect("index.html");
        }
    }
}
