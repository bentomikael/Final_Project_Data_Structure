package br.ufsc.ine5609;

import java.util.ArrayList;

public class Buscas {
    private ArrayList alunos;

    /*
     * Procura aluno pelo nome ou pela matricula
     */
    public static Object pesquisaAluno(String entrada){

        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
            return buscaMatricula(entrada) ;
        else
            return buscaNome(entrada) ;

    }
    public static Object pesquisaGrupos(String primeiro, String segundo){
        return null;
    }

    //retornara aluno
    private static Object buscaMatricula(String entrada){
        /*for (Object aluno:alunos) {
            if(aluno.getMatricula() == entrada)
                return aluno;
        }*/
        return null;
    }
    private static Object buscaNome(String entrada){
        /*for (Object aluno:alunos) {
            if(aluno.getNome() == entrada)
                return aluno;
        }*/
        return null;
    }

}
