package com.example.chat_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat_app.model.ChatMessage;

public interface ChatRepository extends JpaRepository<ChatMessage, Long> {
	List<ChatMessage> findByUsernameOrderByDateAsc(String username);

	List<ChatMessage> findByUsername(String username); // Méthode pour récupérer les messages d'un utilisateur

	List<ChatMessage> findAllByOrderByDateAsc(); // Récupérer tous les messages, triés par date
}
