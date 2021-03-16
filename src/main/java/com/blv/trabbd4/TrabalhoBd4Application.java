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

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    EnderecoEspecificoRepository enderecoEspecificoRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    FaturaRepository faturaRepository;

    @Autowired
    ParcelaRepository parcelaRepository;

    @Autowired
    TelefoneRepository telefoneRepository;


    public static void main(String[] args) {
        SpringApplication.run(TrabalhoBd4Application.class, args);
    }

    @Override
    public void run(String... args){
        log.info("Start Application...\n");
        try {
            popula();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        estadoRepository.findAll().forEach(System.out::println);
        cidadeRepository.findAll().forEach(System.out::println);
        enderecoRepository.findAll().forEach(System.out::println);
        enderecoEspecificoRepository.findAll().forEach(System.out::println);
        emailRepository.findAll().forEach(System.out::println);
        telefoneRepository.findAll().forEach(System.out::println);
        clienteRepository.findAll().forEach(System.out::println);
        faturaRepository.findAll().forEach(System.out::println);
        parcelaRepository.findAll().forEach(System.out::println);
    }

    public void popula() throws ParseException {
        Cliente leo = new Cliente("Leonardo", "Benitez de Freitas", "102.440.309-28");
        Cliente bruno = new Cliente("Bruno", "de Castro Brezolin", "103.406.972-25");
        Cliente joao = new Cliente("Joao", "Santos", "253.471.369-71");
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(leo);
        clientes.add(bruno);
        clientes.add(joao);
        clienteRepository.saveAll(clientes);
        Estado PR = new Estado("PR");
        Estado RS = new Estado("RS");
        estadoRepository.save(PR);
        estadoRepository.save(RS);
        Cidade foz = new Cidade("Foz do Iguaçu", PR);
        Cidade santa = new Cidade("Santa Maria", RS);
        cidadeRepository.save(foz);
        cidadeRepository.save(santa);
        Endereco rolon = new Endereco("Rua Gilberto Rolon", "85852-180", foz);
        Endereco vargas = new Endereco("Avenida Presidente Vargas", "25367-120", santa);
        Endereco cataratas = new Endereco("Avenida das Cataratas", "75138-367", foz);
        enderecoRepository.save(rolon);
        enderecoRepository.save(vargas);
        enderecoRepository.save(cataratas);
        EnderecoEspecifico rolo2 = new EnderecoEspecifico(137L, "", rolon);
        EnderecoEspecifico vargas2 = new EnderecoEspecifico(231L, "Apartamento 301", vargas);
        EnderecoEspecifico cataratas2 = new EnderecoEspecifico(8423L, "", cataratas);
        enderecoEspecificoRepository.save(rolo2);
        enderecoEspecificoRepository.save(vargas2);
        enderecoEspecificoRepository.save(cataratas2);
        leo.setEnderecoComercial(rolo2);
        leo.setEnderecoResidencial(vargas2);
        bruno.setEnderecoResidencial(rolo2);
        joao.setEnderecoResidencial(cataratas2);
        emailRepository.save(new Email("leonardobfritas@gmail.com", leo));
        emailRepository.save(new Email("joaosantos@gmail.com", joao));
        emailRepository.save(new Email("bbrez@gmail.com", bruno));
        emailRepository.save(new Email("bruno.brezolin@unioeste.br", bruno));
        telefoneRepository.save(new Telefone("99819-8420", leo));
        telefoneRepository.save(new Telefone("3028-6071", leo));
        telefoneRepository.save(new Telefone("99921-3387", bruno));
        telefoneRepository.save(new Telefone("98803-6071", joao));
        Fatura fatura1 = new Fatura(new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-20"), 3, 600, leo );
        Fatura fatura2 = new Fatura(new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-13"), 1, 1000, bruno);
        Fatura fatura3 = new Fatura(new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-20"), 2, 1100, leo);
        Fatura fatura4 = new Fatura(new SimpleDateFormat("yyyy-MM-dd").parse("2021-03-28"), 1, 700, joao);
        Fatura fatura5 = new Fatura(new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-03"), 2, 900, bruno);
        faturaRepository.save(fatura1);
        faturaRepository.save(fatura2);
        faturaRepository.save(fatura3);
        faturaRepository.save(fatura4);
        faturaRepository.save(fatura5);
        parcelaRepository.save(new Parcela(200, new SimpleDateFormat("dd/MM/yyy").parse("20/04/2021"),"Pendente", fatura1));
        parcelaRepository.save(new Parcela(200, new SimpleDateFormat("dd/MM/yyy").parse("20/05/2021"),"Pendente", fatura1));
        parcelaRepository.save(new Parcela(200, new SimpleDateFormat("dd/MM/yyy").parse("20/06/2021"),"Pendente", fatura1));
        parcelaRepository.save(new Parcela(1000, new SimpleDateFormat("dd/MM/yyy").parse("13/05/2021"), "Pendente", fatura2));
        parcelaRepository.save(new Parcela(550, new SimpleDateFormat("dd/MM/yyy").parse("20/05/2021"), "Pendente", fatura3));
        parcelaRepository.save(new Parcela(550, new SimpleDateFormat("dd/MM/yyy").parse("20/06/2021"), "Pendente", fatura3));
        parcelaRepository.save(new Parcela(700, new SimpleDateFormat("dd/MM/yyy").parse("28/04/2021"), "Pendente", fatura4));
        parcelaRepository.save(new Parcela(450, new SimpleDateFormat("dd/MM/yyy").parse("03/05/2021"), "Pendente", fatura5));
        parcelaRepository.save(new Parcela(450, new SimpleDateFormat("dd/MM/yyy").parse("03/06/2021"), "Pendente", fatura5));
        clienteRepository.saveAll(clientes);
    }
}
