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
    double valorParcela;

    @Column(nullable=false)
    Date vencimento;

    Date pagamento = null;

    @Enumerated
    EstadoPagamento situacao;

    @ManyToOne
    Fatura fatura;

    public Parcela(){}

    public Parcela(double valorParcela, Date vencimento, EstadoPagamento situacao, Fatura fatura) {
        valorParcela = valorParcela;
        this.vencimento = vencimento;
        this.situacao = situacao;
        this.fatura = fatura;
    }

    public Parcela(Double v, Date date, EstadoPagamento estadoPagamento) {
        this.valorParcela = v;
        this.vencimento = date;
        this.situacao = estadoPagamento;
    }

    @Override
    public String toString() {
        String pago;
        if (pagamento != null) pago = vencimento.toString();
        else pago = "";
        return "id da parcela: " + idParcela + " vencimento: " + vencimento + " situacao atual: " + situacao + "  " + pago;
    }
}