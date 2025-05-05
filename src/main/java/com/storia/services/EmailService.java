package com.storia.services;


import com.fasterxml.jackson.databind.util.BeanUtil;
import com.storia.config.EmailReader;
import com.storia.dtos.EmailDto;
import com.storia.models.Email;
import com.storia.repositories.EmailRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class EmailService {

    @Inject
    EmailRepository emailRepository;

    @Inject
    UserService userService;

    @Inject
    EmailReader emailReader;

    public List<Email> findAll(){
        return emailRepository.listAll();
    }
    public Email findById(Long id){
        return  emailRepository.findById(id);
    }
    public List<EmailDto> readEmail(String filter) throws Exception {
        List<EmailDto> listEmail = emailReader.readEmailWithFilter(filter);
        for(EmailDto emailDto : listEmail){
            Email email = new Email();
            email.setContent(emailDto.content());
            email.setSender(emailDto.sender());
            email.setTitle(emailDto.title());
//            email.setUser(userService.findByEmail(emailDto.userEmail()));
            emailRepository.persist(email);
        }
        return listEmail;
    }

}
