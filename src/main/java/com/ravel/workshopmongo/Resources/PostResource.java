package com.ravel.workshopmongo.Resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ravel.workshopmongo.domain.Post;
import com.ravel.workshopmongo.services.PostService;
import com.ravel.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/{id}",  method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post Post = service.findById(id);
		return ResponseEntity.ok().body(Post);
	}
	
	@RequestMapping(value="/{userId}/titlesearch", method=RequestMethod.GET)
 	public ResponseEntity<List<Post>> findByPostNotIn(@PathVariable String userId) {
		List<Post> userPosts = userService.findById(userId).getPosts();
		List<String> titles = service.getTitlesFromPosts(userPosts);
	    List<Post> list = service.findByPostNotIn(titles);
		return ResponseEntity.ok().body(list);
	}
	
	
}
