package com.ch09.controller;


import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.service.User2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class User2Controller {

    private final User2Service user2Service;


    //@ResponseBody  restController 사용하면 @responseBody는 생략
    @GetMapping(value = "/user2")
    public List<User2DTO> list(){
        List<User2DTO> users = user2Service.selectUser2s();
        
        //Json 변환은 디스패처가 해주기 때문에 반환만 해도 됨
        return users;
    }

    @GetMapping(value = "/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid){
        User2DTO user = user2Service.selectUser2(uid);
        return user;
    }

    @PostMapping(value = "/user2")
    public User2 register(@RequestBody User2DTO user2DTO){
        log.info(user2DTO);
        User2 savedUser2 = user2Service.insertUser2(user2DTO);
        ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser2);
        return savedUser2;
    }

    @PutMapping(value = "/user2")
    public ResponseEntity modify(@RequestBody User2DTO user2DTO){
        User2 modifiedUser2 = user2Service.updateUser2(user2DTO);

        //responseEntity로 반환할 경우

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser2);
    }

    @DeleteMapping(value = "/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){

        try {
            user2Service.deleteUser2(uid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success");
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
