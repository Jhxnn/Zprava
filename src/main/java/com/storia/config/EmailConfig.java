package com.storia.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class EmailConfig {

    @Inject
    @ConfigProperty(name = "email.username")
    String username;

    @Inject
    @ConfigProperty(name = "email.password")
    String password;

    String host = "imap.gmail.com";


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
