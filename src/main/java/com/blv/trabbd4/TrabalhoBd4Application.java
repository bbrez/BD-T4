package com.blv.trabbd4;

import com.blv.trabbd4.model.Email;
import com.blv.trabbd4.model.Estado;
import com.blv.trabbd4.model.Telefone;
import com.blv.trabbd4.repository.EmailRepository;
import com.blv.trabbd4.repository.EstadoRepository;
import com.blv.trabbd4.repository.TelefoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabalhoBd4Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TrabalhoBd4Application.class);

    @Autowired
    private EmailRepository repositoryEmail;

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoBd4Application.class, args);
    }

    @Override
    public void run(String... args){
        log.info("Start Application...\n");

        repositoryEmail.save(new Email("leonardobfritas@gmail.com"));
        repositoryEmail.save(new Email("bbrez@gmail.com"));
        repositoryEmail.save(new Email("victorhugomt@hotmail.com"));

        System.out.println("findAll()");
        repositoryEmail.findAll().forEach(System.out::println);

        System.out.println("findById(1L)");
        repositoryEmail.findById(1l).ifPresent(System.out::println);

        System.out.println("findByTelefone('99819-8420')");
        repositoryEmail.findByEmail("bbrez@gmail.com").forEach(System.out::println);
    }
}
