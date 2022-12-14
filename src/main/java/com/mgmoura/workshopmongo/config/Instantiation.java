package com.mgmoura.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mgmoura.workshopmongo.domain.Post;
import com.mgmoura.workshopmongo.domain.User;
import com.mgmoura.workshopmongo.dto.AuthorDTO;
import com.mgmoura.workshopmongo.dto.CommentDTO;
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
		
		userRepository.saveAll(Arrays.asList(ace , peter , paul));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Estou indo para o Canadá" , new AuthorDTO(ace));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Sextou !!", "Amanhã é dia !" , new AuthorDTO(ace));
			
		CommentDTO c1 = new CommentDTO("Boa viagem", sdf.parse("21/03/2018"), new AuthorDTO(peter));
		CommentDTO c2 = new CommentDTO("Uhuuu", sdf.parse("22/03/2018"), new AuthorDTO(paul));
		CommentDTO c3 = new CommentDTO("Bom dia", sdf.parse("23/03/2018"), new AuthorDTO(peter));
		
		post1.getComments().addAll(Arrays.asList(c1 , c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1 , post2));
		
		ace.getPosts().addAll(Arrays.asList(post1 , post2));
		userRepository.save(ace);
		
	}

}
