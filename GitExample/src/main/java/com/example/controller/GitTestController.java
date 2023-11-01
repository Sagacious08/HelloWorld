package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Git")
public class GitTestController {
	
	@GetMapping("/getMessage")
	public String getMessage() {
		System.out.println("Mumbai");
		return "Hello World";
		
	}

}
