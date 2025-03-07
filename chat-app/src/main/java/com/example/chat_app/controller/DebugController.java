package com.example.chat_app.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class DebugController {

	@GetMapping("/debugRoles")
	public Collection<?> getUserRoles(@AuthenticationPrincipal User user) {
		return user.getAuthorities(); // Retourne les rôles en session
	}
}
