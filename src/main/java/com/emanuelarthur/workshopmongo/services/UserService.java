package com.emanuelarthur.workshopmongo.services;

import java.util.List;
import com.emanuelarthur.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emanuelarthur.workshopmongo.domain.User;
import com.emanuelarthur.workshopmongo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}