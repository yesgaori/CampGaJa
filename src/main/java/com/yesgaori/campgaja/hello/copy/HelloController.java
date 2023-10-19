package com.yesgaori.campgaja.hello.copy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		
		return "helloworld !!~~~";
		
	}
	
}
