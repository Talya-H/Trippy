package controllers;

import daoimpl.PassengerDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.PassengerService;
import services.PassengerServiceImpl;
import users.Driver;
import users.Passenger;

import java.util.List;

@Controller
public class passengerUpdate {
    PassengerService daoServicePassenger = new PassengerServiceImpl(new PassengerDAOImpl());

    @RequestMapping(value = "/updatePassengerRequest", method = RequestMethod.GET)
    public ModelAndView getUpdateForm(@RequestParam("x") int id) {

        Passenger updatePassenger = daoServicePassenger.findById(id);

        ModelAndView model = new ModelAndView("passengerUpdateForm");

        model.addObject("psg", updatePassenger);


        return model;

    }

    @RequestMapping(value = "/passengerUpdateFilled", method = RequestMethod.POST)
    public ModelAndView retrieveUpdateFormFilled(@RequestAttribute("psg") @RequestParam("username") String username,
                                                 @RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName,
                                                 @RequestParam("phoneNumber") long phoneNumber,
                                                 @RequestParam("payMethod") String payMethod,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("password") String password) {

        ModelAndView model = new ModelAndView("passengerPortal");

        int id = daoServicePassenger.findPassengerIDfromUsername(username);

        Passenger updatePassenger = daoServicePassenger.findById(id);

        updatePassenger.setUsername(username);
        updatePassenger.setFirstName(firstName);
        updatePassenger.setLastName(lastName);
        updatePassenger.setPhoneNumber(phoneNumber);
        updatePassenger.setPayMethod(payMethod);
        updatePassenger.setEmail(email);
        updatePassenger.setPassword(password);

        daoServicePassenger.update(updatePassenger);

        List PassengerInfo = daoServicePassenger.findByUsername(username);

        model.addObject("Passenger", PassengerInfo);

        String savedUpdateMessage = "Your changes were succesfuly saved!";

        model.addObject("savedMessage", savedUpdateMessage);

        return model;
    }
}
