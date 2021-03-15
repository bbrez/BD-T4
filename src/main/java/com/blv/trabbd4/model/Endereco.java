package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column(nullable=false)
    private String logradouro;

    @Column(nullable=false, unique=true)
    private String CEP;

    @ManyToOne
    @JoinColumn(name="id_cidade", nullable = false)
    private Cidade cidade;

    @OneToMany(mappedBy = "endereco")
    private List<EnderecoEspecifico> enderecoEspecificos;

    public Endereco(){}

    public Endereco(String logradouro, String CEP, Cidade cidade){
        this.logradouro = logradouro;
        this.CEP = CEP;
        this.cidade = cidade;
    }
}
