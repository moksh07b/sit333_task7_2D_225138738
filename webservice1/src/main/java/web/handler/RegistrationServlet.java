package web.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.RegistrationService;

/**
 * HTTP end-point to handle registration request.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        System.out.println("[RegistrationServlet] GET");

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        System.out.println("[RegistrationServlet] POST");

        String fName = req.getParameter("fname");
        String lName = req.getParameter("lname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String dob = req.getParameter("dob");

        // Call registration business logic
        boolean result = RegistrationService.register(fName, lName, email, password, dob);

        System.out.println("===== Registration Request Received =====");
        System.out.println("First Name: " + fName);
        System.out.println("Last Name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("DOB: " + dob);
        System.out.println("Registration result: " + result);
        System.out.println("========================================");

        // Writes a status ok message
        resp.setContentType("application/json");
        if(result){
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("{\"status\": \"registration successful\"}");
        }
        else{
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("{\"status\": \"registration failed\"}");
        }
    }
}