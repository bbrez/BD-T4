package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Cidade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {
    Cidade findByNome(String nome);
}
