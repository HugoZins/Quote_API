package com.example.chat_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	// Affiche la page de connexion
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
}
