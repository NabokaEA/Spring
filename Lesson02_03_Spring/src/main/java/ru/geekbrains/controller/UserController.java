package ru.geekbrains.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String listPage(Model model) {
        logger.info("Users list page requested");

        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        logger.info("New user page requested");

        model.addAttribute("user", new User());
        return "user_form";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        logger.info("Edit user page requested");
        model.addAttribute("user", userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found")));
        return "user_form";
    }


    @PostMapping
    public String update(User user) {
        logger.info("Save user");
        userRepository.save(user);
        return "redirect:/user";
    }

    @ExceptionHandler
    public ModelAndView NotfoundExceptionHandler(NotFoundException ex) {
        ModelAndView modelAndView = new ModelAndView("user_not_found");
        modelAndView.addObject("message",ex.getMessage());
        modelAndView.setStatus(HttpStatus.NOT_FOUND);
        return modelAndView;
    }


}
