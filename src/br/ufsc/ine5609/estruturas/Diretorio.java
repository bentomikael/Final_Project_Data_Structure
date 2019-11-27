package br.ufsc.ine5609.estruturas;

import br.ufsc.ine5609.estruturas.ListaEncadeada;

// serao criadas as listas invertidas como diretorios
// usar como atributo nome as constantes definidas na classe constantes
public class Diretorio {
    private final String nome;
    private ListaEncadeada listaAlunos;

    public Diretorio(String nome) {
        this.nome = nome;
        alunos = new ListaEncadeada();
    }

    public String getNome() {
        return nome;
    }

    public ListaEncadeada getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ListaEncadeada alunos) {
        this.listaAlunos = alunos;
    }
}
