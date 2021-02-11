package com.ravel.workshopmongo.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravel.workshopmongo.domain.Post;
import com.ravel.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;


	
	@RequestMapping(value="/{id}",  method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post Post = service.findById(id);
		return ResponseEntity.ok().body(Post);
	}
	
	
}
