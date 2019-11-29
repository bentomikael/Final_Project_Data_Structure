package br.ufsc.ine5609;

import br.ufsc.ine5609.controle.ControleBuscas;
import br.ufsc.ine5609.telas.Interface;

public class Main{
    public static void main(String args[]){

        //testes
        Aluno[] listaAlunos = new Aluno[]{
                new Aluno("0001", "José renato","CTC", Constantes.SISTEMAS, Constantes.SIM),
                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
        };
        ControleBuscas controleBuscas = ControleBuscas.getInstance();

        Interface i = new Interface();
        i.listarAlunos(listaAlunos);

    }
}