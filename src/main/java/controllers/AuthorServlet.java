package controllers;

import dao.Authors;
import dao.AuthorsDao;
import dao.DaoFactory;
import models.Author;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/authors")
public class AuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authors authorsDao = new AuthorsDao();
        List<Author> authors = authorsDao.all();
        request.setAttribute("authors", authors);
        request.getRequestDispatcher("authors.jsp").forward(request, response);
    }

}
