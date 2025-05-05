package com.storia.services;

import com.storia.models.User;
import com.storia.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserService {

    @Inject
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.listAll();
    }
    public User findById(long id){
        return userRepository.findById(id);
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

}
