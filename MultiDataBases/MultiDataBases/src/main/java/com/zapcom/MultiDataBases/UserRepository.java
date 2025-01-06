package com.zapcom.MultiDataBases;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class UserRepository extends SQLQueries{


    public UserRepository(JdbcTemplate mysqlJdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        super(mysqlJdbcTemplate,namedParameterJdbcTemplate);
    }


    public Integer findByUserId(int id){

        String checkSql = "SELECT COUNT(*) FROM user WHERE id = ?";
        System.err.println((id));
        return findById(checkSql,id);
    }

    public void saveRecord(User user) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", user.getId());
        params.put("name", user.getName());

        // Use named parameters in the SQL query
        String insertSql = "INSERT INTO user (id, name) VALUES (:id,:name)";

        saveRecord(insertSql, params);
    }




}
