package controllers;


import daoimpl.AccountModificationEmailsDAOImpl;
import daoimpl.DriverDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.AccountModificationEmailsService;
import services.AccountModificationEmailsServiceImpl;
import services.DriverService;
import services.DriverServiceImpl;
import users.Driver;

@Controller
public class driverDelete {

    DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());
    AccountModificationEmailsService accModEmail = new AccountModificationEmailsServiceImpl(new AccountModificationEmailsDAOImpl());

    @RequestMapping(value = "/DeleteDriverRequest", method = RequestMethod.GET)
    public ModelAndView deleteDriver(@RequestParam("x") int id) {

        Driver deleteDriver = daoServiceDriver.findById(id);

        System.out.println("This driver will be deleted: " + deleteDriver);

        accModEmail.driverAccountTerminationConfirmationEmail(id);

        daoServiceDriver.delete(id);

        ModelAndView model = new ModelAndView("DeleteAccount");

        String deleteMessage = "You've successfully deleted your driver account.";

        model.addObject("deleteMessage", deleteMessage);

        return model;

    }
}
