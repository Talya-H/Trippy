package dao;

import users.Admin;

import java.util.List;

public interface AdminDAO {

    void insertAdmin(Admin admin);

    Admin findById(int adminID);

    List findByUsername(String username);

    void deleteDriverAccount(int driverID);

    void deletePassengerAccount(int passengerID);

    void deleteTripRequest(int tripID);

}
