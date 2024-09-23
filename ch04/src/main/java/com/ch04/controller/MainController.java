package com.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.*;

@Controller
public class MainController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello...");
        return "hello";
    }

    @GetMapping("/welcome")
    public String welcome(){
        System.out.println("welcome...");
        return "welcome";
    }
    @GetMapping("/greeting")
    public void greeting(){
        System.out.println("greeting...");
    }
}