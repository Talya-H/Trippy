package controllers;

import daoimpl.DriverDAOImpl;
import daoimpl.TripDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.DriverService;
import services.DriverServiceImpl;
import services.TripService;
import services.TripServiceImpl;
import users.Driver;

import java.util.List;

@Controller
public class driverSignin {

    DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());
    TripService daoServiceTrip = new TripServiceImpl(new TripDAOImpl());

    @RequestMapping(value = "/driverSignin", method = RequestMethod.GET)
    public ModelAndView getDriverSigninForm() {

        ModelAndView model = new ModelAndView("driverSignInPage");

        model.addObject("DSignin", new Driver());

        return model;

    }

    @RequestMapping(value = "/driverSignInFilled", method = RequestMethod.POST)
    public ModelAndView getSignInFormFilled(@ModelAttribute("DSignin") @RequestParam("username") String username,
                                    @RequestParam("password") String password) {


//        String tryUsername = username;
//        String tryPassword = password;
//
//        int DriverId = daoServiceDriver.findDriverIDfromUsername(username);
//
//        Driver verifyDriver = daoServiceDriver.findById(DriverId);

        ModelAndView model = null;

//        if (!tryUsername.equals(verifyDriver.getUsername()) && !tryPassword.equals(verifyDriver.getPassword())) {
//
//            model = new ModelAndView("driverSignInPage");
//
//            String wrongCredentialsMessage = "Oops! Something's not adding up. Try again.";
//
//            model.addObject("wrongCredentialsMessage", wrongCredentialsMessage);
//            model.addObject("DSignin", new Driver());
//
//            System.out.println("sign in error");
//
//            return model;
//
//
//        } else if (tryUsername.equals(verifyDriver.getUsername()) && tryPassword.equals(verifyDriver.getPassword())) {

            model = new ModelAndView("driverPortal");

            List DriverInfo = daoServiceDriver.findByUsername(username);

            System.out.println(DriverInfo);

            int DriverId = daoServiceDriver.findDriverIDfromUsername(username);

            System.out.println(DriverId);

            List TripList = daoServiceTrip.findByDriverId(DriverId);

            System.out.println(TripList);


            model.addObject("Driver", DriverInfo);
            model.addObject("Trip", TripList);

            System.out.println("sign in success");

//        }

            return model;
    }
}
