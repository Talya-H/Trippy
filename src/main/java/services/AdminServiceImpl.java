package services;

import dao.AdminDAO;
import users.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    private final dao.AdminDAO AdminDAO;

    public AdminServiceImpl(AdminDAO adminDAO) {

        AdminDAO = adminDAO;

    }

    @Override
    public void insertAdmin(Admin admin) {

        AdminDAO.insertAdmin(admin);

    }

    @Override
    public Admin findById(int adminID) {

        return AdminDAO.findById(adminID);
    }

    @Override
    public List findByUsername(String username) {

        return AdminDAO.findByUsername(username);
    }

    @Override
    public void deleteDriverAccount(int driverID) {

        AdminDAO.deleteDriverAccount(driverID);

    }

    @Override
    public void deletePassengerAccount(int passengerID) {

        AdminDAO.deletePassengerAccount(passengerID);

    }

    @Override
    public void deleteTripRequest(int tripID) {

        AdminDAO.deleteTripRequest(tripID);

    }
}
