package com.blv.trabbd4.view;

import java.util.Scanner;

public class MainView {

    public static void MainView(){
        boolean running = true;
        Scanner s = new Scanner(System.in);
        while(running) {
            System.out.println("Digite 1 para visualizar cliente");
            System.out.println("Digite 2 para visualizar fatura");
            System.out.println("Digite 0 para sair");
            int selected = s.nextInt();
            switch (selected) {
                case 1: //Cliente
                    ClienteView cv = new ClienteView();
                    cv.menu();
                    break;
                case 2: //Fatura
                    try{
                        FaturaView fv = new FaturaView();
                    } catch (Exception e) {
                        System.exit(1);
                    }
                    break;
                default: //Sair
                    running = false;
                    break;

            }
        }

    }
}
