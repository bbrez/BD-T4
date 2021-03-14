package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EnderecoEspecifico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEnderecoEspecifico;
    private Long numero;
    private String complemento;

    @ManyToOne
    @JoinColumn(name="id_endereco", nullable = false)
    private Endereco endereco;

    public EnderecoEspecifico(){}

    public EnderecoEspecifico(Long numero, String complemento, Endereco endereco){
        this.numero = numero;
        this.complemento = complemento;
        this.endereco = endereco;
    }
}
