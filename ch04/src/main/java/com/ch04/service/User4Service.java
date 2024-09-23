package com.ch04.service;



import com.ch04.dao.User4Dao;
import com.ch04.dto.User4Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User4Service {

    private User4Dao dao;

    @Autowired
    public User4Service(User4Dao dao) {
        this.dao = dao;
    }

    public void insertUser1(User4Dto dto){
        dao.insertUser1(dto);
    }

    public User4Dto selectUser1(String uid){
        return dao.selectUser1(uid);
    }

    public List<User4Dto> selectUser1s(){
        return dao.selectUser1s();
    }

    public void updateUser1(User4Dto dto){
        dao.updateUser1(dto);
    }

    public void deleteUser1(String uid){
        dao.deleteUser1(uid);
    }

}
