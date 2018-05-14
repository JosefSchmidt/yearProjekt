package com.example.demo.controller;

import com.example.demo.domain.Sale;
import com.example.demo.services.ProvisionService;
import com.example.demo.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProvisionController {


    @Qualifier("provisionServiceImpl")
    @Autowired
    ProvisionService provisionService;


    @Autowired
    SaleService saleService;

    @GetMapping(value = "/add_provision")
    public String add_provision(Model model){

        model.addAttribute("provision", new Sale());

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
                                @RequestParam int accessory_amount){


        provisionService.addProvision(ga_low_amount,ga_med_amount,ga_high_amount,ga_super_high_amount,
                fl_low_amount,fl_med_amount,fl_high_amount,fl_super_high_amount,vas_amount,accessory_amount);


        saleService.addSale(ga_low_amount,ga_med_amount,ga_high_amount,ga_super_high_amount,
                fl_low_amount,fl_med_amount,fl_high_amount,fl_super_high_amount,vas_amount,accessory_amount);





        return "redirect:/home";
    }


}
