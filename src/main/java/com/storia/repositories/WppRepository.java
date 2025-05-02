package com.storia.repositories;


import com.storia.models.WhatsApp;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class WppRepository implements PanacheRepository<WhatsApp> {
}
