package br.ufsc.ine5609;

import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.ListaEncadeada;

public class ControleBuscas {
    private static Aluno[] todosAlunos;
    private static Diretorio[] diretorios;

    public ControleBuscas() {
        todosAlunos = new Aluno[99];  // sera array hash
        diretorios = new Diretorio[99];
    }

    /*
     * Procura aluno pelo nome ou pela matricula
     */
    public static Aluno pesquisaAluno(String entrada){

        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
            return buscaMatricula(entrada);
        else
            return buscaNome(entrada);

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

    //retorna aluno pela sua matricula
    private static Aluno buscaMatricula(String entrada){
        for (Aluno aluno:todosAlunos) {
            if(aluno.getMatricula().equals(entrada))
                return aluno;
        }
        return null;
    }

    //retorna aluno pelo seu nome
    private static Aluno buscaNome(String entrada){
        for (Aluno aluno:todosAlunos) {
            if(aluno.getNome().equals(entrada))
                return aluno;
        }
        return null;
    }

    //pega os dados dos alunos e monta as linhas da tabela
    public static String[][] converteAlunosParaLista(Aluno[] alunos){
        String[][] listaAlunos = new String[alunos.length][];
        for(int i = 0;i < alunos.length;i++){
            listaAlunos[i][0] = alunos[i].getMatricula();
            listaAlunos[i][1] = alunos[i].getNome();
            listaAlunos[i][2] = alunos[i].getIdade();
            listaAlunos[i][3] = alunos[i].getCentro();
        }
        return listaAlunos;
    }

}
