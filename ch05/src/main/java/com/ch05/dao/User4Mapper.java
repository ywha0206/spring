package com.ch05.dao;

import com.ch05.dto.User4Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//mybatis scanning을 위해 @mapper 선언
@Mapper
public interface User4Mapper {

    public void insertUser4(User4Dto user4Dto);
    public List<User4Dto> selectUser4s();
    public User4Dto selectUser4(String uid);
    public void updateUser4(User4Dto user4Dto);
    public void deleteUser4(String uid);


}
