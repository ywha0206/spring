package com.springtest.repository;

import com.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("select count(u) from User u where u.nick = :nick")
    int findUserNick(String nick);

    @Query("select count(u) from User u where u.hp = :hp")
    int findUserHp(String hp);

    @Query("select count(u) from User u where u.email = :email")
    int findUserEmail(String email);
}
