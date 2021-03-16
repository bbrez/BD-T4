package com.blv.trabbd4.view;

import com.blv.trabbd4.model.*;
import com.blv.trabbd4.repository.ClienteRepository;
import com.blv.trabbd4.repository.FaturaRepository;
import com.blv.trabbd4.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FaturaView {
    @Autowired
    FaturaRepository repoFatura;

    @Autowired
    ParcelaRepository repoParcela;

    @Autowired
    ClienteRepository repoCliente;


    private boolean running;

    public void viewMenu() throws ParseException {

        this.running = true;

        Scanner s = new Scanner(System.in);
        while (this.running) {
            System.out.println("Digite 1 para cadastrar uma fatura");
            System.out.println("Digite 2 para mostrar todas as faturas");
            System.out.println("Digite 3 para mostrar todas as parcelas de uma fatura");
            System.out.println("Digite 4 Altera a situacao da parcela");
            System.out.println("Digite 5 imprime fatura nao pagas");
            System.out.println("Digite 6 imprime parcelas pagas em uma determinada data");
            int selected = s.nextInt();
            switch(selected){
                case 1: //Cadastra Fatura
                    Fatura f = new Fatura();

                    System.out.println("Data de Emissão: ");
                    s.nextLine();
                    String str = s.nextLine();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = formatter.parse(str);

                    f.setEmissao(date);

                    System.out.println("Numero de parcelas: ");
                    f.setNumeroParcelas(s.nextInt());

                    System.out.println("Valor total da fatura: ");
                    f.setValorTotal(s.nextDouble());

                    for(int i = 0; i < f.getNumeroParcelas(); ++i){

                        System.out.println("Parcela numero " + (i+1));
                        System.out.println("Valor da parcela: ");
                        Double v = s.nextDouble();

                        System.out.println("Data de vencimento: ");
                        s.nextLine();
                        str = s.nextLine();
                        date = formatter.parse(str);

                        Parcela p = new Parcela(v, date, EstadoPagamento.Pendente);
                        if(f.getParcelas() == null){
                            f.setParcelas(new LinkedList<>());
                        }
                        f.getParcelas().add(p);
                        repoFatura.save(f);
                        p.setFatura(f);
                        repoParcela.save(p);
                    }

                    int soma = 0;

                    for(Parcela p:f.getParcelas()){
                        if(p.getSituacao() == EstadoPagamento.Pendente){
                            soma += p.getValorParcela();
                        }
                    }

                    System.out.println("Entre com o cpf do cliente que recebera a fatura");
                    Cliente cl = repoCliente.findByCpf(s.nextLine());

                    f.setCliente(cl);

                    f.setSaldoPagar(soma);
                    System.out.println(f);
                    repoFatura.save(f);

                    break;
                case 2: //Mostra todas as faturas
                    for(Fatura fat:repoFatura.findAll()){
                        System.out.println(fat);
                    }

                    break;
                case 3: //Mostra todas as parcelas de uma fatura

                    System.out.println("Entre com o id da fatura que deseja ver as parcelas: ");
                    Optional<Fatura> fat = repoFatura.findById(s.nextLong());

                    for(Parcela par: fat.get().getParcelas()){
                        System.out.println(par);
                    }

                    break;

                case 4: //Altera situaçao

                    System.out.println("Entre com o id da parcela: ");
                    Optional<Parcela> par = repoParcela.findById(s.nextLong());

                    int x;
                    System.out.println("Entre com 1 para pagar a parcela ou com 0 para cancelar a parcela");
                    x = s.nextInt();

                    if(x == 1){
                        par.get().setSituacao(EstadoPagamento.Paga);
                        System.out.println("Entre com a data do pagamento: ");
                        s.nextLine();
                        str = s.nextLine();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        date = formatter.parse(str);
                        par.get().setPagamento(date);
                        par.get().setSituacao(EstadoPagamento.Paga);

                    }

                    if(x == 0){
                        par.get().setSituacao(EstadoPagamento.Cancelada);
                    }

                    repoParcela.save(par.get());


                    fat = Optional.of(par.get().getFatura());

                    fat.get().setSaldoPagar((fat.get().getSaldoPagar() - par.get().getValorParcela()));

                    break;

                case 5: //Imprime faturas que ainda nao foram pagas

                    Iterable<Fatura> lfat = repoFatura.findAll();
                    for(Fatura f1: lfat){
                        boolean verifica = false;
                        for(Parcela p1: f1.getParcelas()){
                            if (p1.getSituacao() == EstadoPagamento.Pendente) {
                                verifica = true;
                                break;
                            }
                        }
                        if(verifica){
                            System.out.println(f1);
                        }
                    }

                    break;

                case 6: //Imprime as datas que foram pagas em determinado dia

                    System.out.println("Entre com o dia de pagamento das parcelas: ");
                    s.nextLine();
                    str = s.nextLine();
                    formatter = new SimpleDateFormat("dd/MM/yyyy");
                    date = formatter.parse(str);
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    c.add(Calendar.DAY_OF_MONTH, 1);
                    for(Parcela parc: repoParcela.findByPagamentoBetween(date, c)){
                        System.out.println(parc);
                    }

                    break;
                default:
                    this.running = false;
                    break;
            }
        }

    }

    public FaturaView(){
    }

}
