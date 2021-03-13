package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Estado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoRepository extends CrudRepository<Estado, Long> {
    List<Estado> findByUF(String UF);
}
