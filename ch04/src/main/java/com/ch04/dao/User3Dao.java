package com.ch04.dao;


import com.ch04.dto.User3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User3Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User3Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser1(User3Dto dto){

        String sql = "insert into `user3` values(?,?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAddr()
        };

        jdbcTemplate.update(sql,params);
    }

    public User3Dto selectUser1(String uid){

        String sql = "select * from user3 where uid=?";

        User3Dto dto= (User3Dto) jdbcTemplate.queryForObject(sql, new User3RowMapper(), uid);
        return  dto;
    }

    public List<User3Dto> selectUser1s(){

        String sql = "select * from user3";
        return jdbcTemplate.query(sql, new User3RowMapper());


    }

    public void updateUser1(User3Dto dto){
        String sql = "update user3 set name=?,birth=?,hp=?,addr=? where uid=? ";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getHp(),
                dto.getAddr(),
                dto.getUid()
        };
        jdbcTemplate.update(sql,params);
    }

    public void deleteUser1(String uid){
        String sql = "delete from user3 where uid=?";
        jdbcTemplate.update(sql,uid);
    }

}
