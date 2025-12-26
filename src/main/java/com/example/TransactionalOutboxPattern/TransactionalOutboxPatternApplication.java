package com.example.TransactionalOutboxPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TransactionalOutboxPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalOutboxPatternApplication.class, args);
	}

}
