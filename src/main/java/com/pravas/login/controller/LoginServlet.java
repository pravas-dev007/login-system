package com.pravas.login.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.pravas.login.dao.UserDAO;
import com.pravas.login.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        UserDAO dao = new UserDAO();

        // Now DAO returns User object
        User user = dao.login(email, password);

        if (user != null) {

            HttpSession session = req.getSession();

            // Store username in session (not email)
            session.setAttribute("user", user.getName());

            resp.sendRedirect("dashboard.jsp");

        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("<h3>Invalid Credentials</h3>");
            resp.getWriter().println("<a href='login.html'>Try Again</a>");
        }
    }
}