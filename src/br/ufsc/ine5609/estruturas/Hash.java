package br.ufsc.ine5609.estruturas;

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

    public ListaEncadeada[] getTabelaEspalhamento() {
        return this.tabelaEspalhamento;
    }
    
    public void inserir(Aluno aluno) {
        int grupo = funcaoHash(Integer.parseInt(aluno.getMatricula()));
        
        if (this.getTabelaEspalhamento()[grupo] == null) {
            this.getTabelaEspalhamento()[grupo] = new ListaEncadeada();
        }
        this.getTabelaEspalhamento()[grupo].insiraPrimeiro(aluno);
    }
    
    public void remover(Aluno aluno) {
        int chave = Integer.parseInt(aluno.getMatricula());
        ListaEncadeada cursorTabela = this.getTabelaEspalhamento()[funcaoHash(chave)];
        cursorTabela.remova(aluno);
        if (cursorTabela.estaVazio()) {
            this.getTabelaEspalhamento()[funcaoHash(chave)] = null;
        }
    }
    
    public ListaEncadeada getListaDeAluno(int chave) {
        return this.getTabelaEspalhamento()[funcaoHash(chave)];
    }
    
}