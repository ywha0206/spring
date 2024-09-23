package com.ch05.controller;


import com.ch05.dto.User2Dto;
import com.ch05.service.User2Service;
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

        @GetMapping("/user2/list")
        public String list(Model model){
            List<User2Dto> users = service.selectUser2s();
            model.addAttribute("users", users);
            return "/user2/list";
        }

        @GetMapping("/user2/register")
        public String register(){
            return "/user2/register";
        }
        @PostMapping("/user2/register")
        public String register(User2Dto user2Dto){
            service.insertUser2(user2Dto);
            return "redirect:/user2/list";
        }

        @GetMapping("/user2/modify")
        public String modify(@RequestParam("uid") String uid, Model model){
            User2Dto user = service.selectUser2(uid);
            model.addAttribute("user", user);
            return "/user2/modify";
        }

        @PostMapping("/user2/modify")
        public String modify(@ModelAttribute User2Dto dto){
            service.updateUser2(dto);
            return "redirect:/user2/list";
        }

        @GetMapping("/user2/delete")
        public String delete(@RequestParam("uid") String uid){
            service.deleteUser2(uid);
            return "redirect:/user2/list";
        }


}
