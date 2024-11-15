package co.kr.yh.service;

import co.kr.yh.document.User1Document;
import co.kr.yh.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {
    private final User1Repository user1Repository;


    public List<User1Document> findAllUser(){
        List<User1Document> user1s = user1Repository.findAll();
        return user1s;
    }

    public User1Document findUser(@PathVariable String uid){
        Optional<User1Document> optUser1 = user1Repository.findByUid(uid);

        if(optUser1.isPresent()){
            User1Document user1 = optUser1.get();
            return user1;
        }
        return null;
    }

    public User1Document insertUser(User1Document user){
        return user1Repository.save(user);

    }

    public User1Document updateUser(User1Document user){
        Optional<User1Document> optuser1 = user1Repository.findByUid(user.getUid());
        User1Document user1Document = optuser1.get();
        user1Document.setUid(user.getUid());
        user1Document.setName(user.getName());
        user1Document.setAge(user.getAge());
        user1Document.setAddr(user.getAddr());

        return user1Repository.save(user1Document);
    }

    public boolean deleteUser(@PathVariable String uid){
        Optional<User1Document> optUser1 = user1Repository.deleteByUid(uid);

        if(optUser1.isPresent()){
            return true;
        }else{
            return false;
        }
    }

}
