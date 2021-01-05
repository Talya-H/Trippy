package daoimpl;

import dao.AdminDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import users.Admin;
import users.Driver;
import users.Passenger;
import reservation.Trip;
import util.HibernateUtil;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {


    @Override
    public void insertAdmin(Admin admin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(admin);
            tx.commit();
            session.close();
            System.out.println();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }

    }

    @Override
    public Admin findById(int adminID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Admin admin = null;
        try {
            admin = session.get(Admin.class, adminID);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return admin;
    }

    @Override
    public List findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List AdminbyUsername = null;
        try {

            AdminbyUsername = session.createSQLQuery("SELECT * from TRIPPY_ADMIN where USERNAME = " + "'" + username + "'").addEntity(Admin.class).list();

            for (Object o : AdminbyUsername) {
                Admin admin = (Admin) o;
                System.out.print("admin username: " + admin.getUsername());

            }

            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return AdminbyUsername;
    }


    @Override
    public void deleteDriverAccount(int driverID) {
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
    public void deletePassengerAccount(int passengerID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Passenger passenger = session.get(Passenger.class, passengerID);
            session.delete(passenger);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();

        }

    }

    @Override
    public void deleteTripRequest(int tripID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            Trip trip = session.get(Trip.class, tripID);
            session.delete(trip);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }

    }
}
