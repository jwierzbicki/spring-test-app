package com.example.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springtest.model.Greeting;

@Controller
public class MainController {
	
	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}
	
	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting) {
		
		String message = greeting.getContent();
		
		if(message != null) {
			
			if(message.toUpperCase().equals(message)) {
				greeting.setContent(message.toLowerCase());
			} else {
				greeting.setContent(message.toUpperCase());							
			}
		}
		
		if(message.isEmpty()) {
			greeting.setContent("You have to enter some text first!");
		}
		
		return "result";
	}
	
	@GetMapping("/sometext")
	public String someText() {
		return "some-text";
	}
}
