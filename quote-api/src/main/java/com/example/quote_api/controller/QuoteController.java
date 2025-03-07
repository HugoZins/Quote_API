package com.example.quote_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quote_api.model.Quote;
import com.example.quote_api.service.QuoteService;

@RestController
@RequestMapping("/api/quotes")
@CrossOrigin("*")
public class QuoteController {

	private final QuoteService quoteService;

	public QuoteController(QuoteService quoteService) {
		this.quoteService = quoteService;
	}

	@GetMapping("/getQuote")
	public ResponseEntity<Quote> getQuote() {
		Quote quote = quoteService.getRandomQuote();
		return ResponseEntity.ok(quote);
	}
}
