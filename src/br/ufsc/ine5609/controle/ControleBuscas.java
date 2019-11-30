package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.Constantes;
import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.Hash;
import br.ufsc.ine5609.estruturas.ListaEncadeada;


public class ControleBuscas {
    private static final ControleBuscas INSTANCE = new ControleBuscas();
//    private Aluno[] listaAlunos;
    private Diretorio[] diretorios;


    private ControleBuscas() {
        diretorios = new Diretorio[Constantes.QTD_DIRETORIOS];
        //testes
//        listaAlunos = new  Aluno[]{
//                new Aluno("0001", "José","CTC", Constantes.SISTEMAS, Constantes.SIM),
//                new Aluno("0002", "João","CCJ", Constantes.SISTEMAS, Constantes.NAO),
//                new Aluno("0003", "Maria","CFH", Constantes.COMPUTACAO, Constantes.SIM)
//        };
    }
    public static ControleBuscas getInstance(){
        return INSTANCE;
    }

//    public Aluno[] getListaAlunos(){
//        return listaAlunos;
//    }

    /*
     * Procura aluno pelo nome ou pela matricula
     */
//    public Aluno[] pesquisaAluno(String entrada){
//
//        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
//            return buscaMatricula(entrada);
//        else
//            return buscaNome(entrada);
//    }

    //retorna lista de alunos que pertence aos grupos
    public Aluno[] pesquisaGrupos(String[] opcoes, Diretorio[] diretorios){

        String centro = opcoes[0]; // NENHUM, CTC, CCS, CCE
        String curso = opcoes[1]; //  NENHUM, SISTEMAS, COMPUTACAO, ENGENHARIA
        String cotas = opcoes[2]; //  NENHUM, SIM, NAO

        Diretorio diretorioCentro = defineDiretorioCentro(centro, diretorios); // PODEM SER NULOS
        Diretorio diretorioCurso = defineDiretorioCurso(curso, diretorios);
        Diretorio diretorioCotas = defineDiretorioCota(cotas, diretorios);

        if (diretorioCentro != null && diretorioCurso != null && diretorioCotas != null) {
            //pesquisa em centro+curso+cotas
        } else if (diretorioCentro != null && diretorioCurso != null) {
            //pesquisa em centro+curso
        } else if (diretorioCentro != null && diretorioCotas != null) {
            //pesquisa em centro+cotas
        } else if (diretorioCurso != null && diretorioCotas != null) {
            //pesquisa em curso+cotas
        } else if (diretorioCentro != null) {
            //pesquisa so em  centro
            return diretorioCentro.getListaAlunos().getTodosAlunos();
        } else if (diretorioCurso != null) {
            //pesquisa so em curso
            return diretorioCurso.getListaAlunos().getTodosAlunos();
        } else if (diretorioCotas != null) {
            //pesquisa so em cotas
            return diretorioCotas.getListaAlunos().getTodosAlunos();
        }


//        Aluno[] alunosDesteCentro = null;
//        if (diretorioCentro != null) { // foi escolhido um centro
//            if (!diretorioCentro.getListaAlunos().estaVazio()) { // verifica se tem alunos nesse dir
//                alunosDesteCentro = diretorioCentro.getListaAlunos().getTodosAlunos();
//            }
//        }
//
//        Aluno[] alunosDesteCurso = null;
//        if (diretorioCurso != null) { // foi escolhido um curso
//            if (!diretorioCurso.getListaAlunos().estaVazio()) { // verifica se tem alunos nesse dir
//                alunosDesteCurso = diretorioCurso.getListaAlunos().getTodosAlunos();
//            }
//        }
//
//        Aluno[] alunosDestaCota = null;
//        if (diretorioCotas != null) { // foi escolhido uma cota
//            if (!diretorioCotas.getListaAlunos().estaVazio()) { // verifica se tem alunos nesse dir
//                alunosDestaCota = diretorioCotas.getListaAlunos().getTodosAlunos();
//            }
//        }
//
//        if ( alunosDesteCentro == null && alunosDesteCurso == null && alunosDestaCota == null) { // nao foi escolhido nenhuma opcao
//            //TESTE
//            System.out.println("nenhum diretorio escolhido");
//            return null;
//        } else {
//
//        }

        return null;
    }

        private Aluno[] diretorioParaArray(Diretorio diretorio) {
            return diretorio.getListaAlunos().getTodosAlunos();
        }

        //pega o diretorio com o nome de 'primeiro' e pega diretorio com 'segundo'
        //retorna os alunos que estejam em ambos diretorios
        // exeto se o segundo for ' - '
        // ai retorna so os do primeiro


    private Diretorio defineDiretorioCentro(String centro, Diretorio[] diretorios) {
        if (centro == diretorios[0].getNome()) { //CTC
            return diretorios[0];
        } else if (centro == diretorios[1].getNome()) { //CCS
            return diretorios[1];
        } else if (centro == diretorios[2].getNome()) { //CCE
            return diretorios[2];
        }
        return null;
    }

    /**
     * Metodo para definer o diretorio curso correto para o aluno
     * @return diretorio correto
     */
    private Diretorio defineDiretorioCurso(String curso, Diretorio[] diretorios) {
        if (curso == diretorios[3].getNome()) { //SISTEMAS
            return diretorios[3];
        } else if (curso == diretorios[4].getNome()) { //COMPUTACAO
            return diretorios[4];
        } else if (curso == diretorios[5].getNome()) { //ENGENHARIA
            return diretorios[5];
        }
        return null;
    }

    /**
     * Metodo para definer o diretorio cota correto para o aluno
     * @return diretorio correto
     */
    private Diretorio defineDiretorioCota(String cotas, Diretorio[] diretorios) {
        if (cotas == diretorios[6].getNome()) { //SIM
            return diretorios[6];
        } else if (cotas == diretorios[7].getNome()) { //NAO
            return diretorios[7];
        }
        return null;
    }











    /**
     * Metodo para retornar um aluno buscando pela matricula na lista principal
     * @return aluno encontrado
     */
    public Aluno encontraAlunoPelaMatricula(String matricula, Hash listaPrincipal) {
        return listaPrincipal.encontrarPorChave(matricula);
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
//    private Aluno[] buscaMatricula(String entrada){
//        for (Aluno a:listaAlunos) {
//            if(a.getMatricula().equals(entrada)){
//                return new Aluno[]{a};
//            }
//        }
//        return null;
//    }

    //retorna aluno pelo seu nome
//    private Aluno[] buscaNome(String entrada){
//        for (Aluno a:listaAlunos) {
//            if(a.getNome().equals(entrada)){
//                return new Aluno[]{a};
//            }
//        }
//        return null;
//    }



}
