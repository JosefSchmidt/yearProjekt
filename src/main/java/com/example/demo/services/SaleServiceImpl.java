package com.example.demo.services;

import com.example.demo.domain.Provision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class SaleServiceImpl implements SaleService {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;


    @Override
    public void addSale(int ga_low_amount,
                        int ga_med_amount,
                        int ga_high_amount,
                        int ga_super_high_amount,
                        int fl_low_amount,
                        int fl_med_amount,
                        int fl_high_amount,
                        int fl_super_high_amount,
                        int vas_amount,
                        int accessory_amount) {


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO sale(ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessory_amount) VALUES (?,?,?,?,?,?,?,?,?,?)",
                        ga_low_amount,
                        ga_med_amount,
                        ga_high_amount,
                        ga_super_high_amount,
                        fl_low_amount,
                        fl_med_amount,
                        fl_high_amount,
                        fl_super_high_amount,
                        vas_amount,
                        accessory_amount);

    }
}
