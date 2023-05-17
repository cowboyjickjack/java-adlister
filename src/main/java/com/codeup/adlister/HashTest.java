package com.codeup.adlister;

import org.mindrot.jbcrypt.BCrypt;

public class HashTest {

    public static void main(String[] args) {
        String password = "123456";
        // SALTING adds random characters
        String salt = BCrypt.gensalt();
        System.out.println(salt);
        // HASHING then converts it to consistent ciphertext
        String hash = BCrypt.hashpw(password, salt);
        System.out.println(hash);

        // CHECK PASSWORD
        boolean passwordsMatch = BCrypt.checkpw(password, hash);
        System.out.println(passwordsMatch);
    }

}
