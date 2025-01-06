package com.zapcon.JPAMultidatabases.ProductsRepo;


import com.zapcon.JPAMultidatabases.ProductEntity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer> {


}
