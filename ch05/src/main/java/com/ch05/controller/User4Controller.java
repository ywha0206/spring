package com.ch05.controller;


import com.ch05.dto.User4Dto;
import com.ch05.service.User4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User4Controller {

    private User4Service service;

    @Autowired
    public User4Controller(User4Service service) {
        this.service = service;
    }

        @GetMapping("/user4/list")
        public String list(Model model){
            List<User4Dto> users = service.selectUser4s();
            model.addAttribute("users", users);
            return "/user4/list";
        }

        @GetMapping("/user4/register")
        public String register(){
            return "/user4/register";
        }
        @PostMapping("/user4/register")
        public String register(User4Dto user4Dto){
            service.insertUser4(user4Dto);
            return "redirect:/user4/list";
        }

        @GetMapping("/user4/modify")
        public String modify(@RequestParam("uid") String uid, Model model){
            User4Dto user = service.selectUser4(uid);
            model.addAttribute("user", user);
            return "/user4/modify";
        }

        @PostMapping("/user4/modify")
        public String modify(@ModelAttribute User4Dto dto){
            service.updateUser4(dto);
            return "redirect:/user4/list";
        }

        @GetMapping("/user4/delete")
        public String delete(@RequestParam("uid") String uid){
            service.deleteUser4(uid);
            return "redirect:/user4/list";
        }


}
