package com.blv.trabbd4;

import com.blv.trabbd4.model.Cidade;
import com.blv.trabbd4.model.Estado;
import com.blv.trabbd4.repository.CidadeRepository;
import com.blv.trabbd4.repository.EmailRepository;
import com.blv.trabbd4.repository.EstadoRepository;
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

    @Autowired EstadoRepository repositoryEstado;

    @Autowired
    private EmailRepository repositoryEmail;

    @Autowired
    private CidadeRepository repositoryCidade;


    public static void main(String[] args) {
        SpringApplication.run(TrabalhoBd4Application.class, args);
    }

    @Override
    public void run(String... args){
        log.info("Start Application...\n");

        Estado pr = new Estado("PR");
        repositoryEstado.save(pr);

        repositoryCidade.save(new Cidade("Foz do Iguaçu", pr));
        repositoryCidade.save(new Cidade("Cianorte", pr));

        Estado sc = new Estado("SC");
        repositoryEstado.save(sc);

        repositoryCidade.save(new Cidade("Blumenau", sc));
        repositoryCidade.save(new Cidade("Joinville", sc));

        Estado rs = new Estado("RS");
        repositoryEstado.save(rs);

        repositoryCidade.save(new Cidade("Santa Maria", rs));
        repositoryCidade.save(new Cidade("Passo Fundo", rs));

        System.out.println("Estado - findAll()");
        repositoryEstado.findAll().forEach(System.out::println);

        System.out.println("Cidade - findAll()");
        repositoryCidade.findAll().forEach(System.out::println);
    }
}
