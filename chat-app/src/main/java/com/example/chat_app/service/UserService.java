package com.example.chat_app.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.chat_app.model.User;
import com.example.chat_app.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + username));

		System.out.println("Utilisateur trouvé : " + user.getUsername());
		System.out.println("Mot de passe en base : " + user.getPassword());
		System.out.println("Rôle en base : " + user.getRole());

		// Ajoute le préfixe ROLE_ si ce n'est pas déjà présent
		String fullRole = user.getRole().startsWith("ROLE_") ? user.getRole() : "ROLE_" + user.getRole();
		System.out.println("Rôle attribué dans Spring Security : " + fullRole);

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				Collections.singleton(new SimpleGrantedAuthority(fullRole)));
	}

	// Vérifie si un utilisateur existe déjà
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	// Regroupe la création et l'encodage du mot de passe
	public void registerUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		if (user.getRole() == null) {
			user.setRole("USER"); // Par défaut, chaque utilisateur est un "USER"
		}
		userRepository.save(user);
	}

}
