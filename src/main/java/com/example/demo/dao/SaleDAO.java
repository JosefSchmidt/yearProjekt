package com.example.demo.dao;


import com.example.demo.domain.Sale;

import java.util.List;

public interface SaleDAO {


    void addSale(Sale sale);

    List viewEmployeeSales(int id);

    void deleteSale(int id);


    int viewProvisionTotal(int id);



    int viewEmployeeTotalGa(int id);

    int viewEmployeeTotalFl(int id);

    int viewEmployeeTotalVas(int id);

    int viewEmployeeTotalAcc(int id);


}
