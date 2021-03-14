package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmail;
    private String email;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Email() { }
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
