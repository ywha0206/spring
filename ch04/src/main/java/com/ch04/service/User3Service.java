package com.ch04.service;



import com.ch04.dao.User3Dao;
import com.ch04.dto.User3Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User3Service {

    private User3Dao dao;

    @Autowired
    public User3Service(User3Dao dao) {
        this.dao = dao;
    }

    public void insertUser1(User3Dto dto){
        dao.insertUser1(dto);
    }

    public User3Dto selectUser1(String uid){
        return dao.selectUser1(uid);
    }

    public List<User3Dto> selectUser1s(){
        return dao.selectUser1s();
    }

    public void updateUser1(User3Dto dto){
        dao.updateUser1(dto);
    }

    public void deleteUser1(String uid){
        dao.deleteUser1(uid);
    }

}
