package com.example.demo.controller;

import com.example.demo.dao.SaleDAOImpl;
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

    //Tilføjer id til en konstruktor af Sale og tilføjer en instance af sale i model.
    // Her tilføjes resten af sales attributerne via thymeleaf (add_provision html)
    @GetMapping(value = "/add_sale")
    public String add_sale(Model model, @RequestParam("id") int id){

        Sale sale = new Sale(id);
        model.addAttribute("sale", sale);

        return "add_provision";
    }

    //Tilføjer en instance af sale til metoden addSale.
    @PostMapping(value = "/add_sale")
    public String add_sale(@ModelAttribute Sale sale) {

        saleDAO.addSale(sale);

        return "redirect:/home";
    }


    // Sletter et salg på baggrund af sale_id
    @GetMapping(value = "/delete_sale")
    public String deleteEmployee(@RequestParam("id") int id){

        saleDAO.deleteSale(id);

        return "redirect:/home";

    }
}
