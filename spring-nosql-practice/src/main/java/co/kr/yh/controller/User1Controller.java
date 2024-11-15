package co.kr.yh.controller;

import co.kr.yh.document.User1Document;
import co.kr.yh.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1")
    public ResponseEntity<List<User1Document>> findAllUser(){
        List<User1Document> user1List = user1Service.findAllUser();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(user1List);
    }

    @GetMapping("/user1/{uid}")
    public ResponseEntity<User1Document> findUser(@PathVariable("uid") String uid){
        User1Document user1 = user1Service.findUser(uid);

        if(user1 != null){
            return ResponseEntity.ok().body(user1);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user1")
    public User1Document insertUser(User1Document user1){
        User1Document savedUser1 = user1Service.insertUser(user1);
        return savedUser1;
    }

    @PutMapping("/user1")
    public ResponseEntity<User1Document> updateUser(User1Document user1){
        User1Document modifiedUser1 = user1Service.updateUser(user1);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(modifiedUser1);
    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String uid){
        boolean result = user1Service.deleteUser(uid);
        return ResponseEntity.ok().body(result);
    }

}
