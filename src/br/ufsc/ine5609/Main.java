package br.ufsc.ine5609;

import br.ufsc.ine5609.telas.MainFrame;


public class Main{
    public static void main(String args[]){

        // fazer os diretorios para centro e curso
        // ex centro : CTC , CFH , CCS , CCE
        //ex curso: Administracao, Sistemas, Computacao, Engenharia
        // ja definidos na classe constantes para serem usados

        //testes
        Aluno[] listaAlunos = new Aluno[]{
                new Aluno("1919", "José", "22", "CTC",Constantes.SISTEMAS),
                new Aluno("1111", "João", "33", "CCJ",Constantes.SISTEMAS),
                new Aluno("0150", "Maria", "19", "CFH",Constantes.COMPUTACAO)
        };
        String[][] lista = ControleBuscas.converteAlunosParaLista(listaAlunos);

        MainFrame m = new MainFrame(lista);




    }
}