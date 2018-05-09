package com.example.demo.services;


import com.example.demo.domain.Provision;
import org.springframework.web.bind.annotation.RequestParam;

public interface SaleService {


    void addProvision(String ga_low_amount,
                 String ga_med_amount,
                 String ga_high_amount,
                 String ga_super_high_amount,
                 String fl_low_amount,
                 String fl_med_amount,
                 String fl_high_amount,
                 String fl_super_high_amount,
                 String vas_amount,
                 String accessories_amount);



}
