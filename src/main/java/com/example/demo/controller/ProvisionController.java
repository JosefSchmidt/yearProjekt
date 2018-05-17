package com.example.demo.controller;

import com.example.demo.domain.Sale;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dao.SaleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProvisionController {


    @Autowired
    SaleDAO saleDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    @GetMapping(value = "/add_provision{id}")
    public String add_provision(Model model, @PathVariable("id") int id){

        model.addAttribute("sale", new Sale());

        model.addAttribute("id", employeeDAO.getEmployeeId(id));

        return "add_provision";
    }

    @PostMapping(value = "/add_provision")
    public String add_sale(@RequestParam int ga_low_amount,
                           @RequestParam int ga_med_amount,
                           @RequestParam int ga_high_amount,
                           @RequestParam int ga_super_high_amount,
                           @RequestParam int fl_low_amount,
                           @RequestParam int fl_med_amount,
                           @RequestParam int fl_high_amount,
                           @RequestParam int fl_super_high_amount,
                           @RequestParam int vas_amount,
                           @RequestParam int accessory_amount, @PathVariable("employee_id") int employee_id) {




        saleDAO.addSale(ga_low_amount,ga_med_amount,ga_high_amount,ga_super_high_amount,
                fl_low_amount,fl_med_amount,fl_high_amount,fl_super_high_amount,vas_amount,accessory_amount, );





        return "redirect:/home";
    }


}
