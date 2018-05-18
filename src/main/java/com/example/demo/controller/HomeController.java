package com.example.demo.controller;


import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    StoreDAO storeDAO;

    @Autowired
    EmployeeDAO employeeDAO;


    @GetMapping(value = "home")
    public String home(Model model){



        model.addAttribute("employees", employeeDAO.viewEmployee());

        model.addAttribute("ga_total", storeDAO.viewTotalGa());
        model.addAttribute("fl_total", storeDAO.viewTotalFl());
        model.addAttribute("vas_total", storeDAO.viewTotalVas());
        model.addAttribute("accessory_total", storeDAO.viewTotalAcc());

        return "home";
    }


    @GetMapping(value = "/home_admin")
    public String home_admin(Model model){

        model.addAttribute("employees", employeeDAO.viewEmployee());

        model.addAttribute("ga_total", storeDAO.viewTotalGa());
        model.addAttribute("fl_total", storeDAO.viewTotalFl());
        model.addAttribute("vas_total", storeDAO.viewTotalVas());
        model.addAttribute("accessory_total", storeDAO.viewTotalAcc());

        return "home_admin";
    }



}
