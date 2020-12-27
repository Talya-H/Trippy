package services;

import users.Passenger;

import java.util.List;

public interface PassengerService {

    void insert(Passenger passenger);

    void delete(int passengerID);

    Passenger findById(int passengerID);

    List<Passenger> listPassenger();

    void update(Passenger passenger);

    List findByUsername(String username);

    int findPassengerIDfromUsername(String username);


}
