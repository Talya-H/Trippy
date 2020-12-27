package services;

import reservation.Trip;

import java.util.List;

public interface TripService {

    void insert(Trip trip);

    void delete(int tripID);

    Trip findById(int tripID);

    List<Trip> listTrip();

    void update(Trip trip);

    List<Trip> findByPassengerId(int passengerID);

    List<Trip> findByDriverId(int DriverID);

    void driverNewTripAlert(int DriverID);

    void passengerTripConfirmation(int passengerID);

}
