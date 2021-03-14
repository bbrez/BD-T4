package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String sobrenome;
    private String cpf;

    @ManyToOne
    @JoinColumn(name="id_endereco")
    private EnderecoEspecifico enderecoResidencial;

    @ManyToOne
    @JoinColumn(name="id_endereco")
    private EnderecoEspecifico enderecoComercial;

    @OneToMany(mappedBy = "telefones", fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "faturas", fetch = FetchType.LAZY)
    private List<Fatura> faturas;

    @OneToMany(mappedBy = "emails", fetch = FetchType.LAZY)
    private List<Email> emails;

    public Cliente(){}
    public Cliente(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

}
