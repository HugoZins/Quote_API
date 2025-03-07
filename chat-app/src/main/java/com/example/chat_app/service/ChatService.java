package com.example.chat_app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.chat_app.model.ChatMessage;
import com.example.chat_app.repository.ChatRepository;

@Service
public class ChatService {

	private final ChatRepository chatRepository;
	private final RestTemplate restTemplate;

	public ChatService(ChatRepository chatRepository, RestTemplate restTemplate) {
		this.chatRepository = chatRepository;
		this.restTemplate = restTemplate;
	}

	public ChatMessage saveMessage(String username, String message) {
		// Effectuer la requête pour obtenir la quote et l'auteur de l'API quote-api
		String quoteApiUrl = "http://localhost:8080/api/quotes/getQuote"; // L'URL de l'API quote-api
		ResponseEntity<String> response = restTemplate.getForEntity(quoteApiUrl, String.class);

		// La réponse est un JSON de type {"text": "...", "author": "..."}
		String responseBody = response.getBody();

		// Extraire la citation et l'auteur du JSON
		String quoteText = extractQuoteText(responseBody);
		String author = extractAuthor(responseBody);

		// Créer et sauvegarder le message avec la réponse et l'auteur
		ChatMessage chatMessage = new ChatMessage();
		chatMessage.setUsername(username);
		chatMessage.setMessage(message);
		chatMessage.setResponse(quoteText);
		chatMessage.setQuoteAuthor(author);
		chatMessage.setDate(LocalDateTime.now());

		return chatRepository.save(chatMessage);
	}

	private String extractQuoteText(String responseBody) {
		// Extraire le texte de la citation du JSON
		// Exemple : {"text": "La vie c’est...", "author": "Albert Einstein"}
		int start = responseBody.indexOf("\"text\":\"") + 8;
		int end = responseBody.indexOf("\"", start);
		return responseBody.substring(start, end);
	}

	private String extractAuthor(String responseBody) {
		// Extraire l'auteur du JSON
		int start = responseBody.indexOf("\"author\":\"") + 10;
		int end = responseBody.indexOf("\"", start);
		return responseBody.substring(start, end);
	}

	public List<String> getAllUsernames() {
		// Récupérer tous les messages et extraire les noms d'utilisateur
		List<ChatMessage> chatMessages = chatRepository.findAllByOrderByDateAsc();

		return chatMessages.stream().map(chatMessage -> chatMessage.getUsername().toLowerCase()) // Convertir en
																									// minuscule
				.distinct() // Supprimer les doublons
				.collect(Collectors.toList());
	}

	public List<ChatMessage> getMessagesByUsername(String username) {
		// Normaliser le nom d'utilisateur
		username = username.toLowerCase();
		return chatRepository.findByUsername(username); // Appel au repository pour récupérer les messages
	}

}
