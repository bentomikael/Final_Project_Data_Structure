package br.ufsc.ine5609;

import br.ufsc.ine5609.controle.ControladorPrincipal;
import br.ufsc.ine5609.controle.ControleBuscas;
import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.Hash;
import br.ufsc.ine5609.telas.Interface;

public class Main{
    public static void main(String args[]){

        //testes
//        Aluno[] listaAlunos = new Aluno[]{
//                new Aluno("0001", "José renato","CTC", Constantes.SISTEMAS, Constantes.SIM),
//                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
//                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
//        };

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

//        for (Aluno aluno : listaAlunos) { // insercao do array de alunos no hash
//            listaPrincipal.inserir(aluno);
//        }
        //inserido estruturas
        ControladorPrincipal c = new ControladorPrincipal(listaPrincipal, diretorios);
        // carga de dados realizada
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos2, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos3, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos4, listaPrincipal, diretorios);
        c.getControleEntradaSaida().inserirNovoAluno(dadosAlunos5, listaPrincipal, diretorios);

        //teste OK
        System.out.println(c.getDiretorios()[0].getNome()); // DIRETORIO CTC
        System.out.println(c.getDiretorios()[1].getNome()); // DIRETORIO CCS
        System.out.println(c.getDiretorios()[2].getNome()); // DIRETORIO CCE
        System.out.println(c.getDiretorios()[3].getNome()); // DIRETORIO SISTEMAS
        System.out.println(c.getDiretorios()[4].getNome()); // DIRETORIO COMPUTACAO
        System.out.println(c.getDiretorios()[5].getNome()); // DIRETORIO ENGENHARIA
        System.out.println(c.getDiretorios()[6].getNome()); // DIRETORIO SIM
        System.out.println(c.getDiretorios()[7].getNome()); // DIRETORIO NAO

        //tem que printar dois pois foram inseridos 2 alunos no CTC
        System.out.println(c.getDiretorios()[0].getListaAlunos().getNumAlunos());

        //tem que printar henrique pois foi o ultimo do CTC a ser inserido na lista principal
        System.out.println(c.getDiretorios()[0].getListaAlunos().getPrimeiro().getAluno().getNome());

        //tem que printar José renato pois foi o ultimo do CTC a ser inserido na lista principal
        System.out.println(c.getDiretorios()[0].getListaAlunos().getPrimeiro().getProximo().getAluno().getNome());

        // printar 2, pois foram inseridos 2 alunos de Computacao
        System.out.println(c.getDiretorios()[4].getListaAlunos().getNumAlunos());

        // printar 2, pois foram inseridos 2 alunos que nao tem cota
        System.out.println(c.getDiretorios()[7].getListaAlunos().getNumAlunos());
        System.out.println("Fim dos testes");

        c.iniciar();



        //ControleBuscas controleBuscas = ControleBuscas.getInstance();

        //Interface i = new Interface();
        //i.listarAlunos(listaAlunos);

    }
}