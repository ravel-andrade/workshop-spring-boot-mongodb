package com.ravel.workshopmongo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravel.workshopmongo.domain.Post;
import com.ravel.workshopmongo.repository.PostRepository;
import com.ravel.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByPostNotIn(List<String> post) {
		return repo.findByTitleNotIn(post);
	}
	
	public List<String> getTitlesFromPosts(List<Post> posts){
		List<String> titles = new ArrayList<>();
		for (Post post : posts) {
			titles.add(post.getTitle());
		}
		return titles;
	}
}