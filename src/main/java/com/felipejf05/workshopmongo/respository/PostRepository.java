package com.felipejf05.workshopmongo.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipejf05.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
