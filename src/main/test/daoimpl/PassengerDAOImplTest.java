package daoimpl;

import dao.PassengerDAO;
import org.junit.jupiter.api.Test;
import users.Passenger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PassengerDAOImplTest {

    @Test
    void insert() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass1 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        daoP.insert(pass1);
    }

    @Test
    void delete() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass2 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        Passenger deletePassenger = daoP.findById(2);

        System.out.println("Passenger to be deleted found using find by id method " + deletePassenger);

        daoP.delete(2);
    }

    @Test
    void findById() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass3 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        daoP.findById(3);
    }

    @Test
    void listPassenger() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass4 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        Passenger pass5 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        Passenger pass6 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        daoP.insert(pass4);
        daoP.insert(pass5);
        daoP.insert(pass6);
    }

    @Test
    void update() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass7 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        daoP.insert(pass7);

        System.out.println("Passenger berfore update: " + pass7);

        Passenger updatePassenger = daoP.findById(4);

        updatePassenger.setUsername("Kiel");
        updatePassenger.setPayMethod("MC");
        updatePassenger.setEmail("This");

        daoP.update(updatePassenger);
    }

    @Test
    void findByUsername() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass8 = new Passenger("jo", "jo", "jon", "dor", 8598958, "T", "Visa");

        daoP.insert(pass8);

        List PassengerbyUsername = daoP.findByUsername("jo");

    }

    @Test
    void findPassengerIDfromUsername() {

        PassengerDAO daoP = new PassengerDAOImpl();

        Passenger pass9 = new Passenger("reil", "jo", "jon", "dor", 8598958, "T", "Visa");

        daoP.insert(pass9);

        int Id = daoP.findPassengerIDfromUsername("reil");

        System.out.println(Id);


    }
}