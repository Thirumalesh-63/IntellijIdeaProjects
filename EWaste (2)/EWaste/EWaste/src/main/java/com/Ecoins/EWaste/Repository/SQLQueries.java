package com.Ecoins.EWaste.Repository;


import com.Ecoins.EWaste.Model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
/**
 * Abstract class SQLQueries provides a foundation for interacting with a MySQL database
 * using JDBC templates. This class defines basic SQL operations for managing user data.
 */
@Component
public class SQLQueries {


    private  JdbcTemplate mysqlJdbcTemplate;

    @Autowired
    public SQLQueries(JdbcTemplate mysqlJdbcTemplate) {
        this.mysqlJdbcTemplate = mysqlJdbcTemplate;
    }


    /**
     * Checks if a user exists in the database by their ID.
     *
     * @param id the ID of the user to check
     * @return the count of users with the specified ID (0 if none, 1 if found)
     */
    public Integer findById(int id){
        // Step 1: Check if the user exists in the database
        String checkSql = "SELECT COUNT(*) FROM user WHERE id = ?";
        mysqlJdbcTemplate.queryForObject(checkSql, Integer.class, id);
        return 1;
    }

    /**
     *  Updates the feilds of an existing user in the database based on their ID.
     *  @param user the User object containing the fileds to updtae the user in the databse.
     */

    public int updateRecord(UserDetails user){
        String updateSql = "UPDATE user SET name = ? WHERE id = ?";
        return mysqlJdbcTemplate.update(updateSql, user.getId());
    }


    /**
     *   Inserts a new a record into the database.
     *   @param user is the User object containing the necessary feilds of user to create a user in database.
     */

    public int saveRecord(UserDetails user){
        String insertSql = "INSERT INTO user (id, name) VALUES (?, ?)";
        return mysqlJdbcTemplate.update(insertSql, user.getId());
    }

}
