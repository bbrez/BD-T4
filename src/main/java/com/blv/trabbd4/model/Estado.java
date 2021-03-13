package com.blv.trabbd4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstado;
    private String UF;

    public Estado(){ }

    public Estado(String UF){
        this.UF = UF;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "idEstado=" + idEstado +
                ", UF='" + UF + '\'' +
                '}';
    }
}
