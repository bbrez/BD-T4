package com.blv.trabbd4;

import com.blv.trabbd4.model.*;
import com.blv.trabbd4.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TrabalhoBd4Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TrabalhoBd4Application.class);

    @Autowired
    private EmailRepository repositoryEmail;

    @Autowired
    private ParcelaRepository parcelaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoBd4Application.class, args);
    }

    @Override
    public void run(String... args){
        log.info("Start Application...\n");

        parcelaRepository.save(new Parcela(10.50, new Date(), "paga"));

        parcelaRepository.findAll().forEach(System.out::println);
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
