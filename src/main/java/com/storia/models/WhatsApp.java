package com.storia.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "whatsapp")
public class WhatsApp extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long wppId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "email_id")
    private Email email;

    public long getWppId() {
        return wppId;
    }

    public void setWppId(long wppId) {
        this.wppId = wppId;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
