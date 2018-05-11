package com.example.demo.domain;

public class Provision {

    private final static int ga_low = 2;
    private final static int ga_med = 4;
    private final static int ga_high = 6;
    private final static int ga_super_high = 8;

    private final static int fl_low = 1;
    private final static int fl_med = 2;
    private final static int fl_high = 3;
    private final static int fl_super_high = 4;

    private final static int vas = 2;

    
    private final static int accessories = 2;

    public Provision(){
    }

    public static int getGa_low() {
        return ga_low;
    }

    public static int getGa_med() {
        return ga_med;
    }

    public static int getGa_high() {
        return ga_high;
    }

    public static int getGa_super_high() {
        return ga_super_high;
    }

    public static int getFl_low() {
        return fl_low;
    }

    public static int getFl_med() {
        return fl_med;
    }

    public static int getFl_high() {
        return fl_high;
    }

    public static int getFl_super_high() {
        return fl_super_high;
    }

    public static int getVas() {
        return vas;
    }

    public static int getAccessories() {
        return accessories;
    }

}

