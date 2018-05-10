package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String position;


    private int accumulated_Provision;
    private int goal_Provision;

    public Employee(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAccumulated_Provision() {
        return accumulated_Provision;
    }

    public void setAccumulated_Provision(int accumulated_Provision) {
        this.accumulated_Provision = accumulated_Provision;
    }

    public int getGoal_Provision() {
        return goal_Provision;
    }

    public void setGoal_Provision(int goal_Provision) {
        this.goal_Provision = goal_Provision;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", accumulated_Provision=" + accumulated_Provision +
                ", goal_Provision=" + goal_Provision +
                '}';
    }
}
