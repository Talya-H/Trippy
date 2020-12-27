package services;

import dao.TripDAO;
import reservation.Trip;

import java.util.List;

public class TripServiceImpl implements TripService {

    private final dao.TripDAO TripDAO;

    public TripServiceImpl(TripDAO tripDAO) {
        TripDAO = tripDAO;
    }

    @Override
    public void insert(Trip trip) {

        TripDAO.insert(trip);
    }

    @Override
    public void delete(int tripID) {

        TripDAO.delete(tripID);

    }

    @Override
    public Trip findById(int tripID) {

        return TripDAO.findById(tripID);

    }

    @Override
    public List<Trip> listTrip() {

        return TripDAO.listTrip();
    }

    @Override
    public void update(Trip trip) {

        TripDAO.update(trip);
    }

    @Override
    public List<Trip> findByPassengerId(int passengerID) {

        return TripDAO.findByPassengerId(passengerID);
    }

    @Override
    public List<Trip> findByDriverId(int DriverID) {

        return TripDAO.findByDriverId(DriverID);
    }

    @Override
    public void driverNewTripAlert(int DriverID) {

        TripDAO.driverNewTripAlert(DriverID);
    }

    @Override
    public void passengerTripConfirmation(int passengerID) {

        TripDAO.passengerTripConfirmation(passengerID);
    }
}
