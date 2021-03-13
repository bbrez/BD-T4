package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Telefone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TelefoneRepository extends CrudRepository<Telefone, Long> {
    List<Telefone> findByTelefone(String telefone);
}
