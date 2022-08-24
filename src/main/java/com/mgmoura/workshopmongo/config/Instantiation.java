package com.mgmoura.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mgmoura.workshopmongo.domain.User;
import com.mgmoura.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
				
		User ace = new User(null, "Ace Frehley", "ace@gmail.com");
		User peter = new User(null, "Peter Criss", "peter@gmail.com");
		User paul = new User(null, "Paul Stanley", "paul@gmail.com");
		
		userRepository.saveAll(Arrays.asList(ace , peter , paul));
		
	}

}
