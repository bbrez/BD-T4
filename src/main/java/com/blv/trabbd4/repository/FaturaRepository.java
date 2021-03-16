package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Fatura;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FaturaRepository extends CrudRepository<Fatura, Long> {
    Optional<Fatura> findById(Long id);
}
