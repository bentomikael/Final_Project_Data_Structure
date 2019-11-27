package br.ufsc.ine5609;

import br.ufsc.ine5609.telas.MainFrame;


public class Main{
    public static void main(String args[]){

        //testes
        Aluno[] listaAlunos = new Aluno[]{
                new Aluno("1919", "José", "22", "CTC"),
                new Aluno("1111", "João", "33", "CCJ"),
                new Aluno("0150", "Maria", "19", "CFH")
        };
        String[][] lista = ControleBuscas.converteAlunosParaLista(listaAlunos);

        MainFrame m = new MainFrame(lista);




    }
}