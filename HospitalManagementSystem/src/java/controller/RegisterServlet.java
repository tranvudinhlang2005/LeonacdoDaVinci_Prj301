package controller;

import model.UserDAO;
import model.PatientDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Using @WebServlet annotation means you MUST remove 
 * the corresponding <servlet> tags from web.xml.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Ensure UTF-8 encoding for handling special characters
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        try {
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            // Basic validation
            if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
                response.getWriter().println("Error: Please fill in all required fields!");
                return;
            }

            UserDAO userDAO = new UserDAO();
            // Insert into Users table first to get the generated userId
            int userId = userDAO.insertUser(username, email, password);

            if (userId > 0) {
                PatientDAO patientDAO = new PatientDAO();
                // Use the retrieved userId to create the patient record
                boolean success = patientDAO.insertPatient(userId, username, phone, address);

                if (success) {
                    // Redirect to login page upon success
                    response.sendRedirect("login.jsp");
                } else {
                    response.getWriter().println("Error: Failed to save patient information!");
                }
            } else {
                response.getWriter().println("Error: Failed to create user account!");
            }
        } catch (Exception e) {
            // Print stack trace for debugging database issues
            e.printStackTrace();
            response.getWriter().println("System Error: " + e.getMessage());
        }
    }
}