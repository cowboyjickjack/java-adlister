package dao;

import com.mysql.cj.jdbc.Driver;
import config.Config;
import models.Ad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao() throws SQLException { // this is essentially making that ^^ connection work
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection( // we will use this connection to access the correct db
                Config.getUrl(),
                Config.getUser(),
                Config.getPassword()
        );
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        try {
            // Establish connection
            Statement statement = connection.createStatement();
            // Selecting everything from our ads table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ads");
            while (resultSet.next()) {
                Ad ad = new Ad(
                        1, // for now, we'll hardcode the user id
                        resultSet.getLong("user_id"),
                        resultSet.getString("title"),
                        resultSet.getString("description")
                );
                // NOW add it to the list!
                ads.add(ad);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) { // Getting Ad object and adding it to our db
        try {
            Statement statement = connection.createStatement();
            // Now updating the ads table
            statement.executeUpdate("INSERT INTO ads (user_id, title, description) VALUES (" + ad.getUserId() + ", '" + ad.getTitle() + "', '" + ad.getDescription() + "')", Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            // if resultSet is real/exists, continue
            if (resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e);
        }
        // return null in case it catches the exception :)
        return null;
    }
}
