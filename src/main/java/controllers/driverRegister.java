package controllers;

import dao.DriverDAO;
import daoimpl.AccountModificationEmailsDAOImpl;
import daoimpl.DriverDAOImpl;
import daoimpl.TripDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.*;
import users.Driver;

import java.util.List;


@Controller
public class driverRegister {

    DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());
    TripService daoServiceTrip = new TripServiceImpl(new TripDAOImpl());
    AccountModificationEmailsService accModEmail = new AccountModificationEmailsServiceImpl(new AccountModificationEmailsDAOImpl());


    @RequestMapping(value = "/driverRegister", method = RequestMethod.GET)
    public ModelAndView getDriverRegisterForm() {

        ModelAndView model = new ModelAndView("driverRegistration");

        model.addObject("D", new Driver());

        return model;

    }

    @RequestMapping(value = "/FilledDriverRegistration", method = RequestMethod.POST)
    public ModelAndView getFilledRegistrationFrom(@ModelAttribute("D") @RequestParam("username") String username,
                                                  @RequestParam("firstName") String firstName,
                                                  @RequestParam("lastName") String lastName,
                                                  @RequestParam("phoneNumber") long phoneNumber,
                                                  @RequestParam("carBrand") String carBrand,
                                                  @RequestParam("email") String email,
                                                  @RequestParam("password") String password) {

        ModelAndView model = new ModelAndView("driverPortal");

        Driver newDriver = new Driver(username, password, firstName, lastName, phoneNumber, email, carBrand);

        daoServiceDriver.insert(newDriver);

        System.out.println(newDriver);

        List DriverInfo = daoServiceDriver.findByUsername(username);

        int DriverId = daoServiceDriver.findDriverIDfromUsername(username);

        accModEmail.driverRegistrationConfirmationEmail(DriverId);

        List TripList = daoServiceTrip.findByDriverId(DriverId);

        System.out.println(DriverInfo);


        model.addObject("Driver", DriverInfo);
        model.addObject("Trip", TripList);

        return model;


    }
}
