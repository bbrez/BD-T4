package com.blv.trabbd4;

import com.blv.trabbd4.model.*;
import com.blv.trabbd4.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TrabalhoBd4Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TrabalhoBd4Application.class);

    @Autowired EstadoRepository repositoryEstado;

    @Autowired
    private EmailRepository repositoryEmail;

    @Autowired
    private CidadeRepository repositoryCidade;

    @Autowired
    private ParcelaRepository parcelaRepository;

    @Autowired
    private FaturaRepository faturaRepository;

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoBd4Application.class, args);
    }

    @Override
    public void run(String... args){
        log.info("Start Application...\n");

        List<Parcela> parcelas = new ArrayList<>();
        parcelas.add(new Parcela(10, new Date(),  EstadoPagamento.Paga));
        parcelas.add(new Parcela(11, new Date(),  EstadoPagamento.Cancelada));
        parcelas.add(new Parcela(12, new Date(),  EstadoPagamento.Pendente));
        parcelas.add(new Parcela(13, new Date(),  EstadoPagamento.Paga));

        faturaRepository.save(new Fatura(new Date(), 4, "pendente", parcelas));
        parcelas.forEach(k -> k.setPagamento(new Date()));
        parcelaRepository.saveAll(parcelas);

        parcelaRepository.findAll().forEach(System.out::println);
        try {
            parcelaRepository.findByPagamento(new SimpleDateFormat("yyy-MM-dd").parse("2021-15-03")).forEach(System.out::println);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        faturaRepository.findAll().forEach(System.out::println);
/*
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

 */
    }
}
