package controllers;

import daoimpl.AccountModificationEmailsDAOImpl;
import daoimpl.PassengerDAOImpl;
import daoimpl.TripDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.*;
import users.Passenger;

import java.util.List;


@Controller
public class PassengerRegister {

    PassengerService daoServicePassenger = new PassengerServiceImpl(new PassengerDAOImpl());
    TripService daoServiceTrip = new TripServiceImpl(new TripDAOImpl());
    AccountModificationEmailsService accModEmail = new AccountModificationEmailsServiceImpl(new AccountModificationEmailsDAOImpl());

    @RequestMapping(value = "/passRegister", method = RequestMethod.GET)
    public ModelAndView getPassRegisterForm() {

        ModelAndView model = new ModelAndView("passengerRegistration");

        model.addObject("P", new Passenger());

        return model;

    }

    @RequestMapping(value = "/FilledPassengerRegistration", method = RequestMethod.POST)
    public ModelAndView getFilledRegistrationForm(@ModelAttribute("P") @RequestParam("username") String username,
                                                  @RequestParam("firstName") String firstName,
                                                  @RequestParam("lastName") String lastName,
                                                  @RequestParam("phoneNumber") long phoneNumber,
                                                  @RequestParam("payMethod") String payMethod,
                                                  @RequestParam("email") String email,
                                                  @RequestParam("password") String password) {

        ModelAndView model = new ModelAndView("passengerPortal");

        Passenger newPassenger = new Passenger(username, password, firstName, lastName, phoneNumber, email, payMethod);

        daoServicePassenger.insert(newPassenger);

        List PassengerInfo = daoServicePassenger.findByUsername(username);

        int PassengerID = daoServicePassenger.findPassengerIDfromUsername(username);

        accModEmail.passengerRegistrationConfirmationEmail(PassengerID);

        List TripList = daoServiceTrip.findByPassengerId(PassengerID);

        model.addObject("Passenger", PassengerInfo);
        model.addObject("Trip", TripList);

        return model;


    }
}
