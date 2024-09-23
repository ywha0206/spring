package com.ch06.dao;

import com.ch06.dto.User1Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User1Mapper {

    public void insertUser1(User1Dto dto);
    public User1Dto selectUser1(String uid);
    public List<User1Dto> selectUser1s();
    public void updateUser1(User1Dto dto);
    public void deleteUser1(String uid);

}
