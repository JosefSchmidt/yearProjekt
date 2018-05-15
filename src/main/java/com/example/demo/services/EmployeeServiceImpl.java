package com.example.demo.services;

import com.example.demo.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;





    @Override
    public void addEmployee(String name, String position, int provision_goal) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO employee(name, position, provision_goal) VALUES (?, ?, ?)", name, position, provision_goal);

    }

    @Override
    public List viewEmployee() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM employee";

        List<Employee> employees = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

        for (Map row : rows) {

            Employee employee = new Employee();


            employee.setEmployee_id((int) (row.get("employee_id")));
            employee.setName((String) (row.get("name")));
            employee.setPosition((String) (row.get("position")));
            employee.setProvision_goal((int) (row.get("provision_goal")));
            employee.setProvision_accumulated((int) (row.get("provision_accumulated")));

            employees.add(employee);
        }

        return employees;
    }

    @Override
    public void deleteEmployee(int id) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update("DELETE From employee WHERE employee_id="+id);
    }

    @Override
    public int getEmployeeId(int id) {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            return jdbcTemplate.queryForObject("SELECT employee_id FROM employee WHERE employee_id="+id, Integer.class);
    }





}
