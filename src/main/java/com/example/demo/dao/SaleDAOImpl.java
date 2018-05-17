package com.example.demo.dao;

import com.example.demo.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class SaleDAOImpl implements SaleDAO {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    //tilføjer en instance af Sale til tabellen, sale.
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
                        int accessory_amount,
                        int id) {


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO sale(employee_id, ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessory_amount) VALUES (?,?,?,?,?,?,?,?,?,?,?)",
                        id,
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


//        @Override
//        public void addSale(Sale sale){
//
//
//            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//            jdbcTemplate.update("INSERT into sale (ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessory_amount)" + "VALUES ('" + sale.getGa_low_amount()+ "', '" + sale.getGa_med_amount() + "', '" + sale.getGa_high_amount() + "', '" + sale.getGa_super_high_amount()
//                    + sale.getFl_low_amount() + sale.getFl_med_amount() + sale.getFl_high_amount() + sale.getFl_super_high_amount() + sale.getVas_amount() + + sale.getAccessory_amount() + "')");
//
//
//        }


}
