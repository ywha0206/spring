package com.ch05.controller;

import com.ch05.dto.User1Dto;
import com.ch05.service.User1Service;
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

    private User1Service user1Service;

    @Autowired
    public User1Controller(User1Service user1Service) {
        this.user1Service = user1Service;
    }

        @GetMapping("/user1/list")
        public String list(Model model){
            List<User1Dto> users = user1Service.selectUser1s();
            model.addAttribute("users", users);
            return "/user1/list";
        }

        @GetMapping("/user1/register")
        public String register(){
            return "/user1/register";
        }
        @PostMapping("/user1/register")
        public String register(User1Dto user1Dto){
            user1Service.insertUser1(user1Dto);
            return "redirect:/user1/list";
        }

        @GetMapping("/user1/modify")
        public String modify(@RequestParam("uid") String uid, Model model){
            User1Dto user = user1Service.selectUser1(uid);
            model.addAttribute("user", user);
            return "/user1/modify";
        }

        @PostMapping("/user1/modify")
        public String modify(@ModelAttribute User1Dto dto){
            user1Service.updateUser1(dto);
            return "redirect:/user1/list";
        }

        @GetMapping("/user1/delete")
        public String delete(@RequestParam("uid") String uid){
            user1Service.deleteUser1(uid);
            return "redirect:/user1/list";
        }


}
