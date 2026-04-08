package com.pravas.login.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.pravas.login.dao.UserDAO;
import com.pravas.login.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Validation
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            resp.getWriter().println("All fields are required");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        UserDAO dao = new UserDAO();

        if (dao.register(user)) {
            resp.sendRedirect("success.jsp");
        } else {
            resp.getWriter().println("Registration Failed");
        }
    }
}