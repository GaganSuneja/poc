package com.rogo.repo;

import com.rogo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username) {
        User user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from users where user_name = ?",
                        new Object[]{username},new BeanPropertyRowMapper<User>(User.class)
                    );

        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return user;
    }

}
