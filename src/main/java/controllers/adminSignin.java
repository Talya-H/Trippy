package controllers;

import daoimpl.AdminDAOImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.AdminService;
import services.AdminServiceImpl;
import users.Admin;
import users.Driver;

import java.util.List;

@Controller
public class adminSignin {

    AdminService daoServiceAdmin = new AdminServiceImpl(new AdminDAOImpl());

    @RequestMapping(value = "/adminSignin", method = RequestMethod.GET)
    public ModelAndView getDriverSigninForm() {

        ModelAndView model = new ModelAndView("adminSignInPage");

        model.addObject("ASignin", new Admin());

        return model;

    }

    @RequestMapping(value = "/adminSignInFilled", method = RequestMethod.POST)
    public ModelAndView getSignInFormFilled(@ModelAttribute("ASignin") @RequestParam("username") String username,
                                            @RequestParam("password") String password) {


        ModelAndView model  = new ModelAndView("adminPortal");


        List AdminInfo = daoServiceAdmin.findByUsername(username);

        System.out.println(AdminInfo);

        model.addObject("Admin", AdminInfo);


        System.out.println("sign in success");

//        }

        return model;
    }
}
