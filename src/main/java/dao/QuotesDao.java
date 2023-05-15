package dao;

import com.mysql.cj.jdbc.Driver;
import models.Author;
import models.Quote;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuotesDao implements Quotes{
    private Connection connection;

    public QuotesDao(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/bigfoot_test_db?allowPublicKeyRetrieval=true&useSSL=false",
                    "codeup_test_user",
                    "codeup");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Quotes> all() {
        // Get a reference to the authors Data Access Object
        // So I can retrieve the list of authors
        Authors authorsDao = new AuthorsDao();
        // retrieve all the authors in the database
        // Store the list in a list called Authors
        List<Author> authors = authorsDao.all();
        // Then I create a list to store the quotes
        List<Quotes> quotes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quotes");
            // Then I start looping over all the quotes that I retrieve from the db
            while (resultSet.next()){
                // For each quote, I get the author id first
                int author_id = resultSet.getInt("author id");
                // I create an Author object that will hold the author information corresponding to the author id
                Author quoteAuthor = null;
                // I loop over the list of all the authors
                for (Author author : authors){
                    // If I find a match between author ids, I set the value of the Author object!
                    if (author.getId() == author_id){
                        quoteAuthor = author;
                    }
                }
                Quote quote = new Quote(
                        resultSet.getLong("id"),
                        resultSet.getString("content"),
                        quoteAuthor
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return quotes;
    }

    @Override
    public void insert(Quote quote) {

    }
}
