package controllers;

import dao.Authors;
import dao.AuthorsDao;
import dao.Quotes;
import dao.QuotesDao;
import models.Quote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/quotes")
public class QuotesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quotes quotesDao = new QuotesDao();
        List<Quote> quotes = quotesDao.all();

        request.setAttribute("quotes", quotes);
        request.getRequestDispatcher("/quotes.jsp").forward(request, response);

    }

}
