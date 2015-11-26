package com.my.quickstart.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController{ 
	
	@PreAuthorize("hasAuthority('ROLE_WELCOME')")
	@RequestMapping("/welcome")
	@ResponseBody
	public String home() {
		return "hello word !";
	}
}
