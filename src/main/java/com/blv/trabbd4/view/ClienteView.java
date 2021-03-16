package com.blv.trabbd4.view;

import com.blv.trabbd4.model.*;
import com.blv.trabbd4.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;//

@Controller
public class ClienteView {
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

    @Autowired
    ParcelaRepository parcelaRepository;


    public EnderecoEspecifico getEndereco() {
        EnderecoEspecifico ee = null;

        System.out.println("1 - Novo");
        System.out.println("2 - Existente");
        System.out.print("opc: ");

        Scanner s = new Scanner(System.in);
        int opc = s.nextInt();

        if (opc == 1) {
            ee = new EnderecoEspecifico();

            System.out.print("CEP do Endereço: ");
            String cep = s.nextLine();
            Endereco e = repoEndereco.findByCEP(cep);

            if (e == null) {
                e = new Endereco();
                System.out.println("CEP não encontrado, criando um novo:");

                System.out.print("Estado (UF):");
                String estado = s.nextLine();
                Estado es = repoEstado.findByUF(estado);
                if (es == null) {
                    es = new Estado(estado);
                }

                System.out.print("Cidade:");
                String cidade = s.nextLine();
                Cidade c = repoCidade.findByNome(cidade);
                if (c == null) {
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

        } else if (opc == 2) {
            System.out.print("CEP: ");
            String cep = s.nextLine();
            System.out.print("Numero: ");
            Long numero = s.nextLong();
            repoEnderecoEspecifico.findByNumeroAndEndereco_CEP(numero, cep);
        }

        return ee;
    }

    public void menu() {
        this.running = true;

        Scanner s = new Scanner(System.in);

        while (this.running) {
            System.out.println("Digite 1 para cadastrar um  cliente");
            System.out.println("Digite 2 para pesquisar por CPF");
            System.out.println("Digite 3 para pesquisar por nome");
            System.out.println("Digite 4 para imprimir as faturas de um cliente");
            System.out.println("Digite 5 para imprimer o nome e o saldo a pagar");
            int selected = s.nextInt();
            switch (selected) {
                case 1: //Cadastra Cliente        System.out.println("Digite 1 para cadastrar um  cliente");

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

                    for (int i = 0; i < num_tel; ++i) {
                        System.out.print("Numero de telefone (" + i + "): ");
                        Telefone t = new Telefone(s.nextLine());
                        t.setCliente(c);
                        telefoneList.add(t);
                    }

                    c.setTelefones(telefoneList);

                    System.out.print("Quantiade de E-mails: ");

                    int num_email = s.nextInt();
                    List<Email> emailList = new LinkedList<>();

                    for (int i = 0; i < num_tel; ++i) {
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
                    if (s.nextInt() == 1) {
                        c.setEnderecoComercial(getEndereco());
                    }

                    repoCliente.save(c);

                    break;
                case 2: //Procura Cliente CPF
                    System.out.print("CPF: ");
                    s.nextLine();
                    String cpf = s.nextLine();

                    System.out.println(repoCliente.findByCpf(cpf));
                    break;

                case 3: //Procura Cliente Nome
                    System.out.print("Nome: ");
                    s.nextLine();
                    String nome = s.nextLine();

                    System.out.print("Sobrenome: ");
                    String sobrenome = s.nextLine();

                    System.out.println(repoCliente.findByNomeAndSobrenome(nome, sobrenome));
                    break;

                case 4:
                    System.out.println("Deseja procurar por CPF ou pelo nome?");
                    System.out.println("1 para procurar pelo CPF");
                    System.out.println("2 para procurar pelo nome");

                    int k = s.nextInt();

                    if (k == 1) {
                        System.out.println("CPF: ");
                        s.nextLine();
                        cpf = s.nextLine();

                        c = repoCliente.findByCpf(cpf);

                        System.out.println(c);
                        for (Fatura f : c.getFaturas()) {
                            System.out.println(f);
                        }
                    }
                    if (k == 2) {
                        System.out.print("Nome: ");
                        s.nextLine();
                        nome = s.nextLine();

                        System.out.print("Sobrenome: ");
                        sobrenome = s.nextLine();

                        c = repoCliente.findByNomeAndSobrenome(nome, sobrenome);
                        if (c == null) {
                            System.out.println("cliente nao encontrado");
                        } else {
                            System.out.println(c);
                            for (Fatura f : c.getFaturas()) {
                                System.out.println(f);
                            }
                        }
                    }

                case 5:
                    nomeDivida();
                    break;
                default:
                    this.running = false;
                    break;

            }
        }
    }

    private void nomeDivida() {
        repoCliente.findAll().forEach(k -> System.out.println(k.getNome() + " valor total devido: " + k.getFaturas().stream().mapToDouble(a -> parcelaRepository.findByFaturaAndSituacao(a, EstadoPagamento.Pendente).stream().mapToDouble(Parcela::getValorParcela).sum()).sum()));
    }

    public ClienteView() {
    }

}