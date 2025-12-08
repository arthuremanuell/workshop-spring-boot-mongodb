package com.emanuelarthur.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.emanuelarthur.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{<fields>: { $regex: /pattern/, $options: '<option>'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
	
}
