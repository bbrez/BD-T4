package com.blv.trabbd4.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable=false)
    private String nome;

    @Column(nullable=false)
    private String sobrenome;

    @Column(nullable=false, unique=true)
    private String cpf;

    @ManyToOne
    @JoinColumn(name="id_endereco_residencial")
    private EnderecoEspecifico enderecoResidencial;

    @ManyToOne
    @JoinColumn(name="id_endereco_comercial")
    private EnderecoEspecifico enderecoComercial;

    @OneToMany(mappedBy = "cliente")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Fatura> faturas;

    @OneToMany(mappedBy = "cliente")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Email> emails;

    public Long getId(){return idCliente;}

    public Cliente(){}
    public Cliente(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.emails = new ArrayList<>();
        this.faturas = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

}
