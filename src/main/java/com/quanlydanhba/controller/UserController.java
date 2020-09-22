package com.quanlydanhba.controller;

import com.quanlydanhba.model.Category;
import com.quanlydanhba.model.User;
import com.quanlydanhba.service.ICategoryService;
import com.quanlydanhba.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/users")
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
        return "redirect:/users/find";
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

    @GetMapping("/find")
    public ModelAndView findByName(@RequestParam("keyword") Optional<String> keyword,
                                   @PageableDefault(value = 5, page = 0)
                                   @SortDefault(sort = "username", direction = Sort.Direction.DESC)
                                           Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/list");
        Page<User> userPage = userService.findAllByUserContaining(keyword.orElse(""), pageable);
        modelAndView.addObject("users", userPage);
        modelAndView.addObject("keyword",keyword.orElse(""));
        return modelAndView;

    }
}
