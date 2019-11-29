package br.ufsc.ine5609;

import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.ListaEncadeada;

/*
    ESTA FECHANDO JANELA PRINCIPAL AO FECHAR JANELA DE RESPOSTAS
    FALTA IMPLEMENTAR BUSCA POR DIRETORIOS
 */

public class ControleBuscas {
    private static final ControleBuscas INSTANCE = new ControleBuscas();
    private Aluno[] listaAlunos;
    private Diretorio[] diretorios;


    private ControleBuscas() {
        diretorios = new Diretorio[Constantes.QTD_DIRETORIOS];
        //testes
        listaAlunos = new  Aluno[]{
                new Aluno("0001", "José","CTC", Constantes.SISTEMAS, Constantes.SIM),
                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
        };
    }
    public static ControleBuscas getInstance(){
        return INSTANCE;
    }

    public Aluno[] getListaAlunos(){
        return listaAlunos;
    }

    /*
     * Procura aluno pelo nome ou pela matricula
     */
    public Aluno[] pesquisaAluno(String entrada){

        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
            return buscaMatricula(entrada);
        else
            return buscaNome(entrada);
    }

    //retorna lista de alunos que pertence aos grupos
    public Aluno[] pesquisaGrupos(String curso, String centro, String cotista){
        //pega o diretorio com o nome de 'primeiro' e pega diretorio com 'segundo'
        //retorna os alunos que estejam em ambos diretorios
        // exeto se o segundo for ' - '
        // ai retorna so os do primeiro
        return null;
    }


    /*-----------------------------------------------privados------------------------------------------- */


    //retorna alunos de um diretorio especifico
    private ListaEncadeada getAlunosDoDiretorio(String diretorioName){
        for (Diretorio d :diretorios) {
            if (d.getNome().equals(diretorioName)){
                return d.getListaAlunos();
            }
        }
        return null;
    }

    //retorna aluno pela sua matricula
    private Aluno[] buscaMatricula(String entrada){
        for (Aluno a:listaAlunos) {
            if(a.getMatricula().equals(entrada)){
                return new Aluno[]{a};
            }
        }
        return null;
    }

    //retorna aluno pelo seu nome
    private Aluno[] buscaNome(String entrada){
        for (Aluno a:listaAlunos) {
            if(a.getNome().equals(entrada)){
                return new Aluno[]{a};
            }
        }
        return null;
    }



}
