package br.ufsc.ine5609;

import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.ListaEncadeada;
import br.ufsc.ine5609.telas.ResultadoPesquisa;

/*
    ESTA FECHANDO JANELA PRINCIPAL AO FECHAR JANELA DE RESPOSTAS
    FALTA IMPLEMENTAR BUSCA POR DIRETORIOS
 */

public class ControleBuscas {
    private static Aluno[] todosAlunos;
    private static Diretorio[] diretorios;
    private ResultadoPesquisa telaResultado;

    private static final ControleBuscas INSTANCE = new ControleBuscas();

    public static ControleBuscas getInstance(){
        return INSTANCE;
    }

    private ControleBuscas() {

        //TESTE
        todosAlunos = new  Aluno[]{
                new Aluno("0001", "José","CTC", Constantes.SISTEMAS, Constantes.SIM),
                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
        };
        diretorios = new Diretorio[99]; // sera uma lista encadeada
    }

    /*
     * Procura aluno pelo nome ou pela matricula
     */
    public void pesquisaAluno(String entrada){

        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
            buscaMatricula(entrada);
        else
            buscaNome(entrada);
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

    private void exibeResultadoDaBusca(Aluno[] alunos){
        //telaResultado.exibir(converteAlunosParaLista(alunos));
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
    private void buscaMatricula(String entrada){
        Aluno[] aluno;
        for (Aluno a:todosAlunos) {
            if(a.getMatricula().equals(entrada)){
                aluno = new Aluno[]{a};
                exibeResultadoDaBusca(aluno);
                break;
            }
        }
        //se nao encontrar manda um array vazio
        exibeResultadoDaBusca(new Aluno[]{});
    }

    //retorna aluno pelo seu nome
    private void buscaNome(String entrada){
        Aluno[] aluno;
        for (Aluno a:todosAlunos) {
            if(a.getNome().equals(entrada)){
                aluno = new Aluno[]{a};
                exibeResultadoDaBusca(aluno);
                break;
            }
        }
        //se nao encontrar manda um array vazio
        exibeResultadoDaBusca(new Aluno[]{});

    }

    //pega os dados dos alunos e monta as linhas da tabela
    public String[][] converteAlunosParaLista(Aluno[] alunos){
        String[][] listaAlunos = new String[alunos.length][5];

        for(int i = 0;i < alunos.length;i++){
            listaAlunos[i][0] = alunos[i].getMatricula();
            listaAlunos[i][1] = alunos[i].getNome();
            listaAlunos[i][2] = alunos[i].getCentro();
            listaAlunos[i][3] = alunos[i].getCurso();
            listaAlunos[i][4] = alunos[i].getCotas();
        }
        return listaAlunos;
    }

}
