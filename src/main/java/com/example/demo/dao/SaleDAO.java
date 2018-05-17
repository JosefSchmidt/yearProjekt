package com.example.demo.dao;


import com.example.demo.domain.Sale;

public interface SaleDAO {


    void addSale(int ga_low_amount,
                 int ga_med_amount,
                 int ga_high_amount,
                 int ga_super_high_amount,
                 int fl_low_amount,
                 int fl_med_amount,
                 int fl_high_amount,
                 int fl_super_high_amount,
                 int vas_amount,
                 int accessory_amount,
                 int id);




}
