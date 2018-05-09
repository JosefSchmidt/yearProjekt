package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Provision {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provision_id;
    private int ga_low_amount = 0;
    private int ga_med_amount = 0;
    private int ga_high_amount = 0;
    private int ga_super_high_amount = 0;

    private int fl_low_amount = 0;
    private int fl_med_amount = 0;
    private int fl_high_amount = 0;
    private int fl_super_high_amount = 0;

    private int vas_amount = 0;

    private int accessories_amount = 0;



    public Provision(){
    }

    public Provision(int provision_id, int ga_low_amount, int ga_med_amount, int ga_high_amount, int ga_super_high_amount, int fl_low_amount, int fl_med_amount, int fl_high_amount, int fl_super_high_amount, int vas_amount, int accessories_amount) {
        this.provision_id = provision_id;
        this.ga_low_amount = ga_low_amount;
        this.ga_med_amount = ga_med_amount;
        this.ga_high_amount = ga_high_amount;
        this.ga_super_high_amount = ga_super_high_amount;
        this.fl_low_amount = fl_low_amount;
        this.fl_med_amount = fl_med_amount;
        this.fl_high_amount = fl_high_amount;
        this.fl_super_high_amount = fl_super_high_amount;
        this.vas_amount = vas_amount;
        this.accessories_amount = accessories_amount;
    }

    public int getProvision_id() {
        return provision_id;
    }

    public void setProvision_id(int provision_id) {
        this.provision_id = provision_id;
    }

    public int getGa_low_amount() {
        return ga_low_amount;
    }

    public void setGa_low_amount(int ga_low_amount) {
        this.ga_low_amount = ga_low_amount;
    }

    public int getGa_med_amount() {
        return ga_med_amount;
    }

    public void setGa_med_amount(int ga_med_amount) {
        this.ga_med_amount = ga_med_amount;
    }

    public int getGa_high_amount() {
        return ga_high_amount;
    }

    public void setGa_high_amount(int ga_high_amount) {
        this.ga_high_amount = ga_high_amount;
    }

    public int getGa_super_high_amount() {
        return ga_super_high_amount;
    }

    public void setGa_super_high_amount(int ga_super_high_amount) {
        this.ga_super_high_amount = ga_super_high_amount;
    }

    public int getFl_low_amount() {
        return fl_low_amount;
    }

    public void setFl_low_amount(int fl_low_amount) {
        this.fl_low_amount = fl_low_amount;
    }

    public int getFl_med_amount() {
        return fl_med_amount;
    }

    public void setFl_med_amount(int fl_med_amount) {
        this.fl_med_amount = fl_med_amount;
    }

    public int getFl_high_amount() {
        return fl_high_amount;
    }

    public void setFl_high_amount(int fl_high_amount) {
        this.fl_high_amount = fl_high_amount;
    }

    public int getFl_super_high_amount() {
        return fl_super_high_amount;
    }

    public void setFl_super_high_amount(int fl_super_high_amount) {
        this.fl_super_high_amount = fl_super_high_amount;
    }

    public int getVas_amount() {
        return vas_amount;
    }

    public void setVas_amount(int vas_amount) {
        this.vas_amount = vas_amount;
    }

    public int getAccessories_amount() {
        return accessories_amount;
    }

    public void setAccessories_amount(int accessories_amount) {
        this.accessories_amount = accessories_amount;
    }
}
