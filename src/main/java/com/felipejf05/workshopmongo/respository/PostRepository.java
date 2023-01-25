package com.felipejf05.workshopmongo.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.felipejf05.workshopmongo.domain.Post;


public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
