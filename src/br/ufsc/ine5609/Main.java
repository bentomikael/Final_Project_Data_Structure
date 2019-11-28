package br.ufsc.ine5609;

import br.ufsc.ine5609.telas.MainFrame;

public class Main{
    public static void main(String args[]){

        // fazer os diretorios para centro , curso, cotista e nao cotista
        // ja definidos na classe constantes para serem usados

        //a tela principal vai comandar o programa, mais facil
        //foda-se o mvc

        //testes
        Aluno[] listaAlunos = new Aluno[]{
                new Aluno("0001", "José","CTC", Constantes.SISTEMAS, Constantes.SIM),
                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
        };
        ControleBuscas controleBuscas = ControleBuscas.getInstance();
        String[][] lista = controleBuscas.converteAlunosParaLista(listaAlunos);

        MainFrame m = new MainFrame(lista);




    }
}