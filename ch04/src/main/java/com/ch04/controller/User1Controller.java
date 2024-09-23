package com.ch04.controller;

import com.ch04.dto.User1Dto;
import com.ch04.service.User1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User1Controller {

    private User1Service service;

    @Autowired
    public User1Controller(User1Service service) {
        this.service = service;
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";

    }
    @PostMapping("/user1/register")
    public String register(User1Dto dto){
        System.out.println(dto);

        //등록
        service.insertUser1(dto);

        //리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/list")
    public String list(Model model){

        //조회
        List<User1Dto> users = service.selectUser1s();
        System.out.println(users);

        //모델참조(컨트롤러 데이터를 뷰에서 참조)
        model.addAttribute("users", users);

        return "/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        System.out.println("uid "+uid);

        //수정회원조회
        User1Dto user = service.selectUser1(uid);

        //모델참조
        model.addAttribute("user", user); //(key, value) 키 생략하면 타입명으로 저장 (소문자 시작 > user1Dto)

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(@ModelAttribute User1Dto dto){
        System.out.println("dto "+dto);

        service.updateUser1(dto);

        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(User1Dto user){
        service.deleteUser1(user.getUid());

        return "redirect:/user1/list";
    }

}
