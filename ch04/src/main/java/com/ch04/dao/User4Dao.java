package com.ch04.dao;


import com.ch04.dto.User4Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User4Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User4Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser1(User4Dto dto){

        String sql = "insert into `user4` values(?,?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getHp(),
                dto.getAddr()
        };

        jdbcTemplate.update(sql,params);
    }

    public User4Dto selectUser1(String uid){

        String sql = "select * from user4 where uid=?";

        User4Dto dto= (User4Dto) jdbcTemplate.queryForObject(sql, new User4RowMapper(), uid);
        return  dto;
    }

    public List<User4Dto> selectUser1s(){

        String sql = "select * from user4";
        return jdbcTemplate.query(sql, new User4RowMapper());


    }

    public void updateUser1(User4Dto dto){
        String sql = "update user4 set name=?,gender=?,age=?,hp=?,addr=? where uid=? ";
        Object[] params = {
                dto.getName(),
                dto.getGender(),
                dto.getAge(),
                dto.getHp(),
                dto.getAddr(),
                dto.getUid()
        };
        jdbcTemplate.update(sql,params);
    }

    public void deleteUser1(String uid){
        String sql = "delete from user4 where uid=?";
        jdbcTemplate.update(sql,uid);
    }

}
