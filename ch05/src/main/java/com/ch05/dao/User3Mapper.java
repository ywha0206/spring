package com.ch05.dao;

import com.ch05.dto.User3Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//mybatis scanning을 위해 @mapper 선언
@Mapper
public interface User3Mapper {

    public void insertUser3(User3Dto user3Dto);
    public List<User3Dto> selectUser3s();
    public User3Dto selectUser3(String uid);
    public void updateUser3(User3Dto user3Dto);
    public void deleteUser3(String uid);


}
