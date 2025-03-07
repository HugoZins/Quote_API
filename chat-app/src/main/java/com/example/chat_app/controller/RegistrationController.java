package com.example.chat_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.chat_app.model.User;
import com.example.chat_app.service.UserService;

@Controller
public class RegistrationController {

	private final UserService userService;

	public RegistrationController(UserService userService) {
		this.userService = userService;
	}

	// Affiche la page d'inscription
	@GetMapping("/register")
	public String showRegistrationPage() {
		return "register";
	}

	// Enregistre un nouvel utilisateur
	@PostMapping("/register")
	public String registerUser(@RequestParam String username, @RequestParam String password, Model model) {

		try {
			if (userService.existsByUsername(username)) {
				model.addAttribute("error", "Ce nom d'utilisateur est déjà pris.");
				return "register";
			}

			User newUser = new User(username, password);
			userService.registerUser(newUser);

			return "redirect:/login";
		} catch (Exception e) {
			model.addAttribute("error", "Erreur lors de l'inscription : " + e.getMessage());
			return "register";
		}
	}
}
