package services;

import dao.PassengerDAO;
import users.Passenger;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {

    private final dao.PassengerDAO PassengerDAO;

    public  PassengerServiceImpl(PassengerDAO PassengerDAO){
        this.PassengerDAO = PassengerDAO;
    }

    @Override
    public void insert(Passenger passenger) {

        PassengerDAO.insert(passenger);
    }

    @Override
    public void delete(int passengerID) {

        PassengerDAO.delete(passengerID);
    }

    @Override
    public Passenger findById(int passengerID) {

        return PassengerDAO.findById(passengerID);
    }

    @Override
    public List<Passenger> listPassenger() {

        return PassengerDAO.listPassenger();
    }

    @Override
    public void update(Passenger passenger) {

        PassengerDAO.update(passenger);
    }

    @Override
    public List findByUsername(String username) {

        return PassengerDAO.findByUsername(username);
    }

    @Override
    public int findPassengerIDfromUsername(String username) {
        return PassengerDAO.findPassengerIDfromUsername(username);
    }


}
