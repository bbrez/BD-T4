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
    public Fatura(Date emissao, int numeroParcelas, String situacao, List<Parcela> parcelas) {
        this.emissao = emissao;
        this.numeroParcelas = numeroParcelas;
        this.situacao = situacao;
        this.valorTotal = parcelas.stream().mapToDouble(Parcela::getValor).sum();
        this.setParcela(parcelas);
    }

    public String toString(){
        return "id da fatura: " + idFatura + " data de emissao: " + emissao + " numero de parcelas: " + numeroParcelas + " situacao atual: " + situacao + " valor total: " + valorTotal + " saldo a pagar" + saldoPagar;
    }

    public void setParcela(List<Parcela> parcelas) {
        parcelas.forEach((k) -> k.setFatura(this));
        this.parcelas = parcelas;
    }

    public void setParcela(List<Parcela> parcelas) {
        parcelas.forEach((k) -> k.setFatura(this));
        this.parcelas = parcelas;
    }

    public Long getId() {
        return this.idFatura;
    }
}
