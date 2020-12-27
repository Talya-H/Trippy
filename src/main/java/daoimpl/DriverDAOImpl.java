package daoimpl;

import dao.DriverDAO;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.spi.NativeQueryImplementor;
import users.Driver;
import util.HibernateUtil;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DriverDAOImpl implements DriverDAO {


    public DriverDAOImpl() {
    }

    @Override
    public void insert(Driver driver) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(driver);
            tx.commit();
            session.close();
            System.out.println("");

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int driverID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Driver driver = session.get(Driver.class, driverID);
            session.delete(driver);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();

        }

    }

    @Override
    public Driver findById(int driverID) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Driver driver = null;
        try {
            driver = session.get(Driver.class, driverID);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public void update(Driver driver) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(driver);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List listDriver() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List drivers = null;
        try {
            tx = session.beginTransaction();
            drivers = session.createQuery("FROM Driver ORDER BY driverID").list();
            for (Object o : drivers) {
                Driver driver = (Driver) o;
                System.out.print("driver id: " + driver.getDriverID());
                System.out.print("First Name: " + driver.getFirstName());
                System.out.println("Last Name: " + driver.getLastName());
                System.out.println("Phone Number: " + driver.getPhoneNumber());
                System.out.println("Email: " + driver.getEmail());
                System.out.println("Car Brand: " + driver.getCarBrand());
                System.out.println("Score: " + driver.getScore());

            }
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return drivers;
    }

    @Override
    public List findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List DriverbyUsername = null;
        try {

            DriverbyUsername = session.createSQLQuery("SELECT * from TRIPPY_DRIVER where USERNAME = " + "'" + username + "'").addEntity(Driver.class).list();

            for (Object o : DriverbyUsername) {
                Driver driver = (Driver) o;
                System.out.print("driver id: " + driver.getDriverID());
                System.out.print("First Name: " + driver.getFirstName());
                System.out.println("Last Name: " + driver.getLastName());
                System.out.println("Phone Number: " + driver.getPhoneNumber());
                System.out.println("Email: " + driver.getEmail());
                System.out.println("Car Brand: " + driver.getCarBrand());
                System.out.println("Score: " + driver.getScore());

            }

            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return DriverbyUsername;
    }

    @Override
    public int findDriverIDfromUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List DriverbyUser = null;
        int DRIVERID = 0;
        try {

            DriverbyUser = session.createSQLQuery("SELECT * FROM TRIPPY_DRIVER WHERE USERNAME = " + "'" + username + "'").addEntity(Driver.class).list();

            for (Object o : DriverbyUser) {
                Driver driver = (Driver) o;

                DRIVERID = driver.getDriverID();

//                System.out.print("driver id: " + driver.getDriverID());
            }

            System.out.println(DriverbyUser);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return DRIVERID;
    }

    @Override
    public int retrieveRandomDriverId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List driveridList;
        int DRIVERID = 0;
        try {
            tx = session.beginTransaction();

            driveridList = session.createSQLQuery("SELECT * FROM TRIPPY_DRIVER ORDER BY dbms_random.RANDOM()").addEntity(Driver.class).list();

            for (Object o : driveridList) {
                Driver driver = (Driver) o;

                DRIVERID = driver.getDriverID();

//                System.out.print("driver id: " + driver.getDriverID());
            }

        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return DRIVERID;

    }

}
