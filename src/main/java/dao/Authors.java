package dao;

import models.Author;

import java.util.List;

public interface Authors {
    // will define two methods in this interface

    // retrieves all authors from the db
    List<Author> all();

    // inserts new authors into db
    void insert(Author author);
}
