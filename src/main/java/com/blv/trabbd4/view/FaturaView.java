package com.blv.trabbd4.view;

import com.blv.trabbd4.model.Estado;
import com.blv.trabbd4.model.EstadoPagamento;
import com.blv.trabbd4.model.Fatura;
import com.blv.trabbd4.model.Parcela;
import com.blv.trabbd4.repository.ClienteRepository;
import com.blv.trabbd4.repository.FaturaRepository;
import com.blv.trabbd4.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FaturaView {
    @Autowired
    FaturaRepository repoFatura;

    @Autowired
    ParcelaRepository repoParcela;

    @Autowired
    ClienteRepository repoCliente;


    private boolean running;

    public FaturaView() throws ParseException {

        this.running = true;

        Scanner s = new Scanner(System.in);
        while (this.running) {
            int selected = s.nextInt();
            switch(selected){
                case 1: //Cadastra Fatura
                    Fatura f = new Fatura();

                    System.out.println("Data de Emissão: ");
                    String str = s.nextLine();
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = formatter.parse(str);

                    f.setEmissao(date);

                    System.out.println("Numero de parcelas: ");
                    f.setNumeroParcelas(s.nextInt());

                    System.out.println("Valor total da fatura: ");
                    f.setValorTotal(s.nextInt());

                    for(int i = 0; i < f.getNumeroParcelas(); ++i){

                        System.out.println("Parcela numero " + i);
                        System.out.println("Valor da parcela: ");
                        Double v = s.nextDouble();

                        System.out.println("Data de vencimento: ");
                        str = s.nextLine();
                        date = formatter.parse(str);

                        Parcela p = new Parcela(v, date, EstadoPagamento.Pendente);

                        f.getParcelas().add(p);
                    }

                    int soma = 0;

                    for(Parcela p:f.getParcelas()){
                        if(p.getSituacao() == EstadoPagamento.Pendente){
                            soma += p.getValorParcela();
                        }
                    }

                    f.setSaldoPagar(soma);

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

                case 4: //Altera situaçao

                    System.out.println("Entre com o id da parcela: ");
                    Optional<Parcela> par = repoParcela.findById(s.nextLong());

                    int x;
                    System.out.println("Entre com 1 para pagar a parcela ou com 0 para cancelar a parcela");
                    x = s.nextInt();

                    if(x == 1){
                        par.get().setSituacao(EstadoPagamento.Paga);
                        System.out.println("Entre com a data do pagamento: ");
                        str = s.nextLine();
                        formatter = new SimpleDateFormat("dd/MM/yyyy");
                        date = formatter.parse(str);
                        par.get().setPagamento(date);
                    }

                    if(x == 0){
                        par.get().setSituacao(EstadoPagamento.Cancelada);
                    }

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
            }
        }
    }

}
