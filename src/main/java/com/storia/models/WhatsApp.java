package com.storia.models;

import jakarta.persistence.*;

@Entity
@Table(name = "whatsapp")
public class WhatsApp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wppId;

    private String wppNumber;

    @JoinColumn(referencedColumnName = "id", name = "email_id")
    private Email email;

    public long getWppId() {
        return wppId;
    }

    public void setWppId(long wppId) {
        this.wppId = wppId;
    }

    public String getWppNumber() {
        return wppNumber;
    }

    public void setWppNumber(String wppNumber) {
        this.wppNumber = wppNumber;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
