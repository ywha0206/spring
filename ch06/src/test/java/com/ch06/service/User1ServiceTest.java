package com.ch06.service;

import com.ch06.dto.User1Dto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;

    @Test
    void insertUser1() {
        //테스트 정의: given - when - then 패턴

        //given: 테스트를 실행하기 위한 준비
        User1Dto sample = User1Dto.builder()
                .uid("a101")
                .name("김유신")
                .birth("1999-10-10")
                .hp("010-1234-5555")
                .age(22)
                .build();
        //when: 테스트를 실행
        user1Service.insertUser1(sample);

        //then: 테스트를 결과를 검증, assert 단정문을 이용해 결과 출력
        User1Dto expacted = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(sample, expacted);
    }

    @Test
    void selectUser1() {
        //given
        String uid = "a102";
        //when
        User1Dto expacted = user1Service.selectUser1(uid);
        //then
        assertEquals(uid, expacted.getUid());

    }

    @Test
    void selectUser1s() {

        List<User1Dto> expected = user1Service.selectUser1s();

        Assertions.assertFalse(expected.isEmpty());
    }

    @Test
    void updateUser1() {
        User1Dto sample = User1Dto.builder()
                .uid("a102")
                .name("김유진")
                .birth("1999-10-10")
                .hp("010-1234-5555")
                .age(22)
                .build();
        user1Service.updateUser1(sample);
        User1Dto expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(sample.toString(), expected.toString());
    }

    @Test
    void deleteUser1() {
        String uid = "a101";
        User1Dto expected = user1Service.deleteUser1(uid);
        Assertions.assertNull(expected);

    }
}