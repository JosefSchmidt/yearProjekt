package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;


    @GetMapping(value = "/add_employee")
    public String add_employee(Model model){

        model.addAttribute("employee", new Employee());

        return "add_employee";
    }

    @PostMapping(value = "/add_employee")
    public String add_employee(@RequestParam String name, @RequestParam String position, @RequestParam int provision_goal){

        employeeDAO.addEmployee(name, position, provision_goal);

        return "redirect:/home_admin";
    }





}
