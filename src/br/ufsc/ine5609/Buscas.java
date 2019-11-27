package br.ufsc.ine5609;

import br.ufsc.ine5609.estruturas.ListaEncadeada;

import java.util.ArrayList;

public class Buscas {
    private static Aluno[] todosAlunos;
    private static Diretorio[] diretorios;

    public Buscas() {
        alunos = new Aluno[99];  // sera array hash
        diretorios = new Diretorio[99];
    }

    /*
     * Procura aluno pelo nome ou pela matricula
     */
    public static Object pesquisaAluno(String entrada){

        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
            return buscaMatricula(entrada) ;
        else
            return buscaNome(entrada) ;

    }
    //retorna lista de alunos que pertence aos grupos
    public static Aluno[] pesquisaGrupos(String primeiro, String segundo){

        return null;
    }


    //retorna alunos de uma diretorio especifico
    private ListaEncadeada getAlunosDoDiretorio(String diretorioName){
            for (Diretorio d :diretorios) {
                if (d.getNome().equals(diretorioName)){
                    return d.getListaAlunos();
                }
            }
            return null;
    }

    private static Aluno buscaMatricula(String entrada){
        for (Aluno aluno:todosAlunos) {
            if(aluno.getMatricula().equals(entrada))
                return aluno;
        }
        return null;
    }

    private static Aluno buscaNome(String entrada){
        for (Aluno aluno:todosAlunos) {
            if(aluno.getNome().equals(entrada))
                return aluno;
        }
        return null;
    }

}
