package com.felipejf05.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipejf05.workshopmongo.domain.Post;
import com.felipejf05.workshopmongo.domain.User;
import com.felipejf05.workshopmongo.dto.AuthorDTO;
import com.felipejf05.workshopmongo.respository.PostRepository;
import com.felipejf05.workshopmongo.respository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

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
		
		User denys = new User(null, "Denys Dias", "denys@gmail.com");
		User guilherme = new User(null, "Guilherme Martins", "guilherme@gmail.com");
		User tamires = new User(null, "Tamires Grotewoold", "tamires@gmail.com");
		
		userRepository.saveAll(Arrays.asList(denys, guilherme, tamires));
		
		Post post1 = new Post(null, sdf.parse("21/01/2023"), "Partiu viagem!", "Vou viajar para São Paulo, abraços!", new AuthorDTO(guilherme));
		Post post2 = new Post(null, sdf.parse("21/01/2023"), "Bom dia!", "Partiu Ubatuba!", new AuthorDTO(guilherme));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		guilherme.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(guilherme);
	}

}
