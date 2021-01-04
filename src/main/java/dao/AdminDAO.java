package dao;

public interface AdminDAO {

    void deleteDriverAccount(int driverID);

    void deletePassengerAccount(int passengerID);

    void deleteTripRequest(int tripID);

}
