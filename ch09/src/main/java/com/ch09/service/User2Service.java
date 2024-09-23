package com.ch09.service;


import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.repository.User2Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public User2 insertUser2(User2DTO user2DTO) {
        User2 entity = user2DTO.toEntity();
        return  user2Repository.save(entity);
    }

    public User2DTO selectUser2(String uid) {
        Optional<User2> optuser2 = user2Repository.findById(uid);

        if(optuser2.isPresent()) {
            User2 user2 = optuser2.get();
            return user2.toDTO();
        }
        return null;
    }

    public List<User2DTO> selectUser2s() {
        List<User2> user2s = user2Repository.findAll();
        List<User2DTO> users = user2s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());

        return users;
    }

    public User2 updateUser2(User2DTO user2DTO){

        boolean result = user2Repository.existsById(user2DTO.getUid());

        if(result){
            //DTO 를 entity로 변환
            User2 entity = user2DTO.toEntity();

            //entity수정(데이터베이스 update)
            return user2Repository.save(entity);
        }
        return null;
    }

    public void deleteUser2(String uid){

        if(!user2Repository.existsById(uid)){
            throw new EntityNotFoundException("user not found");
        }
        user2Repository.deleteById(uid);
    }

}
