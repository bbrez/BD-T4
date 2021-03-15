package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    List<Endereco> findByLogradouro(String Logradouro);
    Endereco findByCEP(String CEP);
}
