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


    // logger admin ind på baggrund af Spring Sec, og sender ham over til index
    @GetMapping(value = {"/login",})
    public String login(){

        return "login";
    }

    //index redirector til "home_admin".
    @GetMapping(value = {"/", ""})
    public String index(){

        return "redirect:/home_admin";
    }


    // logger admin ud
    @PostMapping(value = "/logout")
    public String logout(){

        return "login";
    }

}
