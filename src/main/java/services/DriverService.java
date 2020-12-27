package services;

import users.Driver;

import java.util.List;

public interface DriverService {

    void insert(Driver driver);

    void delete(int driverID);

    Driver findById(int driverID);

    List<Driver> listDriver();

    void update(Driver driver);

    List findByUsername(String username);

    int retrieveRandomDriverId();   //retrieves random Driver ID that will be for the assignment of a driver to a trip

    int findDriverIDfromUsername(String username);
//
////    admin exclusive feature?

}
