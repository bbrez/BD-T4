package com.blv.trabbd4.view;

import java.util.Scanner;

public class MainView {
    private boolean running;

    public MainView(){
        this.running = true;

        Scanner s = new Scanner(System.in);
        while(this.running) {
            int selected = s.nextInt();
            switch (selected) {
                case 1: //Cliente
                    ClienteView cv = new ClienteView();
                    break;
                case 2: //Fatura
                    FaturaView fv = new FaturaView();
                    break;
                case 0: //Sair
                    this.running = false;
                    break;

            }
        }

    }
}
