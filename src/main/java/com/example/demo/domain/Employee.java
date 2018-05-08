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

    private int ga_Sale_Total;
    private int fl_Sale_Total;
    private int vas_Sale_Total;
    private int accessory_Sale_Total;

    private int accumulated_Provision;
    private int goal_Provision;

    public Employee(){

    }

    public Employee(String name, String position, int ga_Sale_Total, int fl_Sale_Total, int vas_Sale_Total, int accessory_Sale_Total, int accumulated_Provision, int goal_Provision) {
        this.name = name;
        this.position = position;
        this.ga_Sale_Total = ga_Sale_Total;
        this.fl_Sale_Total = fl_Sale_Total;
        this.vas_Sale_Total = vas_Sale_Total;
        this.accessory_Sale_Total = accessory_Sale_Total;
        this.accumulated_Provision = accumulated_Provision;
        this.goal_Provision = goal_Provision;
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

    public int getGa_Sale_Total() {
        return ga_Sale_Total;
    }

    public void setGa_Sale_Total(int ga_Sale_Total) {
        this.ga_Sale_Total = ga_Sale_Total;
    }

    public int getFl_Sale_Total() {
        return fl_Sale_Total;
    }

    public void setFl_Sale_Total(int fl_Sale_Total) {
        this.fl_Sale_Total = fl_Sale_Total;
    }

    public int getVas_Sale_Total() {
        return vas_Sale_Total;
    }

    public void setVas_Sale_Total(int vas_Sale_Total) {
        this.vas_Sale_Total = vas_Sale_Total;
    }

    public int getAccessory_Sale_Total() {
        return accessory_Sale_Total;
    }

    public void setAccessory_Sale_Total(int accessory_Sale_Total) {
        this.accessory_Sale_Total = accessory_Sale_Total;
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



}
