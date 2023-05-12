package dao;

import models.Ad;

import java.util.List;

public interface Ads { // We use the interface to access data, and implement it from the DaoFactory!!!
    // this defines what the Dao will do
    // Allows ListAdoDao to be variable
    List<Ad> all();
}
