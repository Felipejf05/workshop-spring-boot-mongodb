package com.felipejf05.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipejf05.workshopmongo.domain.User;
import com.felipejf05.workshopmongo.respository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User denys = new User(null, "Denys Dias", "denys@gmail.com");
		User guilherme = new User(null, "Guilherme Martins", "guilherme@gmail.com");
		User tamires = new User(null, "Tamires Grotewoold", "tamires@gmail.com");
		
		userRepository.saveAll(Arrays.asList(denys, guilherme, tamires));
	}

}
