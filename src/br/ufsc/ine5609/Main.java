package br.ufsc.ine5609;

import br.ufsc.ine5609.telas.MainFrame;

import java.util.ArrayList;

public class Main{
    public static void main(String args[]){

        //testes
        Object[][] teste = new Object[][]{
                {"1919", "José", "22", "CTC"},
                {"1111", "João", "33", "CCJ"},
                {"0150", "Maria", "19", "CFH"}
        };
        MainFrame m = new MainFrame(teste);




    }
}