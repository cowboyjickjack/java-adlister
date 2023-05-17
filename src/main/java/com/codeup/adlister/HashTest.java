package com.codeup.adlister;

import org.mindrot.jbcrypt.BCrypt;

public class HashTest {

    public static void main(String[] args) {
        String salt = BCrypt.gensalt();
        System.out.println(salt);
    }

}
