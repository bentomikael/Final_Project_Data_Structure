package br.ufsc.ine5609;

import br.ufsc.ine5609.controle.ControladorPrincipal;
import br.ufsc.ine5609.controle.ControleBuscas;
import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.Hash;
import br.ufsc.ine5609.telas.Interface;

public class Main{
    public static void main(String args[]){

        //testes
        Aluno[] listaAlunos = new Aluno[]{
                new Aluno("0001", "José renato","CTC", Constantes.SISTEMAS, Constantes.SIM),
                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
        };

        Diretorio[] diretorios = new Diretorio[Constantes.QTD_DIRETORIOS]; // cria o array de diretorios
        // inicializa cada diretorio
        diretorios[0] = new Diretorio(Constantes.CTC);
        diretorios[1] = new Diretorio(Constantes.CCS);
        diretorios[2] = new Diretorio(Constantes.CCE);
        diretorios[3] = new Diretorio(Constantes.SISTEMAS);
        diretorios[4] = new Diretorio(Constantes.COMPUTACAO);
        diretorios[5] = new Diretorio(Constantes.ENGENHARIA);
        diretorios[6] = new Diretorio(Constantes.SIM);
        diretorios[7] = new Diretorio(Constantes.NAO);

        Hash listaPrincipal = new Hash(1009); // cria a lista principal

        for (Aluno aluno : listaAlunos) { // insercao do array de alunos no hash
            listaPrincipal.inserir(aluno);
        }


        ControladorPrincipal c = new ControladorPrincipal(listaPrincipal, diretorios); // carga de dados realizada

        c.iniciar();

        //ControleBuscas controleBuscas = ControleBuscas.getInstance();

        //Interface i = new Interface();
        //i.listarAlunos(listaAlunos);

    }
}