package br.ufsc.ine5609.estruturas;

import br.ufsc.ine5609.Aluno;

public class Hash {
    private ListaEncadeada[] tabelaEspalhamento;
    int tamanhoTabela, numElementos;

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

    public int getTamanhoTabela() {
        return this.tamanhoTabela;
    }
    
    public int getNumElementos() {
        return this.numElementos;
    }

    public void incrementaNumElementos() {
        this.numElementos++;
    }

    public void decrementaNumElementos() {
        this.numElementos--;
    }
    
    public void inserir(Aluno aluno) {
        int grupo = funcaoHash(Integer.parseInt(aluno.getMatricula()));
        
        if (this.getTabelaEspalhamento()[grupo] == null) {
            this.getTabelaEspalhamento()[grupo] = new ListaEncadeada();
        }
        this.getTabelaEspalhamento()[grupo].insiraPrimeiro(aluno);
        this.incrementaNumElementos(); // verificar funcionamento
    }

    public void remover(Aluno aluno) {
        int chave = Integer.parseInt(aluno.getMatricula());
        ListaEncadeada cursorTabela = this.getTabelaEspalhamento()[funcaoHash(chave)];
        cursorTabela.remova(aluno);
        if (cursorTabela.estaVazio()) {
            this.getTabelaEspalhamento()[funcaoHash(chave)] = null;
        }
        this.decrementaNumElementos();

    }

    public Aluno encontrarPorChave(String chave) {
        int grupo = Integer.parseInt(chave); // posicao na tabelaEspalhamento que o aluno esta
        if (funcaoHash(grupo) <= this.getTamanhoTabela()) { // verifica se eh posicao valida
            ListaEncadeada cursorTabela = this.getTabelaEspalhamento()[funcaoHash(grupo)];
            if (cursorTabela != null) { // verifica se tem algo na posicao
                return cursorTabela.getPrimeiro().getAluno();
            }
        }
        return null;
    }

    public ListaEncadeada getListaDeAluno(int chave) {
        return this.getTabelaEspalhamento()[funcaoHash(chave)];
    }

    public Aluno[] getArrayAlunos() {
        Aluno[] todosAlunos = new Aluno[this.getNumElementos()];
        int j = 0;
        for (int i = 0; i < this.getTamanhoTabela(); i++) {
            ListaEncadeada cursorTabela = this.getTabelaEspalhamento()[i];
            if(cursorTabela != null){
                if (!cursorTabela.estaVazio()) {
                    todosAlunos[j++] = cursorTabela.getPrimeiro().getAluno();
                }
            }
        }
        return todosAlunos;
    }
}