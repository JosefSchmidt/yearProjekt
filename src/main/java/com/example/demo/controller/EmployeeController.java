package com.example.demo.controller;

import com.example.demo.dao.SaleDAO;
import com.example.demo.domain.Employee;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDAO employeeDAO;

    @Autowired
    SaleDAO saleDAO;


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

    @GetMapping(value = "/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") int id){

        employeeDAO.deleteEmployee(id);

        return "redirect:/home_admin";
    }

    @GetMapping(value = "/sale_info")
    public String sale_info(Model model, @RequestParam("id") int id){



        model.addAttribute("sales", saleDAO.viewEmployeeSales(id));

        model.addAttribute("ga_total", saleDAO.viewEmployeeTotalGa(id));
        model.addAttribute("fl_total", saleDAO.viewEmployeeTotalFl(id));
        model.addAttribute("vas_total", saleDAO.viewEmployeeTotalVas(id));
        model.addAttribute("accessory_total", saleDAO.viewEmployeeTotalAcc(id));



        model.addAttribute("sale", new Sale(id));

        return "sale_info";
    }









}
