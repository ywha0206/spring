package com.ch04.controller;

import com.ch04.dto.User2Dto;
import com.ch04.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private User2Service service;

    @Autowired
    public User2Controller(User2Service service) {
        this.service = service;
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";

    }
    @PostMapping("/user2/register")
    public String register(User2Dto dto){
        System.out.println(dto);

        //등록
        service.insertUser1(dto);

        //리다이렉트
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/list")
    public String list(Model model){

        //조회
        List<User2Dto> users = service.selectUser1s();
        System.out.println(users);

        //모델참조(컨트롤러 데이터를 뷰에서 참조)
        model.addAttribute("users", users);

        return "/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        System.out.println("uid "+uid);

        //수정회원조회
        User2Dto user = service.selectUser1(uid);

        //모델참조
        model.addAttribute("user", user); //(key, value) 키 생략하면 타입명으로 저장 (소문자 시작 > user1Dto)

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(@ModelAttribute User2Dto dto){
        System.out.println("dto "+dto);

        service.updateUser1(dto);

        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(User2Dto user){
        service.deleteUser1(user.getUid());

        return "redirect:/user2/list";
    }

}
