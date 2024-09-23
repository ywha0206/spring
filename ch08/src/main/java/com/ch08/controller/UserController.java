package com.ch08.controller;

import com.ch08.dto.UserDTO;
import com.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;


    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO){
        userService.insertUser(userDTO);
        return "redirect:/user/login";
    }

    @GetMapping("/user/success")//로그인한 사용자 정보는 Authentication에 저장(세션이랑 같은 개념) 에 저장됨
    public String success(){
        return "/user/success";
    }
}
