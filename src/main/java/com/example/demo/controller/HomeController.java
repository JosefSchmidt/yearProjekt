package com.example.demo.controller;


import com.example.demo.domain.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


    @Autowired
    EmployeeService employeeService;


    @GetMapping(value = "home")
    public String home(Model model){

        model.addAttribute("employees", employeeService.viewEmployee());

        return "home";
    }


    @GetMapping(value = "/home_admin")
    public String home_admin(Model model){

        model.addAttribute("employees", employeeService.viewEmployee());

        return "home_admin";
    }



}
