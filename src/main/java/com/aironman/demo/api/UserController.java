package com.aironman.demo.api;

import com.aironman.demo.domain.model.User;
import com.aironman.demo.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/")
    public String login(){
        return "login";
    }

    @RequestMapping(path = "/init")
    public String initialize(){

        userService.initialize();
        List<User> aList = userService.listAll();
        for (User user:aList)
            System.out.println("User: " + user.toString());
        return "login";
    }

    @RequestMapping(path = "/list")
    public String listUsers(){


        return "login";
    }

    @RequestMapping(path = "/new-account")
    public String createNew(Model model){
        model.addAttribute("user",new User());
        return "new-account";
    }

    @RequestMapping(path = "new-account",method = RequestMethod.POST)
    public String createAccount(User user, BindingResult bindingResult){

        userService.create(user);
        return "redirect:/";

    }
}
