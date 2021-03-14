package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Fatura{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFatura;

    Date emissao;
    int numeroParcelas;
    String situacao;
    double valorTotal;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Fatura(){}
    public Fatura(Date emissao, int numeroParcelas, String situacao, double valorTotal) {
        this.emissao = emissao;
        this.numeroParcelas = numeroParcelas;
        this.situacao = situacao;
        this.valorTotal = valorTotal;
    }

    public String toString(){
        return "id da fatura: " + idFatura + " data de emissao: " + emissao + " numero de parcelas: " + numeroParcelas + " situacao atual: " + situacao + " valor total: " + valorTotal;
    }

}
