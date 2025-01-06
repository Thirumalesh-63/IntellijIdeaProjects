package com.zapcom.MultiDataBases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;

/**
 * Abstract class SQLQueries provides a foundation for interacting with a MySQL database
 * using JDBC templates. This class defines basic SQL operations for managing user data.
 */
public abstract class SQLQueries {


    private  JdbcTemplate mysqlJdbcTemplate;


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SQLQueries(JdbcTemplate mysqlJdbcTemplate,NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.mysqlJdbcTemplate = mysqlJdbcTemplate;
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }


    /**
     * Checks if a user exists in the database by their ID.
     *
     * @param id the ID of the user to check
     * @return the count of users with the specified ID (0 if none, 1 if found)
     */
    public Integer findById(String query,int id){
        // Step 1: Check if the user exists in the database
        String checkSql = "SELECT COUNT(*) FROM user WHERE id = ?";
        return mysqlJdbcTemplate.queryForObject(checkSql, Integer.class, id);
    }

    /**
     *  Updates the feilds of an existing user in the database based on their ID.
     *  @param user the User object containing the fileds to updtae the user in the databse.
     */

    public int updateRecord(User user){
        String updateSql = "UPDATE user SET name = ? WHERE id = ?";
       return mysqlJdbcTemplate.update(updateSql, user.getName(), user.getId());
    }


    /**
     *   Inserts a new a record into the database.
     *   @param params is the User object containing the necessary feilds of user to create a user in database.
     */

    public int saveRecord(String query, HashMap<String, Object> params){

        MapSqlParameterSource paramSource = new MapSqlParameterSource(params);

        return namedParameterJdbcTemplate.update(query, paramSource);
    }

}
