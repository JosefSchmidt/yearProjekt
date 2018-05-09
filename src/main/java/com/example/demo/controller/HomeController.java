package com.example.demo.controller;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @GetMapping(value = "home")
    public String home(){
        return "home";
    }


    @GetMapping(value = "/home_admin")
    public String home_admin(){
        return "home_admin";
    }



}
