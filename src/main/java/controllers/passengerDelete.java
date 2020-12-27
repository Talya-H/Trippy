package controllers;

import daoimpl.AccountModificationEmailsDAOImpl;
import daoimpl.PassengerDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.AccountModificationEmailsService;
import services.AccountModificationEmailsServiceImpl;
import services.PassengerService;
import services.PassengerServiceImpl;
import users.Passenger;

@Controller
public class passengerDelete {

    PassengerService daoServicePassenger = new PassengerServiceImpl(new PassengerDAOImpl());
    AccountModificationEmailsService accModEmail = new AccountModificationEmailsServiceImpl(new AccountModificationEmailsDAOImpl());

    @RequestMapping(value = "/DeletePassengerRequest", method = RequestMethod.GET)
    public ModelAndView deletePasssenger(@RequestParam("x") int id) {

        Passenger deletePassenger = daoServicePassenger.findById(id);

        System.out.println("This passenger will be deleted: " + deletePassenger);

        accModEmail.passengerAccountTerminationConfirmationEmail(id);

        daoServicePassenger.delete(id);

        ModelAndView model = new ModelAndView("DeleteAccount");

        String deleteMessage = "You've successfully deleted your passenger account.";

        model.addObject("deleteMessage", deleteMessage);

        return model;

    }
}
