package services;

import dao.DriverDAO;
import users.Driver;

import java.util.List;

public class DriverServiceImpl implements DriverService {

    private final dao.DriverDAO DriverDAO;

    public DriverServiceImpl(DriverDAO driverDAO) {

        DriverDAO = driverDAO;
    }


    @Override
    public void insert(Driver driver) {

        DriverDAO.insert(driver);

    }

    @Override
    public void delete(int driverID) {

        DriverDAO.delete(driverID);

    }

    @Override
    public Driver findById(int driverID) {

        return DriverDAO.findById(driverID);
    }

    @Override
    public List<Driver> listDriver() {

        return DriverDAO.listDriver();
    }

    @Override
    public void update(Driver driver) {

        DriverDAO.update(driver);
    }

    @Override
    public List findByUsername(String username) {

        return DriverDAO.findByUsername(username);
    }

    @Override
    public int retrieveRandomDriverId() {

        return DriverDAO.retrieveRandomDriverId();
    }

    @Override
    public int findDriverIDfromUsername(String username) {

        return DriverDAO.findDriverIDfromUsername(username);
    }

}
