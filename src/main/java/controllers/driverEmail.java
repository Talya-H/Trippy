package controllers;

import daoimpl.DriverDAOImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.DriverService;
import services.DriverServiceImpl;
import users.Driver;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class driverEmail {
    DriverService daoServiceDriver = new DriverServiceImpl(new DriverDAOImpl());

    @RequestMapping
    public ModelAndView emailDriver(@RequestParam("x") int id){

        Driver emailDriver = daoServiceDriver.findById(id);

        ModelAndView model = new ModelAndView("driverPortal");

        return model;
    }
}
