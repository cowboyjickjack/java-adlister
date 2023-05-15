package dao;

import models.Quote;

import java.util.List;

public interface Quotes {

    List<Quote> all(); // any data access object that interacts with the DAO, it must have an insert method
    void insert (Quote quote);
}
