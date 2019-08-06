package com.rogo.repo;

import com.rogo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Boolean getUserByUsername(String username) {
        String userPassword = null;
        try {
            userPassword = jdbcTemplate.queryForObject("select userpassword from users where username = ?",
                        new Object[]{username},String.class
                    );

        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return true;
    }

}
