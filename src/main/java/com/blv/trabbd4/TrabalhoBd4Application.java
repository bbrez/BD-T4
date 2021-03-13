package com.blv.trabbd4;

import com.blv.trabbd4.model.Estado;
import com.blv.trabbd4.repository.EstadoRepository;
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
    private EstadoRepository repositoryEstado;

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoBd4Application.class, args);
    }

    @Override
    public void run(String... args){
        log.info("Start Application...\n");

        repositoryEstado.save(new Estado("PR"));
        repositoryEstado.save(new Estado("SC"));
        repositoryEstado.save(new Estado("RS"));

        System.out.println("findAll()");
        repositoryEstado.findAll().forEach(System.out::println);

        System.out.println("findById(1L)");
        repositoryEstado.findById(1l).ifPresent(System.out::println);

        System.out.println("findByUF('PR')");
        repositoryEstado.findByUF("PR").forEach(System.out::println);
    }
}
