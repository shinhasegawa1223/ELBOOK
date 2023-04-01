package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Service.BookService;

@Controller
public class IndexController {
	@Autowired
	BookService bookService;

	@GetMapping
	public String index() {
		return "redirect:/book/list";
	}

	@GetMapping("login")
	public String showLoginForm() {
		return "login";
	}
	@GetMapping("/index/showsignup")
	public String showsignupForm() {
		return "indexsignup";
	}

	@GetMapping("logout")
	public String showLogoutForm() {
		return "logout";
	}
}


