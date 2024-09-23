package com.ch05.service;



import com.ch05.dao.User2Mapper;
import com.ch05.dto.User2Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User2Service {


    private final User2Mapper user2Mapper;

    @Autowired
    public User2Service(User2Mapper user2Mapper) {
        this.user2Mapper = user2Mapper;
    }

    public void insertUser2(User2Dto dto){
        user2Mapper.insertUser2(dto);
    }

    public User2Dto selectUser2(String uid){
        return user2Mapper.selectUser2(uid);
    }

    public List<User2Dto> selectUser2s(){
        return user2Mapper.selectUser2s();
    }

    public void updateUser2(User2Dto dto){
        user2Mapper.updateUser2(dto);
    }

    public void deleteUser2(String uid){
        user2Mapper.deleteUser2(uid);
    }

}
