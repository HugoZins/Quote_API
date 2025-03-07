package com.example.quote_api.service;

import org.springframework.stereotype.Service;

import com.example.quote_api.model.Quote;
import com.example.quote_api.repository.QuoteRepository;

@Service
public class QuoteService {

	private final QuoteRepository quoteRepository;

	public QuoteService(QuoteRepository quoteRepository) {
		this.quoteRepository = quoteRepository;
	}

	public Quote getRandomQuote() {
		return quoteRepository.findRandomQuote();
	}
}
