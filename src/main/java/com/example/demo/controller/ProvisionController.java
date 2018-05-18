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

    @GetMapping(value = "/add_provision")
    public String add_provision(Model model, @RequestParam("id") int id){

        Sale sale = new Sale(id);
        model.addAttribute("sale", sale);

        return "add_provision";
    }

    @PostMapping(value = "/add_provision")
    public String add_sale(@ModelAttribute Sale sale) {

        saleDAO.addSale(sale);

        return "redirect:/home";
    }

    @GetMapping(value = "/deleteSale")
    public String deleteEmployee(@RequestParam("id") int id){

        saleDAO.deleteSale(id);

        return "redirect:/home";
    }


}
