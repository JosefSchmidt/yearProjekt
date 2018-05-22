package com.example.demo.services;

import java.util.List;

public class SaleService {

    public int saleService (List list){
        int total = 0;

        for (int i = 0; i <list.size(); i++) {
            if(list.get(i) != null)
                total = (int) list.get(i);
        }
        return total;
    }

}
