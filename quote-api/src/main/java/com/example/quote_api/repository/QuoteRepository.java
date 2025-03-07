package com.example.quote_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.quote_api.model.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
	@Query(value = "SELECT * FROM Quote ORDER BY RAND() LIMIT 1", nativeQuery = true)
	Quote findRandomQuote();
}
