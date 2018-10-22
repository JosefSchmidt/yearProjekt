package com.example.demo.services;

import com.example.demo.domain.Provision;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvisionService {


    public int ga_low (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getGa_low();
    }


    public int ga_med (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getGa_med();
    }


    public int ga_high (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getGa_high();
    }


    public int ga_super_high (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getGa_super_high();
    }


    public int fl_low (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getFl_low();
    }


    public int fl_med (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getFl_med();
    }


    public int fl_high (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getFl_high();
    }


    public int fl_super_high (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getFl_super_high();
    }


    public int vas (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getVas();
    }


    public int accessory (List list) {
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null)
                total = (int) list.get(i);
        }
        return total * Provision.getAccessories();
    }




}
