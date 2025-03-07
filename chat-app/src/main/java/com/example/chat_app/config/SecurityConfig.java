package com.example.chat_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.chat_app.service.UserService;

import jakarta.servlet.http.HttpSession;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationSuccessHandler successHandler)
			throws Exception {
		http.authorizeHttpRequests(authz -> authz.requestMatchers("/chat", "/register").permitAll()
				.requestMatchers("/users").hasRole("ADMIN").requestMatchers("/conversations/**").hasRole("ADMIN")
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/chat", true)
						.successHandler(successHandler).permitAll())
				.logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll())
				.exceptionHandling(exception -> exception.accessDeniedPage("/403"))
				.csrf().disable();

		return http.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, UserService userService,
			PasswordEncoder passwordEncoder) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(passwordEncoder);
		return authenticationManagerBuilder.build();
	}

	@Bean
	public AuthenticationSuccessHandler successHandler() {
		return (request, response, authentication) -> {
			String username = authentication.getName();
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// LOGS IMPORTANTS
			System.out.println("✅ Connexion réussie pour : " + username);
			System.out.println("✅ Session ID : " + session.getId());
			System.out.println("✅ Rôles attribués : " + authentication.getAuthorities());

			response.sendRedirect("/chat");
		};
	}

}
