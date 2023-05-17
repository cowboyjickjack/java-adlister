package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import config.Config;

import java.sql.*;

public class MySQLUsersDao implements Users{
    private Connection connection;
    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUser(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    // establishing connection to the DB and finding username with query
    @Override
    public User findByUsername(String username){
        // eventually going to return a User object, so won't return null
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            // just preparing the connection, not executing YET
            PreparedStatement stmt = connection.prepareStatement(query);
            // 1 = position of the question mark, and second variable
            // is what we're feeding it, what we want it to scrub
            stmt.setString(1, username);
            // execute query to get
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username");
        }
    }

    // this will actually insert it into the Users table!
    public Long insert(User user) {
        // don't start with id - idk what it will be since it auto-increments
        // ? is the variable that they'll fit into
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            // execute update to insert
            stmt.executeUpdate();
            // all the columns will be in this result set now
            ResultSet rs = stmt.getGeneratedKeys();
            // since it's all in rs, no need for a loop. Just do the one
            rs.next();
            // then return rs from position 1!
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username");
        }
    }
    
    // private bc we're not running this method outside of this class
    // can throw the SQL Exception!
    // Kind of like a UTILITY METHOD.....
    private User extractUser(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            // if it comes up with nothing, return null
            return null;
        }
        // constructs new user!
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }
}
