package com.wyds2.wyds2.Controllers;


import com.wyds2.wyds2.Models.User;
import com.wyds2.wyds2.Services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class RegisterController {

    private PasswordEncoder encoder;
    private UserService userService;




    @Autowired
    public RegisterController(UserService userService){
       // this.encoder = encoder;
        this.userService = userService;
    }


    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult) {

        // Lookup user in database by e-mail
        User userExists = userService.findByEmail(user.getEmail());
        System.out.println(userExists);

        if (userExists != null) {
            modelAndView.setViewName("register");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        }
        else {

            user.setEnabled(true);
            user.setConfirmationToken(UUID.randomUUID().toString());
            userService.saveUser(user);

        }

        return modelAndView;
    }






}
