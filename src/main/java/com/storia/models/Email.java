package com.storia.models;

import jakarta.persistence.*;

@Entity
@Table(name = "emails")
public class Email{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emailId;

    private long userEmail;

    private String content;

    private String title;

    private String sender;

    public long getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(long userEmail) {
        this.userEmail = userEmail;
    }

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
