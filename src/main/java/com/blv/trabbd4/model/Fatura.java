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
    double valorTotal;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Fatura(){}
    public Fatura(Date emissao, int numeroParcelas, double valorTotal, Cliente cliente) {
        this.emissao = emissao;
        this.numeroParcelas = numeroParcelas;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public String toString(){
        return "id da fatura: " + idFatura + " data de emissao: " + emissao + " numero de parcelas: " + numeroParcelas + " valor total: " + valorTotal;
    }

}
