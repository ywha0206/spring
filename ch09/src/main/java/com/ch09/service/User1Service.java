package com.ch09.service;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.repository.User1Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    public User1 insertUser1(User1DTO user1DTO) {
        User1 entity = user1DTO.toEntity();
        User1 savedEntity = user1Repository.save(entity);
        return savedEntity;
        //return user1Repository.save(entity);
    }

    public User1DTO selectUser1(String uid) {
        Optional<User1> optuser1 = user1Repository.findById(uid);

        if(optuser1.isPresent()) {
            User1 user1 = optuser1.get();
            return user1.toDTO();
        }
        return null;
    }

    public List<User1DTO> selectUser1s() {
        List<User1> user1s = user1Repository.findAll();
        List<User1DTO> users = user1s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return users;
    }

    public User1 updateUser1(User1DTO user1DTO){

        boolean result = user1Repository.existsById(user1DTO.getUid());

        if(result){
            //DTO 를 entity로 변환
            User1 entity = user1DTO.toEntity();

            //entity수정(데이터베이스 update)
            return user1Repository.save(entity);
        }
        return null;
    }

    public void deleteUser1(String uid){

        if(!user1Repository.existsById(uid)){
            throw new EntityNotFoundException("user not found");
        }
        user1Repository.deleteById(uid);
    }

}
