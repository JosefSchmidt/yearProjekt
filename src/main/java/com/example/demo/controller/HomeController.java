package com.example.demo.controller;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping(value = "home")
    public String home(){
        return "home";
    }


    @GetMapping(value = {"/login",})
    public String login(){
        return "login";
    }


    @GetMapping(value = {"","/","/index"})
    public String index(){

        if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {

            return "redirect:/home_admin";
        }
        return "redirect:/login";
    }


    @GetMapping(value = "/home_admin")
    public String home_admin(){

        return "home_admin";
    }

}
