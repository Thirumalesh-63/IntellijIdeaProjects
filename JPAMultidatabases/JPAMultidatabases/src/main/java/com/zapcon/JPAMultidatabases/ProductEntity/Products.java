package com.zapcon.JPAMultidatabases.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {


    @Id
    private int id;

    private String name;

    private int price;

}
