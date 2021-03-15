package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTelefone;

    @Column(nullable=false, unique=true)
    private String telefone;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Telefone() {
    }

    public Telefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "idTelefone=" + idTelefone +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
