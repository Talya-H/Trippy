package daoimpl;

import dao.AdminDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import users.Driver;
import users.Passenger;
import reservation.Trip;
import util.HibernateUtil;

public class AdminDAOImpl implements AdminDAO {


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
