package com.emanuelarthur.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.emanuelarthur.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuelarthur.workshopmongo.domain.User;
import com.emanuelarthur.workshopmongo.dto.UserDTO;
import com.emanuelarthur.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
	    User newObj = repo.findById(obj.getId())
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

	    updateData(newObj, obj);

	    return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
	    newObj.setName(obj.getName());
	    newObj.setEmail(obj.getEmail());
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
 
}