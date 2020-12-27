package daoimpl;

import dao.DriverDAO;
import dao.PassengerDAO;
import dao.TripDAO;
import org.junit.jupiter.api.Test;
import reservation.Trip;
import users.Driver;
import users.Passenger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripDAOImplTest {

    @Test
    void insert() {

        TripDAO daoT = new TripDAOImpl();

        Trip trip1 = new Trip("Montreal", "Toronto", "2", "5/11/2020");

        daoT.insert(trip1);
    }

    @Test
    void delete() {

        TripDAO daoT = new TripDAOImpl();

        Trip trip2 = new Trip("Montreal", "Toronto", "2", "October 3 2020");
        Trip trip3 = new Trip("Montreal", "Toronto", "2", "October 3 2020");

        daoT.insert(trip2);
        daoT.insert(trip3);

        daoT.delete(2);
    }

    @Test
    void findById() {
//
//        TripDAO daoT = new TripDAOImpl();
//
//        Trip trip4 = new Trip("Montreal", "Toronto", 2, );
//
//        daoT.insert(trip4);
//
//        daoT.findById(4);
    }

    @Test
    void listTrip() {

        TripDAO daoT = new TripDAOImpl();

        Trip trip5 = new Trip("Montreal", "Toronto", "2", "October 3 2020");
        Trip trip6 = new Trip("Montreal", "Toronto", "2", "October 3 2020");

        daoT.insert(trip5);
        daoT.insert(trip6);

        daoT.listTrip();
    }

    @Test
    void update() {

        TripDAO daoT = new TripDAOImpl();

        Trip trip7 = new Trip("Montreal", "Toronto", "2", "October 3 2020");

        daoT.insert(trip7);

        Trip updateTrip = daoT.findById(1);

        updateTrip.setDrop("Here");
        updateTrip.setPickup("Quebec");

        daoT.update(updateTrip);

    }

    @Test
    void findByPassengerId() {

        DriverDAO daoD = new DriverDAOImpl();

        Driver driver8 = new Driver("jojo", "jo", "jon", "dor", 8598958, "T", "Tesla 3");
        daoD.insert(driver8);


        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass9 = new Passenger("reil", "jo", "jon", "dor", 8598958, "T", "Visa");
        daoP.insert(pass9);

        TripDAO daoT = new TripDAOImpl();

        Trip trip7 = new Trip("Montreal", "Toronto", "2", "October 3 2020");


        int assignDriverID = daoD.retrieveRandomDriverId();

        int assignPasssengerID = daoP.findPassengerIDfromUsername("reil");

        trip7.setDriverID(assignDriverID);
        trip7.setpassengerID(assignPasssengerID);

        daoT.insert(trip7);

        List TripList = daoT.findByPassengerId(assignPasssengerID);

        System.out.println(TripList);

    }

    @Test
    void findByDriverId() {
        DriverDAO daoD = new DriverDAOImpl();

        Driver driver8 = new Driver("jojo", "jo", "jon", "dor", 8598958, "T", "Tesla 3");
        daoD.insert(driver8);


        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass9 = new Passenger("reil", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Visa");
        daoP.insert(pass9);

        TripDAO daoT = new TripDAOImpl();

        Trip trip7 = new Trip("Montreal", "Toronto", "2", "October 3 2020");


        int assignDriverID = daoD.retrieveRandomDriverId();

        int assignPasssengerID = daoP.findPassengerIDfromUsername("reil");

        trip7.setDriverID(assignDriverID);
        trip7.setpassengerID(assignPasssengerID);

        daoT.insert(trip7);

        List TripList = daoT.findByDriverId(assignDriverID);

        System.out.println(TripList);

    }

    @Test
    void driverNewTripAlert() {

        DriverDAO daoD = new DriverDAOImpl();

        Driver driver8 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@outlook.com", "Tesla 3");
        daoD.insert(driver8);

         int diverid = daoD.findDriverIDfromUsername("jojo");

        TripDAO daoT = new TripDAOImpl();

         daoT.driverNewTripAlert(diverid);
    }

    @Test
    void passengerTripConfirmation() {

        PassengerDAO daoP = new PassengerDAOImpl();

        int PasssengerID = daoP.findPassengerIDfromUsername("reil");

        TripDAO daoT = new TripDAOImpl();

        daoT.passengerTripConfirmation(PasssengerID);

    }
}