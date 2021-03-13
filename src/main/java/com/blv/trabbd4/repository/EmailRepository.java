package com.blv.trabbd4.repository;

import com.blv.trabbd4.model.Email;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmailRepository extends CrudRepository<Email, Long>  {
    List<Email> findByEmail(String email);
}
