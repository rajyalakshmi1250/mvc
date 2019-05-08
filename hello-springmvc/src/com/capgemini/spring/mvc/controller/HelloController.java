package com.capgemini.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	
		@RequestMapping("/hello/{name}")
		
		public String sayHello1(@PathVariable String name,Model model ) {
			model.addAttribute("message","hi");
			return "hello";
		

}
	
		@RequestMapping("/hello/{name}")
		
		public String sayHello(@RequestParam String name,Model model ) {
			model.addAttribute("message","hi");
			return "hello";
		
}
}
