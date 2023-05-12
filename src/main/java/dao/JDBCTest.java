package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {

    List<String> authorNames = new ArrayList<>();

    try{
        // Establish connection to the db
        DriverManager.registerDriver();
    } catch (SQLException sqlx){
        sqlx.printStackTrace();
    }
}
