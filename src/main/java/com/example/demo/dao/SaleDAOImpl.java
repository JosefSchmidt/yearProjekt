package com.example.demo.dao;

import com.example.demo.domain.Sale;
import com.example.demo.services.ProvisionService;
import com.example.demo.services.SaleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SaleDAOImpl implements SaleDAO {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;


    @Autowired
    ProvisionService provisionService;

    @Autowired
    SaleService saleService;


    //Tilføjer sale objectet til tabellen sale.
    @Override
    public void addSale(Sale sale){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update("INSERT into sale (" +
                "employee_id, " +
                "ga_low_amount, " +
                "ga_med_amount, " +
                "ga_high_amount, " +
                "ga_super_high_amount, " +
                "fl_low_amount, " +
                "fl_med_amount, " +
                "fl_high_amount, " +
                "fl_super_high_amount, " +
                "vas_amount, " +
                "accessory_amount)" +
                "VALUES ('" +
                sale.getEmployee_id() + "', '" +
                sale.getGa_low_amount()+ "', '" +
                sale.getGa_med_amount() + "', '" +
                sale.getGa_high_amount() + "', '" +
                sale.getGa_super_high_amount()+ "', '" +
                sale.getFl_low_amount()+ "', '"
                + sale.getFl_med_amount()+ "', '" +
                sale.getFl_high_amount()+ "', '" +
                sale.getFl_super_high_amount()+ "', '" +
                sale.getVas_amount()+ "', '" +
                sale.getAccessory_amount() + "')");


        //opdater provision_accumulated
        viewProvisionTotal(sale.getEmployee_id());



    }

    //returner en List af Sale på baggrund af id
    @Override
    public List viewEmployeeSales(int id) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Sale> sales = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM sale WHERE employee_id="+id);

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

            sale.setVas_amount((int) (row.get("vas_amount")));
            sale.setAccessory_amount((int) (row.get("accessory_amount")));

            //tilføjer til vores "sales" list
            sales.add(sale);
        }

        return sales;
    }

    // sletter sale i tabellen på baggrund af id
    @Override
    public void deleteSale(int id) {

        int id_emp;


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> employee_id = jdbcTemplate.queryForList("SELECT employee_id FROM sale WHERE sale_id="+id, Integer.class);
        id_emp = saleService.saleService(employee_id);


        jdbcTemplate.update("DELETE From sale WHERE sale_id="+id);

        viewProvisionTotal(id_emp);

    }

    // På baggrund af id-employee, hentes den totale sum af GA fra tabellen sale
    @Override
    public int viewEmployeeTotalGa(int id) {
        int low_total, med_total, high_total, super_high_total;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //List<Integer> modtager et Integer obejct via aggregate funktionen, sum, som lægger alle rows fra en attribut - hertil ga_low_amount.
        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(ga_low_amount) FROM sale WHERE employee_id="+id, Integer.class);
        //rows fra tabellen, sale, lægges sammen
        low_total = saleService.saleService(list_low);




        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(ga_med_amount) FROM sale WHERE employee_id="+id, Integer.class);
        med_total = saleService.saleService(list_med);


        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(ga_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        high_total = saleService.saleService(list_high);


        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(ga_super_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        super_high_total = saleService.saleService(list_super_high);


        return low_total + med_total + high_total + super_high_total;

    }

    // På baggrund af id-employee, hentes den totale sum af FL fra tabellen sale
    @Override
    public int viewEmployeeTotalFl(int id) {
        int low_total, med_total, high_total, super_high_total;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        List<Integer> list_low = jdbcTemplate.queryForList("SELECT SUM(fl_low_amount) FROM sale WHERE employee_id="+id, Integer.class);
        low_total = saleService.saleService(list_low);


        List<Integer> list_med = jdbcTemplate.queryForList("SELECT SUM(fl_med_amount) FROM sale WHERE employee_id="+id, Integer.class);
        med_total = saleService.saleService(list_med);

        List<Integer> list_high = jdbcTemplate.queryForList("SELECT SUM(fl_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        high_total = saleService.saleService(list_high);


        List<Integer> list_super_high = jdbcTemplate.queryForList("SELECT SUM(fl_super_high_amount) FROM sale WHERE employee_id="+id, Integer.class);

        super_high_total = saleService.saleService(list_super_high);

        return low_total + med_total + high_total + super_high_total;

    }

    // På baggrund af id-employee, hentes den totale sum af vas fra tabellen sale
    @Override
    public int viewEmployeeTotalVas(int id) {
        int vas_total;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_vas = jdbcTemplate.queryForList("SELECT SUM(vas_amount) FROM sale WHERE employee_id="+id, Integer.class);
        vas_total = saleService.saleService(list_vas);

        return vas_total;
    }

    // På baggrund af id-employee, hentes den totale sum af accessory fra tabellen sale
    @Override
    public int viewEmployeeTotalAcc(int id) {
        int accessory_total;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        List<Integer> list_accessory = jdbcTemplate.queryForList("SELECT SUM(accessory_amount) FROM sale WHERE employee_id="+id, Integer.class);
        accessory_total = saleService.saleService(list_accessory);

        return accessory_total;
    }


    // På baggrund af id-employee, hentes provision_accumulated.
    @Override
    public void viewProvisionTotal(int id) {

        int low_ga_total, med_ga_total, high_ga_total, super_high_ga_total;

        int low_fl_total, med_fl_total, high_fl_total, super_high_fl_total;

        int ga_total;
        int fl_total;

        int vas_total;
        int accessory_total;

        int provisionTotal;

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //SAMLER GA-POINT

        //List<Integer> modtager et Integer objekt via aggregate funktionen, sum, som lægger alle rows fra en attribut - hertil ga_low_amount.
        List<Integer> list_ga_low = jdbcTemplate.queryForList("SELECT SUM(ga_low_amount) FROM sale WHERE employee_id="+id, Integer.class);

        //kalder ga_low metode for at se List er tom, og for at gange indholdet med tilsvarende provision.
        low_ga_total = provisionService.ga_low(list_ga_low);


        List<Integer> list_ga_med = jdbcTemplate.queryForList("SELECT SUM(ga_med_amount) FROM sale WHERE employee_id="+id, Integer.class);
        med_ga_total = provisionService.ga_med(list_ga_med);


        List<Integer> list_ga_high = jdbcTemplate.queryForList("SELECT SUM(ga_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        high_ga_total = provisionService.ga_high(list_ga_high);


        List<Integer> list_ga_super_high = jdbcTemplate.queryForList("SELECT SUM(ga_super_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        super_high_ga_total = provisionService.ga_super_high(list_ga_super_high);

        //samler provision fra de forskellige typer GA salg
        ga_total = low_ga_total + med_ga_total + high_ga_total + super_high_ga_total;


        //SAMLER FL-POINT
        List<Integer> list_fl_low = jdbcTemplate.queryForList("SELECT SUM(fl_low_amount) FROM sale WHERE employee_id="+id, Integer.class);
        low_fl_total = provisionService.fl_low(list_fl_low);

        List<Integer> list_fl_med = jdbcTemplate.queryForList("SELECT SUM(fl_med_amount) FROM sale WHERE employee_id="+id, Integer.class);
        med_fl_total = provisionService.fl_med(list_fl_med);


        List<Integer> list_fl_high = jdbcTemplate.queryForList("SELECT SUM(fl_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        high_fl_total = provisionService.fl_high(list_fl_high);


        List<Integer> list_fl_super_high = jdbcTemplate.queryForList("SELECT SUM(fl_super_high_amount) FROM sale WHERE employee_id="+id, Integer.class);
        super_high_fl_total = provisionService.fl_super_high(list_fl_super_high);


        //samler provision fra de forskellige typer FL salg
        fl_total = low_fl_total + med_fl_total + high_fl_total + super_high_fl_total;




        //SAMLER VAS-POINT
        List<Integer> list_vas = jdbcTemplate.queryForList("SELECT SUM(vas_amount) FROM sale WHERE employee_id="+id, Integer.class);
        vas_total = provisionService.vas(list_vas);


        //SAMLER ACCESSORY-POINT
        List<Integer> list_accessory = jdbcTemplate.queryForList("SELECT SUM(accessory_amount) FROM sale WHERE employee_id="+id, Integer.class);
        accessory_total = provisionService.accessory(list_accessory);



        //SAMLER PROVISION TOTAL
        provisionTotal = ga_total+fl_total+vas_total+accessory_total;


        //opdater provision_accumulated på baggrund af employee id
        jdbcTemplate.update("UPDATE employee SET provision_accumulated =(?) WHERE id =(?)", provisionTotal, id);

    }


}
