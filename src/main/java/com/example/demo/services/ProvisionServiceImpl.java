package com.example.demo.services;

import com.example.demo.domain.Provision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ProvisionServiceImpl implements SaleService {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;


    @Override
    public void addProvision(String ga_low_amount,
                        String ga_med_amount,
                        String ga_high_amount,
                        String ga_super_high_amount,
                        String fl_low_amount,
                        String fl_med_amount,
                        String fl_high_amount,
                        String fl_super_high_amount,
                        String vas_amount,
                        String accessories_amount) {


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO provision(ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessories_amount) VALUES (?,?,?,?,?,?,?,?,?,?)",
                ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessories_amount);


    }



}
