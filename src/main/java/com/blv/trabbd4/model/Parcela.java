package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParcela;

    double ValorParcela;
    Date vencimento;
    String situacao;

    @ManyToOne
    Fatura fatura;

    public Parcela(){}

    public Parcela(double valorParcela, Date vencimento, String situacao) {
        ValorParcela = valorParcela;
        this.vencimento = vencimento;
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "id da parcela: " + idParcela + " vencimento: " + vencimento + " situacao atual: " + situacao + " pertencente a fatura: " + fatura;
    }

}