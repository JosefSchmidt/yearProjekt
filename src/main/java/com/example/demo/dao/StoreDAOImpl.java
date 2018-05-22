package com.example.demo.dao;

import com.example.demo.domain.Sale;
import com.example.demo.services.SaleService;
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

        int low_total, med_total, high_total, super_high_total;

        SaleService saleService = new SaleService();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //List<Integer> modtager et Integer obejct via aggregate funktionen, sum, som lægger alle rows fra en attribut - hertil ga_low_amount.
        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(ga_low_amount) FROM sale", Integer.class);
        //rows fra tabellen, sale, lægges sammen
        low_total = saleService.saleService(list_low);


        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(ga_med_amount) FROM sale", Integer.class);
        med_total = saleService.saleService(list_med);


        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(ga_high_amount) FROM sale", Integer.class);
        high_total = saleService.saleService(list_high);


        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(ga_super_high_amount) FROM sale", Integer.class);
        super_high_total = saleService.saleService(list_super_high);

        return low_total + med_total + high_total + super_high_total;
    }

    @Override
    public int viewTotalFl() {

        int low_total, med_total, high_total, super_high_total;

        SaleService saleService = new SaleService();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(fl_low_amount) FROM sale", Integer.class);
        low_total = saleService.saleService(list_low);

        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(fl_med_amount) FROM sale", Integer.class);
        med_total = saleService.saleService(list_med);

        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(fl_high_amount) FROM sale", Integer.class);
        high_total = saleService.saleService(list_high);

        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(fl_super_high_amount) FROM sale", Integer.class);
        super_high_total = saleService.saleService(list_super_high);

        return low_total + med_total + high_total + super_high_total;
    }

    @Override
    public int viewTotalVas() {

        int vas_total;

        SaleService saleService = new SaleService();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_vas = jdbcTemplate.queryForList("SELECT SUM(vas_amount) FROM sale", Integer.class);

        vas_total = saleService.saleService(list_vas);

        return vas_total;
    }

    @Override
    public int viewTotalAcc() {

        int accessory_total = 0;

        SaleService saleService = new SaleService();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_accessory = jdbcTemplate.queryForList("SELECT SUM(accessory_amount) FROM sale", Integer.class);
        accessory_total = saleService.saleService(list_accessory);

        return accessory_total;
    }
}
