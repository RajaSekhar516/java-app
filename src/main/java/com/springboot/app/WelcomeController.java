package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {
 @GetMapping("/welcome")
	public String welcome() {
	 return "WELCOME to spring boot app made by Rajasekhar";
 }
}
