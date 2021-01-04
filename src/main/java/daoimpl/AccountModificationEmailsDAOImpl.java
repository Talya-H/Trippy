package daoimpl;

import dao.AccountModificationEmailsDAO;
import dao.DriverDAO;
import dao.PassengerDAO;
import users.Driver;
import users.Passenger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AccountModificationEmailsDAOImpl implements AccountModificationEmailsDAO {

    final DriverDAO daoD = new DriverDAOImpl();
    final PassengerDAO daoP = new PassengerDAOImpl();
    
    public AccountModificationEmailsDAOImpl() {
    }

    @Override
    public void driverRegistrationConfirmationEmail(int DriverID) {

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
            message.setSubject("Registration Confirmation");
            message.setText("Hello, " + driver.getFirstName() + " " + driver.getLastName()
                    + "\n\n You've succesfully created your account on Trippy."
                    + "\n\n Use your username and password to sign in. "
                    + "\n\n Thank you for using our services. "
                    + "\n\n Have a good day. ");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public void passengerRegistrationConfirmationEmail(int passengerID) {

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
            message.setSubject("Registration Confirmation");
            message.setText("Hello, " + passenger.getFirstName() + " " + passenger.getLastName()
                    + "\n\n You've succesfully created your account on Trippy."
                    + "\n\n Use your username and password to sign in. "
                    + "\n\n Thank you for using our services. "
                    + "\n\n Have a good day. ");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void driverAccountTerminationConfirmationEmail(int DriverID) {
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
            message.setSubject("Account Termination Confirmation");
            message.setText("Hello, " + driver.getFirstName() + " " + driver.getLastName()
                    + "\n\n We've closed your Trippy account at your request."
                    + "\n\n We're sorry to see you go. "
                    + "\n\n Thank you for using our services. "
                    + "\n\n Have a good day. ");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void passengerAccountTerminationConfirmationEmail(int passengerID) {

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
            message.setSubject("Account Termination Confirmation");
            message.setText("Hello, " + passenger.getFirstName() + " " + passenger.getLastName()
                    + "\n\n We've closed your Trippy account at your request."
                    + "\n\n We're sorry to see you go. "
                    + "\n\n Thank you for using our services. "
                    + "\n\n Have a good day. ");
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
