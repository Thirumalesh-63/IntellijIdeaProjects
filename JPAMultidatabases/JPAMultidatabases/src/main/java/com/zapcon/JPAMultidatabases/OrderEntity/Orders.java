package com.zapcon.JPAMultidatabases.OrderEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    private int id;

    private String name;

    private int quantity;

}
