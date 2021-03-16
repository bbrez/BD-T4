package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findByNomeAndSobrenome(String nome, String sobrenome);
    Cliente findByCpf(String cpf);
}
