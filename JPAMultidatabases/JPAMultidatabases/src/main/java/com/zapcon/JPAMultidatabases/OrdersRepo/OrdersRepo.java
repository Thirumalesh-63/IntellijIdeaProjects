package com.zapcon.JPAMultidatabases.OrdersRepo;


import com.zapcon.JPAMultidatabases.OrderEntity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer> {


}
