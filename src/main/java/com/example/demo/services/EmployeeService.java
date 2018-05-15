package com.example.demo.services;

import java.util.List;

public interface EmployeeService {

    void addEmployee(String name, String position, int provision_goal);

    List viewEmployee();

    void deleteEmployee(int id);

    int getEmployeeId(int id);


}
