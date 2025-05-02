package com.storia.services;


import com.storia.models.Email;
import com.storia.repositories.EmailRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EmailService {

    @Inject
    EmailRepository emailRepository;

    public List<Email> findAll(){
        return emailRepository.listAll();
    }
    public Email findById(Long id){
        return  emailRepository.findById(id);
    }

}
