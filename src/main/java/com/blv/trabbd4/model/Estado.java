package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    @Column(nullable=false, unique=true)
    private String UF;

    @OneToMany(mappedBy = "estado", fetch = FetchType.EAGER)
    private List<Cidade> cidades;

    public Estado(){ }

    public Estado(String UF){
        this.UF = UF;
    }

    public String getUF() {
        return UF;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", UF='" + UF + '\'' +
                ", Cidades=" + cidades.size() +
                '}';
    }
}
