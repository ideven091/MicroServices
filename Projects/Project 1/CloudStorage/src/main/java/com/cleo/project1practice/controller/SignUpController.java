package com.cleo.project1practice.controller;

import com.cleo.project1practice.domain.User;
import com.cleo.project1practice.repositories.UserRepository;
import com.cleo.project1practice.services.HashService;
import com.cleo.project1practice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/signup")
public class SignUpController {

  private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String signupView() {
        return "signup";
    }

    //I want to sleep

    @PostMapping()
    public String signUpUser(@ModelAttribute User user, Model model) {
        String error = null;
        User user1 = userService.saveUser(user);
        if(user1==null) {
            error = "User cannot be added for unknown reason";
            /*HashMap<String,String> map = new HashMap<>();
            map.put(error,"signupError");
            */
            model.addAttribute("signupError",error);
        }


        model.addAttribute("signupSuccess",true);

        return "signup";

    }
}
