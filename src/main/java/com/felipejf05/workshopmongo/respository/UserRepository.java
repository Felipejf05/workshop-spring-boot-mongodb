package com.felipejf05.workshopmongo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.felipejf05.workshopmongo.domain.User;


public interface UserRepository extends MongoRepository<User, String> {

}
