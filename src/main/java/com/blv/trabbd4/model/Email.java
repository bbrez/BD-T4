package com.blv.trabbd4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idEmail;
    private String email;

    public Email() {
    }

    public Email(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" +
                "idEmail=" + idEmail +
                ", email='" + email + '\'' +
                '}';
    }
}
