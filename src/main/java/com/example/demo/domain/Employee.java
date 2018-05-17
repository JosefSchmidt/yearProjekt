package com.example.demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String position;
    private int provision_goal;
    private int provision_accumulated;


    public Employee (){

    }

    public Employee(String name, String position, int provision_goal, int provision_accumulated) {
        this.name = name;
        this.position = position;
        this.provision_goal = provision_goal;
        this.provision_accumulated = provision_accumulated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getProvision_goal() {
        return provision_goal;
    }

    public void setProvision_goal(int provision_goal) {
        this.provision_goal = provision_goal;
    }

    public int getProvision_accumulated() {
        return provision_accumulated;
    }

    public void setProvision_accumulated(int provision_accumulated) {
        this.provision_accumulated = provision_accumulated;
    }
}
