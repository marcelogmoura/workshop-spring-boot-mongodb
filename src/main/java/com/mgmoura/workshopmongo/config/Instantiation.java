package com.mgmoura.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mgmoura.workshopmongo.domain.Post;
import com.mgmoura.workshopmongo.domain.User;
import com.mgmoura.workshopmongo.repository.PostRepository;
import com.mgmoura.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
 

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
				
		User ace = new User(null, "Ace Frehley", "ace@gmail.com");
		User peter = new User(null, "Peter Criss", "peter@gmail.com");
		User paul = new User(null, "Paul Stanley", "paul@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Estou indo para o Canadá" , ace);
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Sextou !!", "Amanhã é dia !" , ace);
		
		userRepository.saveAll(Arrays.asList(ace , peter , paul));
		postRepository.saveAll(Arrays.asList(post1 , post2));
		
	}

}
