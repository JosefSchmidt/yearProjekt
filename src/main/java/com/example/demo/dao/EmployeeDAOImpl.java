package com.example.demo.dao;

import com.example.demo.domain.Employee;
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
public class EmployeeDAOImpl implements EmployeeDAO {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;



    //tilføjer employee til databasen ved brug af et prepared statement
    @Override
    public void addEmployee(String name, String position, int provision_goal) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO employee(name, position, provision_goal) VALUES (?, ?, ?)", name, position, provision_goal);

    }


    //returner en List af Employee
    @Override
    public List viewEmployee() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        //list som har til formål at holde på vores data fra tabellen
        List<Employee> employees = new ArrayList<>();

        //(kan bruge den samme struktur flere gange)
        //List af Employee. Map definer keys (String) til value (objektet)
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM employee");

        //For loop af rows (Employees)
        for (Map row : rows) {

            //Her laves en ny instanse af Employee for hver row.
            Employee employee = new Employee();

            //Angiver keys til value
            employee.setId((int) (row.get("id")));
            employee.setName((String) (row.get("name")));
            employee.setPosition((String) (row.get("position")));
            employee.setProvision_goal((int) (row.get("provision_goal")));
            employee.setProvision_accumulated((int) (row.get("provision_accumulated")));


            //Tilføjer til vores List af employees
            employees.add(employee);

        }

        //returner List af Employees
        return employees;
    }

    //Fjerner Employee fra databasen på baggrund af id
    @Override
    public void deleteEmployee(int id) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            jdbcTemplate.update("DELETE  FROM sale WHERE employee_id="+id);
            jdbcTemplate.update("DELETE From employee WHERE id="+id);

    }

}
