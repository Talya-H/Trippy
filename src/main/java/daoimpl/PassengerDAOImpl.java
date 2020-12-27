package daoimpl;

import dao.PassengerDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import users.Passenger;
import util.HibernateUtil;

import java.util.List;

public class PassengerDAOImpl implements PassengerDAO {

    public void insert(Passenger passenger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(passenger);
            tx.commit();
            session.close();
            System.out.println("");

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }

    }

    public void delete(int passengerID) {
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

    public Passenger findById(int passengerID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Passenger passenger = null;
        try {
            passenger = session.get(Passenger.class, passengerID);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return passenger;

    }

    public List listPassenger() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List passengers = null;
        try {
            tx = session.beginTransaction();
            passengers = session.createQuery("FROM Passenger ORDER BY passengerID").list();
            for (Object o : passengers) {
                Passenger passenger = (Passenger) o;
                System.out.print("Passenger id: " + passenger.getPassengerID());
                System.out.print("First Name: " + passenger.getFirstName());
                System.out.println("Last Name: " + passenger.getLastName());
                System.out.println("Phone Number: " + passenger.getPhoneNumber());
                System.out.println("Email: " + passenger.getEmail());
                System.out.println("Payment Method: " + passenger.getPayMethod());
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
        return passengers;
    }

    @Override
    public void update(Passenger passenger) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(passenger);
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
    public List findByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List PassengerbyUsername = null;
        try {

            PassengerbyUsername = session.createSQLQuery("SELECT * from TRIPPY_PASSENGER where USERNAME = " + "'" + username + "'").addEntity(Passenger.class).list();

            for (Object o : PassengerbyUsername) {
                Passenger passenger = (Passenger) o;
                System.out.print("passenger id: " + passenger.getPassengerID());
                System.out.print("First Name: " + passenger.getFirstName());
                System.out.println("Last Name: " + passenger.getLastName());
                System.out.println("Phone Number: " + passenger.getPhoneNumber());
                System.out.println("Email: " + passenger.getEmail());
                System.out.println("Payment Method: " + passenger.getPayMethod());

            }

            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return PassengerbyUsername;
    }

    @Override
    public int findPassengerIDfromUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List PassengerbyUser = null;
        int PASSENGERID = 0;
        try {

            PassengerbyUser = session.createSQLQuery("SELECT * FROM TRIPPY_PASSENGER WHERE USERNAME = " + "'" + username + "'").addEntity(Passenger.class).list();

            for (Object o : PassengerbyUser) {
                Passenger passenger = (Passenger) o;

                PASSENGERID = passenger.getPassengerID();

//                System.out.print("passenger id: " + passenger.getPassengerID());
            }

            System.out.println(PassengerbyUser);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return PASSENGERID;
    }
}
