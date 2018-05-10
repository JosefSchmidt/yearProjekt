package com.example.demo.domain;

public class Store {

    private String name;

    private int ga_Sale_Total;
    private int fl_Sale_Total;
    private int vas_Sale_Total;
    private int accesories_Sale_Total;


    public Store(){

    }

    public Store(String name, int ga_Sale_Total, int fl_Sale_Total, int vas_Sale_Total, int accesories_Sale_Total) {
        this.name = name;
        this.ga_Sale_Total = ga_Sale_Total;
        this.fl_Sale_Total = fl_Sale_Total;
        this.vas_Sale_Total = vas_Sale_Total;
        this.accesories_Sale_Total = accesories_Sale_Total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAccesories_Sale_Total() {
        return accesories_Sale_Total;
    }

    public void setAccesories_Sale_Total(int accesories_Sale_Total) {
        this.accesories_Sale_Total = accesories_Sale_Total;
    }
}
