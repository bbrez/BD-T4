package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.EstadoPagamento;
import com.blv.trabbd4.model.Parcela;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ParcelaRepository extends CrudRepository<Parcela, Long> {

    List<Parcela> findBySituacao(EstadoPagamento situacao);

    List<Parcela> findByPagamento(Date data);
}