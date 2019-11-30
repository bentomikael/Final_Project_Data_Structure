package br.ufsc.ine5609.estruturas;

public class Diretorio {
    private final String nome;
    private ListaEncadeada listaAlunos;

    public Diretorio(String nome) {
        this.nome = nome;
        listaAlunos = new ListaEncadeada();
    }

    public String getNome() {
        return nome;
    }

    public ListaEncadeada getListaAlunos() {
        return listaAlunos;
    }

}
