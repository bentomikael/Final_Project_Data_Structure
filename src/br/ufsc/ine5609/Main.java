package br.ufsc.ine5609;

import br.ufsc.ine5609.controle.ControladorPrincipal;
import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.Hash;

public class Main{
    public static void main(String args[]){

        Object[] dadosAlunos = new Object[] {
                "José renato", Constantes.CTC, Constantes.SISTEMAS, Constantes.SIM
        };
        Object[] dadosAlunos2 = new Object[] {
                "Pedro", Constantes.CCE, Constantes.COMPUTACAO, Constantes.NAO
        };
        Object[] dadosAlunos3 = new Object[] {
                "Carlos", Constantes.CCS, Constantes.ENGENHARIA, Constantes.SIM
        };
        Object[] dadosAlunos4 = new Object[] {
                "Henrique", Constantes.CTC, Constantes.SISTEMAS, Constantes.NAO
        };
        Object[] dadosAlunos5 = new Object[] {
                "Fernando", Constantes.CCE, Constantes.COMPUTACAO, Constantes.SIM
        };
        Object[] dadosAlunos6 = new Object[] {
                "Mario", Constantes.CTC, Constantes.COMPUTACAO, Constantes.NAO
        };
        Object[] dadosAlunos7 = new Object[] {
                "Ronaldo", Constantes.CCE, Constantes.SISTEMAS, Constantes.SIM
        };
        Object[] dadosAlunos8 = new Object[] {
                "Antonio", Constantes.CTC, Constantes.COMPUTACAO, Constantes.SIM
        };
        Object[] dadosAlunos9 = new Object[] {
                "Maria", Constantes.CCS, Constantes.SISTEMAS, Constantes.NAO
        };
        Object[] dadosAlunos10 = new Object[] {
                "Joana", Constantes.CCE, Constantes.ENGENHARIA, Constantes.SIM
        };
        Object[] dadosAlunos11 = new Object[] {
                "Vera", Constantes.CCE, Constantes.ENGENHARIA, Constantes.SIM
        };
        Object[] dadosAlunos12 = new Object[] {
                "Lucia", Constantes.CCE, Constantes.COMPUTACAO, Constantes.SIM
        };
        Object[] dadosAlunos13 = new Object[] {
                "Renata", Constantes.CCE, Constantes.ENGENHARIA, Constantes.SIM
        };
        Object[] dadosAlunos14 = new Object[] {
                "Kelly", Constantes.CCE, Constantes.SISTEMAS, Constantes.SIM
        };
        Object[] dadosAlunos15 = new Object[] {
                "Karina", Constantes.CCE, Constantes.ENGENHARIA, Constantes.SIM
        };

        Diretorio[] diretorios = new Diretorio[Constantes.QTD_DIRETORIOS];

        diretorios[0] = new Diretorio(Constantes.CTC);
        diretorios[1] = new Diretorio(Constantes.CCS);
        diretorios[2] = new Diretorio(Constantes.CCE);
        diretorios[3] = new Diretorio(Constantes.SISTEMAS);
        diretorios[4] = new Diretorio(Constantes.COMPUTACAO);
        diretorios[5] = new Diretorio(Constantes.ENGENHARIA);
        diretorios[6] = new Diretorio(Constantes.SIM);
        diretorios[7] = new Diretorio(Constantes.NAO);

        Hash listaPrincipal = new Hash(1009);
        ControladorPrincipal c = new ControladorPrincipal(listaPrincipal, diretorios);

        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos2, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos3, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos4, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos5, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos6, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos7, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos8, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos9, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos10, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos11, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos12, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos13, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos14, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos15, listaPrincipal, diretorios);
        System.out.println("Fim dos testes");

        c.iniciar();
    }
}