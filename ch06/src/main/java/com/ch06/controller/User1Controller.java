package com.ch06.controller;

import com.ch06.dto.User1Dto;
import com.ch06.service.User1Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class User1Controller {

    private User1Service user1Service;

    @GetMapping("/user1/list")
    public String list(Model model) {
        List<User1Dto> users = user1Service.selectUser1s();
        model.addAttribute("users", users);
        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){
        User1Dto user = user1Service.selectUser1(uid);
        model.addAttribute("user", user);
        return "/user1/modify";
    }
    @GetMapping("/user1/delete")
    public String delete(String uid){
        user1Service.deleteUser1(uid);
        return "/user1/delete";
    }
}
