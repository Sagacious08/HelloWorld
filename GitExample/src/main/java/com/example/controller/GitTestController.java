package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Git")
public class GitTestController {
	
	@GetMapping("/getMessage")
	public String getMessage() {
		System.out.println("Mumbai");
		System.out.println("Pune");
		System.out.println("Dhule");
		
		return "Hello World";
		
	}

}
