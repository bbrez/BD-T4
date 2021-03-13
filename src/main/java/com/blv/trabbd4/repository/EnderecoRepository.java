package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Endereco;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    List<Endereco> findByCEP(String CEP);
    List<Endereco> findByLogradouro(String Logradouro);
}
