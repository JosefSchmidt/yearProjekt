package com.example.demo.dao;

import com.example.demo.domain.Employee;
import com.example.demo.domain.Provision;
import com.example.demo.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SaleDAOImpl implements SaleDAO {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

//    //tilføjer en instance af Sale til tabellen, sale.
//    @Override
//    public void addSale(int ga_low_amount,
//                        int ga_med_amount,
//                        int ga_high_amount,
//                        int ga_super_high_amount,
//                        int fl_low_amount,
//                        int fl_med_amount,
//                        int fl_high_amount,
//                        int fl_super_high_amount,
//                        int vas_amount,
//                        int accessory_amount,
//                        int id) {
//
//
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        jdbcTemplate.update("INSERT INTO sale(employee_id, ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessory_amount) VALUES (?,?,?,?,?,?,?,?,?,?,?)",
//                        id,
//                        ga_low_amount,
//                        ga_med_amount,
//                        ga_high_amount,
//                        ga_super_high_amount,
//                        fl_low_amount,
//                        fl_med_amount,
//                        fl_high_amount,
//                        fl_super_high_amount,
//                        vas_amount,
//                        accessory_amount);
//    }


    @Override
    public void addSale(Sale sale){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update("INSERT into sale (employee_id, ga_low_amount, ga_med_amount, ga_high_amount, ga_super_high_amount, fl_low_amount, fl_med_amount, fl_high_amount, fl_super_high_amount, vas_amount, accessory_amount)" +
                "VALUES ('" + sale.getEmployee_id() + "', '" + sale.getGa_low_amount()+ "', '" + sale.getGa_med_amount() + "', '" + sale.getGa_high_amount() + "', '" + sale.getGa_super_high_amount()+ "', '" + sale.getFl_low_amount()+ "', '" + sale.getFl_med_amount()+ "', '" + sale.getFl_high_amount()+ "', '" + sale.getFl_super_high_amount()+ "', '" + sale.getVas_amount()+ "', '" + sale.getAccessory_amount() + "')");

    }

    //returner en List af Sale på baggrund af id
    @Override
    public List viewEmployeeSales(int id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM sale WHERE sale_id="+id;

        List<Sale> sales = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        //For loop af rows (sales)
        for (Map row : rows) {

            Sale sale = new Sale();

            //Angiver keys til value
            sale.setSale_id((int) (row.get("sale_id")));
            sale.setGa_low_amount((int) (row.get("ga_low_amount")));
            sale.setGa_med_amount((int) (row.get("ga_med_amount")));
            sale.setGa_high_amount((int) (row.get("ga_high_amount")));
            sale.setGa_super_high_amount((int) (row.get("ga_super_high_amount")));

            sale.setFl_low_amount((int) (row.get("fl_low_amount")));
            sale.setFl_med_amount((int) (row.get("fl_med_amount")));
            sale.setFl_high_amount((int) (row.get("fl_high_amount")));
            sale.setFl_super_high_amount((int) (row.get("fl_super_high_amount")));

            sale.setVas_amount((int) (row.get("vad_amount)")));
            sale.setAccessory_amount((int) (row.get("accessory_amount")));

            //tilføjer til vores "sales" list
            sales.add(sale);

        }
        return sales;
    }

    @Override
    public void deleteSale(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("DELETE From sale WHERE sale_id="+id);
    }


    @Override
    public int viewEmployeeTotalGa(int id) {
        int low_total = 0;
        int med_total = 0;
        int high_total = 0;
        int super_high_total = 0;


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //List<Integer> modtager et Integer obejct via aggregate funktionen, sum, som lægger alle rows fra en attribut - hertil ga_low_amount.
        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(ga_low_amount) FROM sale WHERE sale_id="+id, Integer.class);

        //rows fra tabellen, sale, lægges sammen
        for (int i = 0; i <list_low.size(); i++) {
            low_total = list_low.get(i);
        }


        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(ga_med_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_med.size(); i++) {
            med_total = list_med.get(i);
        }

        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(ga_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_high.size(); i++) {
            high_total = list_high.get(i);
        }

        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(ga_super_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_super_high.size(); i++) {
            super_high_total = list_super_high.get(i);
        }

        return low_total + med_total + high_total + super_high_total;

    }

    @Override
    public int viewEmployeeTotalFl(int id) {
        int low_total = 0;
        int med_total = 0;
        int high_total = 0;
        int super_high_total = 0;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(fl_low_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_low.size(); i++) {
            low_total = list_low.get(i);
        }

        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(fl_med_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_med.size(); i++) {
            med_total = list_med.get(i);
        }

        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(fl_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_high.size(); i++) {
            high_total = list_high.get(i);
        }

        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(fl_super_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_high.size(); i++) {
            super_high_total = list_super_high.get(i);
        }

        return low_total + med_total + high_total + super_high_total;

    }

    @Override
    public int viewEmployeeTotalVas(int id) {
        int vas_total = 0;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_vas = jdbcTemplate.queryForList("SELECT SUM(vas_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_vas.size(); i++) {
            vas_total = list_vas.get(i);
        }

        return vas_total;
    }

    @Override
    public int viewEmployeeTotalAcc(int id) {
        int accessory_total = 0;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_accessory = jdbcTemplate.queryForList("SELECT SUM(accessory_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_accessory.size(); i++) {
            accessory_total = list_accessory.get(i);
        }
        return accessory_total;
    }



    @Override
    public int viewProvisionTotal(int id) {
        int low_ga_total = 0;
        int med_ga_total = 0;
        int high_ga_total = 0;
        int super_high_ga_total = 0;
        int ga_total = 0;

        int low_fl_total = 0;
        int med_fl_total = 0;
        int high_fl_total = 0;
        int super_high_fl_total = 0;
        int fl_total = 0;

        int vas_total = 0;

        int accessory_total = 0;

        int provisionTotal = 0;


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //SAMLER GA-POINT

        //List<Integer> modtager et Integer obejct via aggregate funktionen, sum, som lægger alle rows fra en attribut - hertil ga_low_amount.
        List<Integer> list_ga_low = jdbcTemplate.queryForList("SELECT SUM(ga_low_amount) FROM sale WHERE sale_id="+id, Integer.class);

        //rows fra tabellen, sale, lægges sammen
        for (int i = 0; i <list_ga_low.size(); i++) {

            //Ganger med attributen i instancen Provision for at få samlet point
            low_ga_total = list_ga_low.get(i) * Provision.getGa_low();
        }


        List<Integer> list_ga_med = jdbcTemplate.queryForList("SELECT SUM(ga_med_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_ga_med.size(); i++) {
            med_ga_total = list_ga_med.get(i) * Provision.getGa_med();
        }

        List<Integer> list_ga_high = jdbcTemplate.queryForList("SELECT SUM(ga_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_ga_high.size(); i++) {
            high_ga_total = list_ga_high.get(i) * Provision.getGa_high();
        }

        List<Integer> list_ga_super_high = jdbcTemplate.queryForList("SELECT SUM(ga_super_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_ga_super_high.size(); i++) {
            super_high_ga_total = list_ga_super_high.get(i) * Provision.getGa_super_high();
        }

        ga_total = low_ga_total + med_ga_total + high_ga_total + super_high_ga_total;




        //SAMLER FL-POINT

        List<Integer> list_fl_low = jdbcTemplate.queryForList("SELECT SUM(fl_low_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_fl_low.size(); i++) {
            low_fl_total = list_fl_low.get(i) * Provision.getFl_low();
        }

        List<Integer> list_fl_med = jdbcTemplate.queryForList("SELECT SUM(fl_med_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_fl_med.size(); i++) {
            med_fl_total = list_fl_med.get(i) * Provision.getFl_med();
        }

        List<Integer> list_fl_high = jdbcTemplate.queryForList("SELECT SUM(fl_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_fl_high.size(); i++) {
            high_fl_total = list_fl_high.get(i) * Provision.getFl_high();
        }

        List<Integer> list_fl_super_high = jdbcTemplate.queryForList("SELECT SUM(fl_super_high_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_fl_high.size(); i++) {
            super_high_fl_total = list_fl_super_high.get(i) * Provision.getFl_super_high();
        }

        fl_total = low_fl_total + med_fl_total + high_fl_total + super_high_fl_total;




        //SAMLER VAS-POINT

        List<Integer> list_vas = jdbcTemplate.queryForList("SELECT SUM(vas_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_vas.size(); i++) {
            vas_total = list_vas.get(i) * Provision.getVas();
        }


        //SAMLER ACCESSORY-POINT

        List<Integer> list_accessory = jdbcTemplate.queryForList("SELECT SUM(accessory_amount) FROM sale WHERE sale_id="+id, Integer.class);

        for (int i = 0; i <list_accessory.size(); i++) {
            accessory_total = list_accessory.get(i) * Provision.getAccessories();
        }


        //SAMLER PROVISION TOTAL

        provisionTotal = ga_total+fl_total+vas_total+accessory_total;


        return provisionTotal;
    }



}
