package com.ch05.dao;

import com.ch05.dto.User2Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//mybatis scanning을 위해 @mapper 선언
@Mapper
public interface User2Mapper {

    public void insertUser2(User2Dto user2Dto);
    public List<User2Dto> selectUser2s();
    public User2Dto selectUser2(String uid);
    public void updateUser2(User2Dto user2Dto);
    public void deleteUser2(String uid);


}
