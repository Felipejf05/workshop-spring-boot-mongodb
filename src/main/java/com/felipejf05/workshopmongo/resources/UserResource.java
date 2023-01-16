package com.felipejf05.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.felipejf05.workshopmongo.domain.User;

@RestController
@RequestMapping(value= "/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Santos", "mariasantos@gmail.com");
		User carlos = new User("2", "Carlos", "carlos@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, carlos));
		return ResponseEntity.ok().body(list);
		
	}

}
