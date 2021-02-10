package com.ravel.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ravel.workshopmongo.domain.Post;
import com.ravel.workshopmongo.domain.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}