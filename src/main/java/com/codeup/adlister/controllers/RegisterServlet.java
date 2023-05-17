package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.codeup.adlister.controllers.LoginServlet.validAttempt;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // TODO: show the registration form
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // TODO: create a new user based off of the submitted information
        // TODO: if a user was successfully created, send them to their profile
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        User user = DaoFactory.getUsersDao().findByUsername(username);

        if (!inputHasErrors(username, email, password, confirmPassword, user)) {
            System.out.println("Valid login by:" + user.getUsername());
            request.getSession().setAttribute("user", user);
            // won't send them to profile right away, what if they are a spam bot
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/register");
        }
    }

    public static boolean inputHasErrors(String username, String email, String password, String confirmPassword, User user) {
        // the following would flag errors:
        // if user already exists
        if (user != null) {
            return true;
        }
        // if password != confirm password
        if (!password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
}
