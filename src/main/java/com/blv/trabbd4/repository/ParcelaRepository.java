package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.EstadoPagamento;
import com.blv.trabbd4.model.Parcela;
import org.springframework.data.repository.CrudRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ParcelaRepository extends CrudRepository<Parcela, Long> {

    List<Parcela> findBySituacao(EstadoPagamento situacao);

    List<Parcela> findByPagamento(Date data);

    List<Parcela> findByPagamentoBetween(Date start, Calendar end);

    Optional<Parcela> findById(Long id);
}