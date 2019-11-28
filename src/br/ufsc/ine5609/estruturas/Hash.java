package br.ufsc.ine5609.estruturas;

import br.ufsc.ine5609.Aluno;

public class Hash {
    private ListaEncadeada[] tabelaEspalhamento;
    int tamanhoTabela;

    public Hash(int tamanhoTabela) {
        this.tabelaEspalhamento = new ListaEncadeada[tamanhoTabela];
        this.tamanhoTabela = tamanhoTabela;
    }

    private int funcaoHash(int chave) {
        return chave % this.tamanhoTabela;
    }

    public void inserir(Aluno aluno) {
        int grupo = funcaoHash(Integer.parseInt(aluno.getMatricula()));
        tabelaEspalhamento[grupo].insiraPrimeiro(aluno);
    }

}