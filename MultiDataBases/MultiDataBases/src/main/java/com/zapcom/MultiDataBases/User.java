package com.zapcom.MultiDataBases;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("User")
public class User {

    private int id;

    private String name;

}
