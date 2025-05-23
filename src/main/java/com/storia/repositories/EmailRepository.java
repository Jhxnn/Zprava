package com.storia.repositories;

import com.storia.models.Email;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmailRepository implements PanacheRepository<Email> {
}
