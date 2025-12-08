package com.emanuelarthur.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuelarthur.workshopmongo.domain.Post;
import com.emanuelarthur.workshopmongo.repository.PostRepository;
import com.emanuelarthur.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Post> findByTitleList(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}