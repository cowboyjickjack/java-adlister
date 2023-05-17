package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    // 'if you're going to implement me, you need to define two things':
    User findByUsername(String username);
    // long bc of the id
    Long insert(User user);
}
