package br.ufsc.ine5609;

import br.ufsc.ine5609.estruturas.ListaEncadeada;

public class Diretorio {
    private String nome;
    private ListaEncadeada listaAlunos;

    public Diretorio(String nome) {
        this.nome = nome;
        alunos = new ListaEncadeada();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ListaEncadeada getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ListaEncadeada alunos) {
        this.listaAlunos = alunos;
    }
}
