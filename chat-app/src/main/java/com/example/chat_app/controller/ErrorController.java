package com.example.chat_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

	@GetMapping("/403")
	public String accessDenied() {
		return "403"; // Retourne la vue 403.html
	}
}
