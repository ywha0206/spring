package com.ch05.service;



import com.ch05.dao.User3Mapper;
import com.ch05.dto.User3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User3Service {


    private final User3Mapper user3Mapper;

    @Autowired
    public User3Service(User3Mapper user3Mapper) {
        this.user3Mapper = user3Mapper;
    }

    public void insertUser3(User3Dto dto){
        user3Mapper.insertUser3(dto);
    }

    public User3Dto selectUser3(String uid){
        return user3Mapper.selectUser3(uid);
    }

    public List<User3Dto> selectUser3s(){
        return user3Mapper.selectUser3s();
    }

    public void updateUser3(User3Dto dto){
        user3Mapper.updateUser3(dto);
    }

    public void deleteUser3(String uid){
        user3Mapper.deleteUser3(uid);
    }

}
