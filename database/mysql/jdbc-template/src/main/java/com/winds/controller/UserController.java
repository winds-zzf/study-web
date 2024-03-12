package com.winds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.winds.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {
    /* JDBC连接数据库的工具类 */
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/users")
    public List<User> mySqlTest(){
        // 待查询SQL语句
        String sql = "select* from user";

        /*
         * query()是JdbcTemplate中的方法
         * RowMapper对象可以查询数据库中的数据
         */
        List<User> users = jdbcTemplate.query(sql, new RowMapper<User>() {
            /* RowMapper对象通过调用mapRow()方法将数据库中的每一行数据封装成User对象，并返回 */
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                // 手动将ResultSet中查询的数据取出存入User对象中，并返回一个新建的User
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });

        System.out.println("查询成功:"+users);
        return users;
    }
}
