package com.quanlydanhba.controller;

import com.quanlydanhba.model.User;
import com.quanlydanhba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public String showList(){
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }
}
