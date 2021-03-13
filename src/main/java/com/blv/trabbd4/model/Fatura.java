package com.blv.trabbd4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Fatura{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFatura;

    Date emissao;
    int numeroParcelas;
    String situacao;
    double ValorTotal;

    public Fatura(Date emissao, int numeroParcelas, String situacao, double valorTotal) {
        this.emissao = emissao;
        this.numeroParcelas = numeroParcelas;
        this.situacao = situacao;
        ValorTotal = valorTotal;
    }

    public String toString(){
        return "id da fatura: " + idFatura + " data de emissao: " + emissao + " numero de parcelas: " + numeroParcelas + " situacao atual: " + situacao + " valor total: " + ValorTotal;
    }

    //Cliente idCliente;

}
