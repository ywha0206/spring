package com.ch04.dao;


import com.ch04.dto.User2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User2Dao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public User2Dao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertUser1(User2Dto dto){

        String sql = "insert into `user2` values(?,?,?,?)";
        Object[] params = {
                dto.getUid(),
                dto.getName(),
                dto.getBirth(),
                dto.getAddr()
        };

        jdbcTemplate.update(sql,params);
    }

    public User2Dto selectUser1(String uid){

        String sql = "select * from user2 where uid=?";

        User2Dto dto= (User2Dto) jdbcTemplate.queryForObject(sql, new User2RowMapper(), uid);
        return  dto;
    }

    public List<User2Dto> selectUser1s(){

        String sql = "select * from user2";
        return jdbcTemplate.query(sql, new User2RowMapper());


    }

    public void updateUser1(User2Dto dto){
        String sql = "update user2 set name=?,birth=?,addr=? where uid=? ";
        Object[] params = {
                dto.getName(),
                dto.getBirth(),
                dto.getAddr(),
                dto.getUid()
        };
        jdbcTemplate.update(sql,params);
    }

    public void deleteUser1(String uid){
        String sql = "delete from user2 where uid=?";
        jdbcTemplate.update(sql,uid);
    }

}
