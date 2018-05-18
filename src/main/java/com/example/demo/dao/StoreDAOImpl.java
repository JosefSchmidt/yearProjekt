package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class StoreDAOImpl implements StoreDAO {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;


    @Override
    public int viewTotalGa() {

        int low_total = 0;
        int med_total = 0;
        int high_total = 0;
        int super_high_total = 0;


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //List<Integer> modtager et Integer obejct via aggregate funktionen, sum, som lægger alle rows fra en attribut - hertil ga_low_amount.
        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(ga_low_amount) FROM sale", Integer.class);


        //rows fra tabellen, sale, lægges sammen
        for (int i = 0; i <list_low.size(); i++) {
            if (list_low.get(i) != null) {
                low_total = list_low.get(i);
            }
        }


        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(ga_med_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_med.size(); i++) {
            if(list_med.get(i) != null) {
                med_total = list_med.get(i);
            }
        }

        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(ga_high_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_high.size(); i++) {
            if(list_high.get(i) != null) {
                high_total = list_high.get(i);
            }
        }

        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(ga_super_high_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_super_high.size(); i++) {
            if(list_super_high.get(i) != null) {
                super_high_total = list_super_high.get(i);
            }
        }

        return low_total + med_total + high_total + super_high_total;
    }

    @Override
    public int viewTotalFl() {

        int low_total = 0;
        int med_total = 0;
        int high_total = 0;
        int super_high_total = 0;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(fl_low_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_low.size(); i++) {
            if(list_low.get(i) != null) {
                low_total = list_low.get(i);
            }
        }

        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(fl_med_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_med.size(); i++) {
            if(list_med.get(i) != null) {
                med_total = list_med.get(i);
            }
        }

        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(fl_high_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_high.size(); i++) {
            if(list_high.get(i) != null) {
                high_total = list_high.get(i);
            }
        }

        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(fl_super_high_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_high.size(); i++) {
            if(list_super_high.get(i) != null) {
                super_high_total = list_super_high.get(i);
            }
        }

        return low_total + med_total + high_total + super_high_total;


    }

    @Override
    public int viewTotalVas() {

        int vas_total = 0;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_vas = jdbcTemplate.queryForList("SELECT SUM(vas_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_vas.size(); i++) {
            if(list_vas.get(i) != null) {
                vas_total = list_vas.get(i);
            }
        }

        return vas_total;
    }

    @Override
    public int viewTotalAcc() {

        int accessory_total = 0;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_accessory = jdbcTemplate.queryForList("SELECT SUM(accessory_amount) FROM sale", Integer.class);

        for (int i = 0; i <list_accessory.size(); i++) {
            if (list_accessory.get(i) != null) {
                accessory_total = list_accessory.get(i);
            }
        }
        return accessory_total;
    }
}