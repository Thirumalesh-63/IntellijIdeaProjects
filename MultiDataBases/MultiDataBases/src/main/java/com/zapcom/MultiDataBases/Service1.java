package com.zapcom.MultiDataBases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static java.lang.System.*;

@Service
public class Service1 {

    private JdbcTemplate h2JdbcTemplate;

    @Autowired
    private UserRepository repository;


    @Autowired
    public Service1(JdbcTemplate h2JdbcTemplate, JdbcTemplate mysqlJdbcTemplate) {

        this.h2JdbcTemplate = h2JdbcTemplate;
    }

//    @Autowired
//    private SQLQueries quereis;

    // H2 Operations
    public void h2database() {
        String sql = "Select * from MY_TABLE";
        System.err.println(h2JdbcTemplate.queryForList(sql));
        String checkSql = "SELECT COUNT(*) FROM MY_TABLE WHERE id = ?";
        Integer count = h2JdbcTemplate.query(checkSql, new Object[]{1}, rs -> {
            if (rs.next()) {

                return rs.getInt(1); // Get the first column (count)
            }
            return 0; // Default value if no records are found
        });
        System.err.println(count);

    }

    public String sqldatabase(User user) {
        try {
            Integer count = repository.findByUserId(user.getId());

            if (count > 0) {
                int count2 = repository.updateRecord(user);
                return "User updated successfully";
            } else {

                 repository.saveRecord(user);
                return "User inserted successfully.";
            }
        } catch (Exception e) {

            System.err.println((e.getMessage()));
            return "error occured";
        }
    }

}
