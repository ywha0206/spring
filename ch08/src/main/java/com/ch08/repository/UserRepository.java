package com.ch08.repository;

import com.ch08.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //@Query("select u from User u where u.uid = ? and u.pass = ?")
    //List<User> finduser(String uid, String pass);
}
