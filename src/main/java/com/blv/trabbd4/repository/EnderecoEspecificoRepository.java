package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.EnderecoEspecifico;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoEspecificoRepository extends CrudRepository<EnderecoEspecifico, Long> {
    List<EnderecoEspecifico> findByNumero(Long numero);
    List<EnderecoEspecifico> findByComplemento(String complemento);
}
