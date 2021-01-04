package intial;

import dao.DriverDAO;
import dao.PassengerDAO;
import dao.TripDAO;
import daoimpl.DriverDAOImpl;
import daoimpl.PassengerDAOImpl;
import daoimpl.TripDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import reservation.Trip;
import services.DriverService;
import services.DriverServiceImpl;
import services.TripService;
import services.TripServiceImpl;
import users.Driver;
import users.Passenger;

import java.util.List;

public class run {

    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");

        DriverDAO daoD = new DriverDAOImpl();
        PassengerDAO daoP = new PassengerDAOImpl();
        TripDAO daoT = new TripDAOImpl();

        Driver driver1 = (Driver) app.getBean("driver1");
        daoD.insert(driver1);

        Passenger passenger1 = (Passenger) app.getBean("passenger1");
        daoP.insert(passenger1);

        Trip trip1 = (Trip) app.getBean("trip1");

        int assignDriver = daoD.retrieveRandomDriverId();

        System.out.println(assignDriver);

        trip1.setDriverID(assignDriver);

        daoT.insert(trip1);


//        DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());
//        TripService daoServiceTrip = new TripServiceImpl(new TripDAOImpl());
//
//         String username = "test";
//
//        List DriverInfo = daoServiceDriver.findByUsername(username);
//
//        System.out.println(DriverInfo);
//
//        int DriverId = daoServiceDriver.findDriverIDfromUsername(username);
//
//        System.out.println(DriverId);
//
//        List TripList = daoServiceTrip.findByDriverId(DriverId);
//
//        System.out.println(TripList);


    }
}
