package com.ravel.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravel.workshopmongo.domain.User;
import com.ravel.workshopmongo.dto.UserDTO;
import com.ravel.workshopmongo.repository.UserRepository;
import com.ravel.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
	
	public User update(User user) {
		Optional<User> newUser = repo.findById(user.getId());
		updateData(newUser, user);
		return repo.save(newUser.get());
	}
	
	private void updateData(Optional<User> newUser, User user) {
		newUser.get().setName(user.getName());
		newUser.get().setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
	}
}