package controllers;

import daoimpl.DriverDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.DriverService;
import services.DriverServiceImpl;
import users.Driver;

import java.util.List;

@Controller
public class driverUpdate {
    DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());

    @RequestMapping(value = "/updateDriverRequest", method = RequestMethod.GET)
    public ModelAndView getUpdateForm(@RequestParam("x") int id) {

        Driver updateDriver = daoServiceDriver.findById(id);

        ModelAndView model = new ModelAndView("driverUpdateForm");

        model.addObject("drv", updateDriver);

        return model;

    }

    @RequestMapping(value = "/driverUpdateFilled", method = RequestMethod.POST)
    public ModelAndView retrieveUpdateFormFilled(@RequestAttribute("drv")
                                                 @RequestParam("username") String username,
                                                 @RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName,
                                                 @RequestParam("phoneNumber") long phoneNumber,
                                                 @RequestParam("carBrand") String carBrand,
                                                 @RequestParam("email") String email,
                                                 @RequestParam("password") String password) {

        ModelAndView model = new ModelAndView("driverPortal");

       int id = daoServiceDriver.findDriverIDfromUsername(username);

        Driver updateDriver = daoServiceDriver.findById(id);

        updateDriver.setUsername(username);
        updateDriver.setFirstName(firstName);
        updateDriver.setLastName(lastName);
        updateDriver.setPhoneNumber(phoneNumber);
        updateDriver.setCarBrand(carBrand);
        updateDriver.setEmail(email);
        updateDriver.setPassword(password);

        daoServiceDriver.update(updateDriver);

        List DriverInfo = daoServiceDriver.findByUsername(username);

        model.addObject("Driver", DriverInfo);

        String savedUpdateMessage = "Your changes were succesfuly saved!";

        model.addObject("savedMessage", savedUpdateMessage);

        return model;

    }


}
