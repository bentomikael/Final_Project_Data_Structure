package br.ufsc.ine5609;

public class Controlador {
    private ControleBuscas controleBuscas;

    public Controlador() {
        controleBuscas = ControleBuscas.getInstance();
    }


    public Aluno[] pesquisaAluno(String entrada){
        return controleBuscas.pesquisaAluno(entrada);
    }
    public boolean removeAluno(String entrada){

    }
    public boolean adicionaAlunos(String matricula,String nome, String centro, String curso, String cotista){

    }

    public Aluno[] pesquisaEmDiretorios(String curso,String centro,String cotista){
        return controleBuscas.pesquisaGrupos(curso,centro,cotista);
    }

    private Aluno[] getListaAlunos(){
        return controleBuscas.getListaAlunos();
    }



}
