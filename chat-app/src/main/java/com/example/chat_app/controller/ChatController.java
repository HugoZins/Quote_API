package com.example.chat_app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.chat_app.model.ChatMessage;
import com.example.chat_app.service.ChatService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChatController {

	private final ChatService chatService;

	public ChatController(ChatService chatService) {
		this.chatService = chatService;
	}

	/**
	 * Affiche la page de chat avec la conversation de l'utilisateur actuel.
	 */
	@GetMapping("/chat")
	public String showChatPage(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");

		if (username != null) {
			// Charge les messages de l'utilisateur courant
			List<ChatMessage> chatMessages = chatService.getMessagesByUsername(username);
			model.addAttribute("chatMessages", chatMessages);
			model.addAttribute("username", username);
		} else {
			// Redirige vers la page de login si l'utilisateur n'est pas connecté
			return "redirect:/login";
		}

		return "chat";
	}

	/**
	 * Enregistre le message envoyé et obtient une réponse inspirante. Utilise
	 * RedirectAttributes pour rediriger après l'envoi du message.
	 */
	@PostMapping("/sendMessage")
	public String sendMessage(@RequestParam String message, HttpSession session,
			RedirectAttributes redirectAttributes) {
		String username = (String) session.getAttribute("username");

		if (username == null || username.isEmpty()) {
			return "redirect:/login"; // Redirige vers la page de login si le nom d'utilisateur est invalide
		}

		// Convertir le nom d'utilisateur : première lettre en majuscule, le reste en
		// minuscule
		username = username.substring(0, 1).toUpperCase() + username.substring(1).toLowerCase();

		ChatMessage chatMessage = chatService.saveMessage(username, message); // Enregistre le message
		List<ChatMessage> chatMessages = chatService.getMessagesByUsername(username); // Récupère les messages de
																						// l'utilisateur

		// Ajoute des attributs pour afficher les messages et la réponse sur la page
		// après la redirection
		redirectAttributes.addFlashAttribute("chatMessages", chatMessages);
		redirectAttributes.addFlashAttribute("username", username);
		redirectAttributes.addFlashAttribute("response", chatMessage.getResponse());

		// Redirige vers la page de chat
		return "redirect:/chat";
	}

	/**
	 * Affiche la liste des utilisateurs ayant posté des messages.
	 */
	@GetMapping("/users")
	@PreAuthorize("hasRole('ADMIN')")
	public String showUsers(Model model) {
		List<String> users = chatService.getAllUsernames();

		// Appliquer la transformation à chaque nom d'utilisateur
		users = users.stream().map(user -> user.substring(0, 1).toUpperCase() + user.substring(1).toLowerCase())
				.collect(Collectors.toList());

		model.addAttribute("users", users);
		return "users";
	}

	/**
	 * Affiche la conversation d'un utilisateur spécifique.
	 */
	@GetMapping("/conversations/{username}")
	public String showUserMessages(@PathVariable String username, Model model) {
		model.addAttribute("messages", chatService.getMessagesByUsername(username));
		model.addAttribute("username", username);
		return "conversation";
	}

}
