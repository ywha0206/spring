package com.ch05.controller;


import com.ch05.dto.User5Dto;
import com.ch05.service.User5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User5Controller {

    private User5Service service;

    @Autowired
    public User5Controller(User5Service service) {
        this.service = service;
    }

        @GetMapping("/user5/list")
        public String list(Model model){
            List<User5Dto> users = service.selectUser5s();
            model.addAttribute("users", users);
            return "/user5/list";
        }

        @GetMapping("/user5/register")
        public String register(){
            return "/user5/register";
        }
        @PostMapping("/user5/register")
        public String register(User5Dto user5Dto){
            service.insertUser5(user5Dto);
            return "redirect:/user5/list";
        }

        @GetMapping("/user5/modify")
        public String modify(@RequestParam("seq") String seq, Model model){
            User5Dto user = service.selectUser5(seq);
            model.addAttribute("user", user);
            return "/user5/modify";
        }

        @PostMapping("/user5/modify")
        public String modify(@ModelAttribute User5Dto dto){
            service.updateUser5(dto);
            return "redirect:/user5/list";
        }

        @GetMapping("/user5/delete")
        public String delete(@RequestParam("seq") String seq){
            service.deleteUser5(seq);
            return "redirect:/user5/list";
        }


}
