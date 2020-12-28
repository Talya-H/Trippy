package daoimpl;

import dao.AccountModificationEmailsDAO;
import dao.DriverDAO;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.Test;
import users.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DriverDAOImplTest {

    @Test
    public void insert() {

        DriverDAO daoD = new DriverDAOImpl();

        AccountModificationEmailsDAO daoEmail = new AccountModificationEmailsDAOImpl();

        Driver driver1 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");

        daoD.insert(driver1);

        daoEmail.driverRegistrationConfirmationEmail(1);



    }


    @Test
    public void delete() {

        DriverDAO daoD = new DriverDAOImpl();
        AccountModificationEmailsDAO daoEmail = new AccountModificationEmailsDAOImpl();

        Driver driver2 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");
        Driver driver3 = new Driver("john", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");

        daoD.insert(driver2);
        daoD.insert(driver3);

        daoEmail.driverAccountTerminationConfirmationEmail(2);

        daoD.delete(2);

    }

    @Test
    public void update() {

        DriverDAO daoD = new DriverDAOImpl();

        Driver driver4 = new Driver("joella", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");

        Driver updateDriver = daoD.findById(1);

        updateDriver.setUsername("Kiel");
        updateDriver.setScore(9);
        updateDriver.setCarBrand("Mazda");

        daoD.update(updateDriver);


        System.out.println();

    }

    @Test
    public void listDriver() {
        DriverDAO daoD = new DriverDAOImpl();

        Driver driver5 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");
        Driver driver6 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");

        daoD.insert(driver5);
        daoD.insert(driver6);


        System.out.println("List all Drivers: ");

        List DriverList = daoD.listDriver();
        for (Object o : DriverList) {

            System.out.println(o);
        }

        System.out.println();

    }

    @Test
    void retrieveRandomDriverId() {

        DriverDAO daoD = new DriverDAOImpl();

        Driver driver9 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");
        daoD.insert(driver9);

        int RandomDriverID = daoD.retrieveRandomDriverId();

        System.out.println(RandomDriverID);
    }

    @Test
    void findByUsername() {

        DriverDAO daoD = new DriverDAOImpl();

        Driver driver7 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");
        daoD.insert(driver7);

        List DriverbyUsername = daoD.findByUsername("jojo");


    }

    @Test
    void findDriverIDfromUsername() {

        DriverDAO daoD = new DriverDAOImpl();

        Driver driver8 = new Driver("jojo", "jo", "jon", "dor", 8598958, "hackett.talya@gmail.com", "Tesla 3");
        daoD.insert(driver8);

        int Id = daoD.findDriverIDfromUsername("jojo");

//        System.out.println(Id.get(0));


        System.out.println(Id);
    }


}