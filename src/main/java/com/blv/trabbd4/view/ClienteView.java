package com.blv.trabbd4.view;

import com.blv.trabbd4.model.*;
import com.blv.trabbd4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClienteView {
    /*
    private boolean running;

    @Autowired
    ClienteRepository repoCliente;

    @Autowired
    EnderecoEspecificoRepository repoEnderecoEspecifico;

    @Autowired
    EnderecoRepository repoEndereco;

    @Autowired
    CidadeRepository repoCidade;

    @Autowired
    EstadoRepository repoEstado;


    public EnderecoEspecifico getEndereco(){
        EnderecoEspecifico ee = null;

        System.out.println("1 - Novo");
        System.out.println("2 - Existente");
        System.out.print("opc: ");

        Scanner s = new Scanner(System.in);
        int opc = s.nextInt();

        if(opc == 1){
            ee = new EnderecoEspecifico();

            System.out.print("CEP do Endereço: ");
            String cep = s.nextLine();
            Endereco e = repoEndereco.findByCEP(cep);

            if(e == null){
                e = new Endereco();
                System.out.println("CEP não encontrado, criando um novo:");

                System.out.print("Estado (UF):");
                String estado = s.nextLine();
                Estado es = repoEstado.findByUF(estado);
                if(es == null){
                    es = new Estado(estado);
                }

                System.out.print("Cidade:");
                String cidade = s.nextLine();
                Cidade c = repoCidade.findByNome(cidade);
                if(c == null){
                    c = new Cidade(cidade, es);
                    c.getEnderecos().add(e);
                    es.getCidades().add(c);
                }

                e.setCidade(c);
                System.out.print("Logradouro: ");
                e.setLogradouro(s.nextLine());

            }

            System.out.print("Numero: ");
            ee.setNumero(s.nextLong());

            System.out.print("Complemento: ");
            ee.setComplemento(s.nextLine());

            ee.setEndereco(e);
            e.getEnderecoEspecificos().add(ee);

        } else if(opc == 2){
            System.out.print("CEP: ");
            String cep = s.nextLine();
            System.out.print("Numero: ");
            Long numero = s.nextLong();
            repoEnderecoEspecifico.findByNumeroAndEndereco_CEP(numero, cep);
        }

        return ee;
    }

    public ClienteView() {
        this.running = true;

        Scanner s = new Scanner(System.in);
        while (this.running) {
            int selected = s.nextInt();
            switch (selected) {
                case 1: //Cadastra Cliente
                    Cliente c = new Cliente();

                    System.out.print("Nome: ");
                    c.setNome(s.nextLine());

                    System.out.print("Sobrenome: ");
                    c.setSobrenome(s.nextLine());

                    System.out.print("CPF: ");
                    c.setCpf(s.nextLine());

                    System.out.print("Quantidade de telefones: ");

                    int num_tel = s.nextInt();
                    List<Telefone> telefoneList = new LinkedList<>();

                    for(int i = 0 ; i<num_tel ; ++i){
                        System.out.print("Numero de telefone (" + i + "): ");
                        Telefone t = new Telefone(s.nextLine());
                        t.setCliente(c);
                        telefoneList.add(t);
                    }

                    c.setTelefones(telefoneList);

                    System.out.print("Quantiade de E-mails: ");

                    int num_email = s.nextInt();
                    List<Email> emailList = new LinkedList<>();

                    for(int i = 0 ; i<num_tel ; ++i){
                        System.out.print("Endereço de email (" + i + "): ");
                        Email e = new Email();
                        e.setCliente(c);
                        emailList.add(e);
                    }

                    c.setEmails(emailList);

                    System.out.println("Endereço Residencial");
                    c.setEnderecoResidencial(getEndereco());
                    System.out.println("Endereço Comercial?");
                    System.out.println("1 - Sim / 2 - Não");
                    if(s.nextInt() == 1){
                        c.setEnderecoComercial(getEndereco());
                    }

                    break;
                case 2: //Procura Cliente CPF
                    System.out.print("CPF: ");
                    String cpf = s.nextLine();

                    System.out.println(repoCliente.findByCpf(cpf));
                    break;

                case 3: //Procura Cliente Nome
                    System.out.print("Nome: ");
                    String nome = s.nextLine();

                    System.out.print("Sobrenome: ");
                    String sobrenome = s.nextLine();

                    System.out.println(repoCliente.findByNomeAndSobrenome(nome, sobrenome));
                    break;


                case 0:
                    this.running = false;
                    break;

            }
        }

    }
    */
}
