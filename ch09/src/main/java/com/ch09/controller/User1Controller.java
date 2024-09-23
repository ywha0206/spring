package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.repository.User1Repository;
import com.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @ResponseBody
    @GetMapping(value = "/user1")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();
        
        //Json 변환은 디스패처가 해주기 때문에 반환만 해도 됨
        return users;
    }

    @ResponseBody
    @GetMapping(value = "/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user = user1Service.selectUser1(uid);
        return user;
    }

    @ResponseBody
    @PostMapping(value = "/user1")
    public User1 register(@RequestBody User1DTO user1DTO){
        log.info(user1DTO);
        User1 savedUser1 = user1Service.insertUser1(user1DTO);
        ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser1);
        return savedUser1;
    }

    @PutMapping(value = "/user1")
    public ResponseEntity modify(@RequestBody User1DTO user1DTO){
        User1 modifiedUser1 = user1Service.updateUser1(user1DTO);

        //responseEntity로 반환할 경우

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser1);
    }

    @DeleteMapping(value = "/user1/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){

        try {
            user1Service.deleteUser1(uid);
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
