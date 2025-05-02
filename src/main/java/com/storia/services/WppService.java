package com.storia.services;

import com.storia.models.WhatsApp;
import com.storia.repositories.WppRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class WppService {

    @Inject
    WppRepository wppRepository;

    public List<WhatsApp> findAll(){
        return wppRepository.listAll();
    }

    public WhatsApp findById(long id){
        return wppRepository.findById(id);
    }

}
