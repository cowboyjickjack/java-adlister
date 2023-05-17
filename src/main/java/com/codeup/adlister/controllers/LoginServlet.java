package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // the line of code below says if someone is logged in, they cannot go to the login page
        // and will instead go back to their profile
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // grabbing username/password from the field
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // getUsersDao -> if not defined, go and define it with the config
        // and here, it's ready to go!
        User user = DaoFactory.getUsersDao().findByUsername(username);

        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        boolean validAttempt = false;

        if (validAttempt(username, password, user)) {
            // TODO: store the logged in user object in the session, instead of just the username
            System.out.println("Valid login by:" + user.getUsername());
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }

    public static boolean validAttempt(String username, String password, User user) {
        // need to null check user to use it!
        if (user == null) {
            return false;
        }
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
