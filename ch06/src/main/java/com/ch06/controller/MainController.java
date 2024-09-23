package com.ch06.controller;

import com.ch06.dto.User1Dto;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Log4j2  //로거 어노테이션
@Controller
public class MainController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {

        String str1 = "hello world";
        String str2 = "hello Spring boot";

        //dto 생성 - 생성자 초기화
        User1Dto user1 = new User1Dto("a101","김유신","1990-08-20", "010-1234-1001", 21);
        log.info(user1);

        //dto 생성 - 세터 초기화
        User1Dto user2 = new User1Dto();
        user2.setUid("a102");
        user2.setName("김춘추");
        user2.setBirth("1980-2-13");
        user2.setHp("010-1234-1002");
        user2.setAge(32);
        log.info(user2);

        //dto 생성 - 빌더 초기화

        User1Dto user3 = User1Dto.builder()
                .uid("a103")
                .name("장보고")
                .birth("1990-08-20")
                .hp("010-1234-1003")
                .age(32)
                .build();
        log.info(user3);

        List<User1Dto> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        model.addAttribute("str1", str1);
        model.addAttribute("str2", str2);
        model.addAttribute("user1",user1);
        model.addAttribute("user2",user2);
        model.addAttribute("user3",user3);
        model.addAttribute("users",users);

        return "index";
    }


}
