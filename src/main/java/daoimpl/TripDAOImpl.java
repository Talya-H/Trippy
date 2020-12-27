package daoimpl;

import dao.DriverDAO;
import dao.PassengerDAO;
import dao.TripDAO;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import reservation.Trip;
import users.Passenger;
import util.HibernateUtil;
import users.Driver;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class TripDAOImpl implements TripDAO {

    DriverDAO daoD = new DriverDAOImpl();
    PassengerDAO daoP = new PassengerDAOImpl();

    @Override
    public void insert(Trip trip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.save(trip);
            tx.commit();
            session.close();

        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int tripID) {
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

    @Override
    public Trip findById(int tripID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Trip trip = null;
        try {
            trip = session.get(Trip.class, tripID);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return trip;
    }

    @Override
    public List listTrip() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List trips = null;
        try {
            tx = session.beginTransaction();
            trips = session.createQuery("FROM Trip ORDER BY tripID").list();
            for (Object o : trips) {
                Trip trip = (Trip) o;
                System.out.print("Trip id: " + trip.getTripID());
                System.out.print("Pick-up Time: " + trip.getPickup());
                System.out.println("Drop-off Location: " + trip.getDrop());
                System.out.println("Pick-up Time: " + trip.getPickupTime());
                System.out.println("Date: " + trip.getPickupDate());
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
        return trips;
    }

    @Override
    public void update(Trip trip) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(trip);
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
    public List<Trip> findByPassengerId(int passengerID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List TripbyPassengerID = null;
        try {

            TripbyPassengerID = session.createSQLQuery("SELECT * from TRIPPY_TRIP where passengerID = " + "'" + passengerID + "'").addEntity(Trip.class).list();

            for (Object o : TripbyPassengerID) {
                Trip trip = (Trip) o;
                System.out.print("Trip id: " + trip.getTripID());
                System.out.print("Pickup address: " + trip.getPickup());
                System.out.println("Drop address: " + trip.getDrop());
                System.out.println("Pickup time: " + trip.getPickupTime());
                System.out.println("Pickup date: " + trip.getPickupDate());
                System.out.println("Driver ID: " + trip.getDriverID());
                System.out.println("Passenger ID: " + trip.getpassengerID());

            }

            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return TripbyPassengerID;
    }

    @Override
    public List<Trip> findByDriverId(int DriverID) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List TripbyDriverID = null;
        try {

            TripbyDriverID = session.createSQLQuery("SELECT * from TRIPPY_TRIP where DRIVERID = " + "'" + DriverID + "'").addEntity(Trip.class).list();

            for (Object o : TripbyDriverID) {
                Trip trip = (Trip) o;
                System.out.print("Trip id: " + trip.getTripID());
                System.out.print("Pickup address: " + trip.getPickup());
                System.out.println("Drop address: " + trip.getDrop());
                System.out.println("Pickup time: " + trip.getPickupTime());
                System.out.println("Pickup date: " + trip.getPickupDate());
                System.out.println("Driver ID: " + trip.getDriverID());
                System.out.println("Passenger ID: " + trip.getpassengerID());

            }

            tx.commit();
            session.close();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return TripbyDriverID;
    }

    @Override
    public void driverNewTripAlert(int DriverID) {

        Driver driver = daoD.findById(DriverID);

        final String username = "talya.programmingprojects@gmail.com";    //sender email
        final String password = "programmingprojects";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //  Session session = Session.getDefaultInstance(props);        //
        javax.mail.Session sessione = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

//            creating email message

            Message message = new MimeMessage(sessione);
            message.setFrom(new InternetAddress("talya.programmingprojects@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(driver.getEmail()));
            message.setSubject("New Trip Alert");
            message.setText("Hello, " + driver.getFirstName() + " " + driver.getLastName()
                    + "\n\n You've received a new trip request."
                    + "\n\n Log in to your Trippy account to view the details. "
                    + "\n\n Thank you for using our services. "
                    + "\n\n Have a good day. ");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void passengerTripConfirmation(int passengerID) {

        Passenger passenger = daoP.findById(passengerID);

        final String username = "talya.programmingprojects@gmail.com";    //sender email
        final String password = "programmingprojects";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        //  Session session = Session.getDefaultInstance(props);        //
        javax.mail.Session sessione = javax.mail.Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

//            creating email message

            Message message = new MimeMessage(sessione);
            message.setFrom(new InternetAddress("talya.programmingprojects@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(passenger.getEmail()));
            message.setSubject("Trip Confirmation Alert");
            message.setText("Hello, " + passenger.getFirstName() + " " + passenger.getLastName()
                    + "\n\n This is your trip confirmation."
                    + "\n\n Please sign in to your Trippy account to view the details."
                    + "\n\n Thank you for using our services. "
                    + "\n\n Have a good day. ");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

}



