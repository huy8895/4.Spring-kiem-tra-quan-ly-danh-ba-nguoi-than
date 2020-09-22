package com.quanlydanhba.controller;

import com.quanlydanhba.model.Category;
import com.quanlydanhba.model.User;
import com.quanlydanhba.service.ICategoryService;
import com.quanlydanhba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @Autowired
    ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> provinces(){
        return categoryService.findAll();
    }

    @GetMapping
    public String showList(Model model){
        model.addAttribute("users",userService.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("user",new User());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView crete(User user){
        ModelAndView modelAndView = new ModelAndView("/create");
        userService.save(user);
        return modelAndView;
    }
}
