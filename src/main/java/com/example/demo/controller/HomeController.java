package com.example.demo.controller;


import com.example.demo.services.EmployeeService;
import com.example.demo.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @Autowired
    StoreService storeService;

    @Autowired
    EmployeeService employeeService;


    @GetMapping(value = "home")
    public String home(Model model){


        model.addAttribute("employees", employeeService.viewEmployee());

        model.addAttribute("ga_total", storeService.viewTotalGa());
        model.addAttribute("fl_total", storeService.viewTotalFl());
        model.addAttribute("vas_total", storeService.viewTotalVas());
        model.addAttribute("accessory_total", storeService.viewTotalVas());

        return "home";
    }


    @GetMapping(value = "/home_admin")
    public String home_admin(Model model){

        model.addAttribute("employees", employeeService.viewEmployee());

        return "home_admin";
    }



}
