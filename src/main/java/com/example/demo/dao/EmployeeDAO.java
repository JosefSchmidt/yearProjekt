package com.example.demo.dao;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(String name, String position, int provision_goal);

    List viewEmployee();

    void deleteEmployee(int id);




}
