package dao;

import models.Ad;

import java.util.List;

<<<<<<< HEAD
public interface Ads { // We use the interface to access data, and implement it from the DaoFactory!!!
    // this defines what the Dao will do
    // Allows ListAdoDao to be variable
    List<Ad> all();
=======
public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
>>>>>>> jdbc-lecture
}
