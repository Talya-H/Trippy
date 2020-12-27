package controllers;

import daoimpl.DriverDAOImpl;
import daoimpl.PassengerDAOImpl;
import daoimpl.TripDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import reservation.Trip;
import services.*;
import users.Passenger;

import java.util.List;


@Controller
public class tripRegister {

    TripService daoServiceTrip = new TripServiceImpl(new TripDAOImpl());
    DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());
    PassengerService daoServicePassenger = new PassengerServiceImpl(new PassengerDAOImpl());

    @RequestMapping(value = "/tripReservation", method = RequestMethod.GET)
    public ModelAndView getPassRegisterForm(@RequestParam("x") int id) {

        ModelAndView model = new ModelAndView("/tripReserve");

        Passenger passengerRequestingTrip = daoServicePassenger.findById(id);

        model.addObject("passengerUsername", passengerRequestingTrip.getUsername());
        model.addObject("T", new Trip());

        return model;

    }

    @RequestMapping(value = "/tripReservationFilled", method = RequestMethod.POST)
    public ModelAndView getReservationFormFilled(@ModelAttribute("T") @RequestParam("username") String username,
                                                 @RequestParam("pickup") String pickup,
                                                 @RequestParam("drop") String drop,
                                                 @RequestParam("pickupTime") String pickupTime,
                                                 @RequestParam("pickupDate") String pickupDate) {

        ModelAndView model = new ModelAndView("/passengerPortal");

        System.out.println(pickupDate);

        Trip newTrip = new Trip(pickup, drop, pickupTime, pickupDate);

        int assignDriverID = daoServiceDriver.retrieveRandomDriverId();

        int assignPasssengerID = daoServicePassenger.findPassengerIDfromUsername(username);

        newTrip.setDriverID(assignDriverID);
        newTrip.setpassengerID(assignPasssengerID);

        daoServiceTrip.insert(newTrip);

        daoServiceTrip.driverNewTripAlert(assignDriverID);

        List PassengerInfo = daoServicePassenger.findByUsername(username);

        int PassengerID = daoServicePassenger.findPassengerIDfromUsername(username);

        System.out.println(PassengerInfo);

        daoServiceTrip.passengerTripConfirmation(PassengerID);

        List  TripList = daoServiceTrip.findByPassengerId(PassengerID);

        model.addObject("Passenger", PassengerInfo);
        model.addObject("Trip", TripList);

        return model;

    }
}
