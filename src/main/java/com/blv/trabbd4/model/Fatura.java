package com.blv.trabbd4.model;

import com.blv.trabbd4.repository.ParcelaRepository;
import lombok.Data;
import org.springframework.data.jdbc.repository.support.SimpleJdbcRepository;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Fatura{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFatura;

    @Column(nullable=false)
    Date emissao;

    @Column(nullable=false)
    int numeroParcelas;

    @Column(nullable=false)
    String situacao;

    @Column(nullable=false)
    double valorTotal;

    @Column(nullable=false)
    double saldoPagar;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "fatura", fetch = FetchType.EAGER)
    private List<Parcela> parcelas;


    public Fatura(){}
    public Fatura(Date emissao, int numeroParcelas, double valorTotal, Cliente cliente) {
        this.emissao = emissao;
        this.numeroParcelas = numeroParcelas;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.situacao = "";
    }

    public String toString(){
        return "id da fatura: " + idFatura + " data de emissao: " + emissao + " numero de parcelas: " + numeroParcelas + " valor total: " + valorTotal;
    }


    public Long getId() {
        return this.idFatura;
    }
}
