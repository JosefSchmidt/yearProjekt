package com.example.demo.controller;

import com.example.demo.domain.Provision;
import com.example.demo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProvisionController {


    @Autowired
    SaleService saleService;

    @GetMapping(value = "/add_provision")
    public String add_provision(Model model){

        model.addAttribute("provision", new Provision());

        return "add_provision";
    }

    @PostMapping(value = "/add_provision")
    public String add_provision(@RequestParam String ga_low_amount,
                                @RequestParam String ga_med_amount,
                                @RequestParam String ga_high_amount,
                                @RequestParam String ga_super_high_amount,
                                @RequestParam String fl_low_amount,
                                @RequestParam String fl_med_amount,
                                @RequestParam String fl_high_amount,
                                @RequestParam String fl_super_high_amount,
                                @RequestParam String vas_amount,
                                @RequestParam String accessories_amount){


        saleService.addProvision(ga_low_amount,ga_med_amount,ga_high_amount,ga_super_high_amount,
                fl_low_amount,fl_med_amount,fl_high_amount,fl_super_high_amount,vas_amount,accessories_amount);


        return "redirect:/home";
    }


}
