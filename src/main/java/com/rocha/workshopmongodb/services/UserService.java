package com.rocha.workshopmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rocha.workshopmongodb.domain.User;
import com.rocha.workshopmongodb.dto.UserDTO;
import com.rocha.workshopmongodb.repository.UserRepository;
import com.rocha.workshopmongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> obj = repo.findById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Object not found");
		}
		return obj;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	/*
	 * public User update(String id, User obj) {
	 * 
	 * entity = findById(id); updateData(entity, obj); return insert(entity);
	 * 
	 * }
	 * 
	 * private void updateData(User entity, User obj) {
	 * entity.setName(obj.getName()); entity.setEmail(obj.getEmail()); }
	 */
	
}
