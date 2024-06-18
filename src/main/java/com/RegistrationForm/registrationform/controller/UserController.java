package com.RegistrationForm.registrationform.controller;

import com.RegistrationForm.registrationform.entity.User;
import com.RegistrationForm.registrationform.exception.UserException;
import com.RegistrationForm.registrationform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    //For getting the register page
    @GetMapping("/register")
    public ModelAndView signup(Model model){
        model.addAttribute("user", new User());
        return new ModelAndView("register");
    }

    //For posting of our user details
    @PostMapping("/register")
    public ModelAndView register(@ModelAttribute("user") User user) throws UserException {
        userService.save(user);
        return new ModelAndView("redirect:/register?success");
    }

    //For access the user detail by username
    @GetMapping("/user/username/{username}")
    public ModelAndView getUserDetails(@PathVariable String username, Model model) throws UserException{
        User user = userService.getDetails(username);
        model.addAttribute("user", user);
        return new ModelAndView("userDetails");
    }
}
