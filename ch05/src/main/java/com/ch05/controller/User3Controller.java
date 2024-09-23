package com.ch05.controller;


import com.ch05.dto.User3Dto;
import com.ch05.service.User3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User3Controller {

    private User3Service service;

    @Autowired
    public User3Controller(User3Service service) {
        this.service = service;
    }

        @GetMapping("/user3/list")
        public String list(Model model){
            List<User3Dto> users = service.selectUser3s();
            model.addAttribute("users", users);
            return "/user3/list";
        }

        @GetMapping("/user3/register")
        public String register(){
            return "/user3/register";
        }
        @PostMapping("/user3/register")
        public String register(User3Dto user3Dto){
            service.insertUser3(user3Dto);
            return "redirect:/user3/list";
        }

        @GetMapping("/user3/modify")
        public String modify(@RequestParam("uid") String uid, Model model){
            User3Dto user = service.selectUser3(uid);
            model.addAttribute("user", user);
            return "/user3/modify";
        }

        @PostMapping("/user3/modify")
        public String modify(@ModelAttribute User3Dto dto){
            service.updateUser3(dto);
            return "redirect:/user3/list";
        }

        @GetMapping("/user3/delete")
        public String delete(@RequestParam("uid") String uid){
            service.deleteUser3(uid);
            return "redirect:/user3/list";
        }


}
