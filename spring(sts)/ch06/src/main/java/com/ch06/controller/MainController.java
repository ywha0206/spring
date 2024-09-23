package com.ch06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MainController {
	
	@GetMapping(value = {"/","/index"})
	public String index(Model model) {
		
		String str1 = "Hello World!";
		String str2 = "Hello Spring Boot!";

		
		
		return "index";
	}
	
}
