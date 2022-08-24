package com.mgmoura.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mgmoura.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping  // ou @RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){		
		User ace = new User("1", "Ace Frehley", "ace@gmail.com");
		User peter = new User("2", "Peter Criss", "peter@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(ace , peter));
			
		return ResponseEntity.ok().body(list);
		
		
	}

}
