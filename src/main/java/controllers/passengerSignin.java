package controllers;

import daoimpl.PassengerDAOImpl;
import daoimpl.TripDAOImpl;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.PassengerService;
import services.PassengerServiceImpl;
import services.TripService;
import services.TripServiceImpl;
import users.Passenger;

import java.util.List;

@Controller
public class passengerSignin {

    PassengerService daoServicePassenger = new PassengerServiceImpl(new PassengerDAOImpl());
    TripService daoServiceTrip = new TripServiceImpl(new TripDAOImpl());

    @RequestMapping(value = "/passengerSignin", method = RequestMethod.GET)
    public ModelAndView getPassengerSigninForm(){

        ModelAndView model = new ModelAndView("passengerSignInPage");

        model.addObject("PSignin",new Passenger());

        return model;

    }

    @RequestMapping(value = ("/passengerSignInFilled"), method = RequestMethod.POST)
    public ModelAndView getSignInFormFiled(@ModelAttribute("PSignin") @RequestParam("username") String username,
                                           @RequestParam("password") String password){



        ModelAndView model = new ModelAndView("passengerPortal");

                //username and password verification here ....

        List PassengerInfo = daoServicePassenger.findByUsername(username);

        int PassengerID = daoServicePassenger.findPassengerIDfromUsername(username);

        List TripList = daoServiceTrip.findByPassengerId(PassengerID);

        model.addObject("Passenger", PassengerInfo);
        model.addObject("Trip", TripList);

        return model;

    }
}
