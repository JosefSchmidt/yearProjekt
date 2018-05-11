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
                        int accessories_amount) {


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
                        accessories_amount);

        jdbcTemplate.update("INSERT INTO provision(ga_low_prov, ga_med_prov, ga_high_prov, ga_super_high_prov, fl_low_prov, fl_med_prov, fl_high_prov, fl_super_high_prov, vas_prov, accessory_prov) VALUES (?,?,?,?,?,?,?,?,?,?)",
                ga_low_amount * Provision.getGa_low(),
                ga_med_amount * Provision.getGa_med(),
                ga_high_amount * Provision.getGa_high(),
                ga_super_high_amount * Provision.getGa_super_high(),
                fl_low_amount * Provision.getFl_low(),
                fl_med_amount * Provision.getFl_med(),
                fl_high_amount * Provision.getFl_high(),
                fl_super_high_amount * Provision.getFl_super_high(),
                vas_amount * Provision.getVas(),
                accessories_amount * Provision.getAccessories());


    }
}
