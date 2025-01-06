package com.zapcon.JPAMultidatabases.Service;


import com.zapcon.JPAMultidatabases.OrderEntity.Orders;
import com.zapcon.JPAMultidatabases.OrdersRepo.OrdersRepo;
import com.zapcon.JPAMultidatabases.ProductEntity.Products;
import com.zapcon.JPAMultidatabases.ProductsRepo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {


    @Autowired
    private ProductsRepo pRepo;

    @Autowired
    private OrdersRepo oRepo;

    public void saveData(){

        pRepo.save(new Products(1,"watch",2000));
        oRepo.save(new Orders(9,"watches",2));

    }

}
