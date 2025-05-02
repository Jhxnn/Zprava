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

    private List<User> findAll(){
        return userRepository.listAll();
    }
    private User findById(long id){
        return userRepository.findById(id);
    }

}
