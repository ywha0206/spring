package com.ch05.dao;

import com.ch05.dto.User5Dto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//mybatis scanning을 위해 @mapper 선언
@Mapper
public interface User5Mapper {

    public void insertUser5(User5Dto user5Dto);
    public List<User5Dto> selectUser5s();
    public User5Dto selectUser5(String seq);
    public void updateUser5(User5Dto user5Dto);
    public void deleteUser5(String seq);


}
