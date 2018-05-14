package com.example.demo.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {



    @GetMapping(value = {"/login",})
    public String login(){
        return "login";
    }


    @GetMapping(value = {"/"})
    public String index(){

        return "redirect:/home_admin";
    }

    @PostMapping(value = "/logout")
    public String logout(){

        return "redirect:/home";
    }

}
