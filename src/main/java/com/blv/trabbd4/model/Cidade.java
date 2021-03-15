package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCidade;

    @Column(nullable=false)
    private String nome;

    @ManyToOne
    @JoinColumn(name="id_estado", nullable = false)
    private Estado estado;

    @OneToMany(mappedBy = "cidade", fetch = FetchType.EAGER)
    private List<Endereco> enderecos;


    public Cidade(){}
    public Cidade(String nome, Estado estado){
        this.nome = nome;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nome='" + nome + '\'' +
                ", Estado='" + estado.getUF() + '\'' +
                '}';
    }
}
