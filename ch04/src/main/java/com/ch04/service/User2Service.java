package com.ch04.service;



import com.ch04.dao.User2Dao;
import com.ch04.dto.User2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {

    private User2Dao dao;

    @Autowired
    public User2Service(User2Dao dao) {
        this.dao = dao;
    }

    public void insertUser1(User2Dto dto){
        dao.insertUser1(dto);
    }

    public User2Dto selectUser1(String uid){
        return dao.selectUser1(uid);
    }

    public List<User2Dto> selectUser1s(){
        return dao.selectUser1s();
    }

    public void updateUser1(User2Dto dto){
        dao.updateUser1(dto);
    }

    public void deleteUser1(String uid){
        dao.deleteUser1(uid);
    }

}
