package dao;

import models.Post;

import java.util.List;

public interface Posts { // This will set up a protocol for what the DAO(data access object) should do

    List<Post> all(); // abstract method that returns a list of posts
                        // purpose is to access and retrieve our data layer (all our posts)

    void insert(Post post); // does nothing, just inserts post into our data storage

}
