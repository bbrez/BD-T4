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

    @Column(nullable=false)
    double ValorParcela;

    @Column(nullable=false)
    Date vencimento;

    Date pagamento = null;

    @Enumerated
    EstadoPagamento situacao;

    @ManyToOne
    Fatura fatura;

    public Parcela(){}

    public Parcela(double valorParcela, Date vencimento, EstadoPagamento situacao, Fatura fatura) {
        ValorParcela = valorParcela;
        this.vencimento = vencimento;
        this.situacao = situacao;
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        String pago;
        if (pagamento != null) pago = vencimento.toString();
        else pago = "";
        return "id da parcela: " + idParcela + " vencimento: " + vencimento + " situacao atual: " + pago + "  " + situacao + " pertencente a fatura: " + fatura.getId();
    }
}