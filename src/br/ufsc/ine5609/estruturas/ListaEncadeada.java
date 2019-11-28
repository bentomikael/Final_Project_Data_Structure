package br.ufsc.ine5609.estruturas;

import br.ufsc.ine5609.Aluno;

/**
 *
 * @author m1k4
 */
public class ListaEncadeada {
    
    private int numAlunos;
    private Caixa primeiro, ultimo;

    public ListaEncadeada() {
        this.numAlunos = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public int getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(int numElements) {
        this.numAlunos = numElements;
    }

    public Caixa getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Caixa first) {
        this.primeiro = first;
    }

    public Caixa getUltimo() {
        return ultimo;
    }

    public void setUltimo(Caixa ultimo) {
        this.ultimo = ultimo;
    }
    
    private void incrementaNumAlunos() {
        this.numAlunos++;
    }
    
    private void decrementaNumAlunos() {
        this.numAlunos--;
    }
    
    public boolean estaVazio() {
        return (getNumAlunos() == 0);
    }
    
    private void insiraListaVazia(Caixa caixa) {
        this.setPrimeiro(caixa);
        this.setUltimo(caixa);
        this.incrementaNumAlunos();
    }
    
    public void insiraPrimeiro(Aluno aluno) {
        Caixa caixa = new Caixa(null, aluno);
        if (estaVazio()) 
           this.insiraListaVazia(caixa);
         else {
            caixa.setProximo(this.getPrimeiro());
            this.setPrimeiro(caixa);
            this.incrementaNumAlunos();
        }
    }
    
    public void insiraUltimo(Aluno aluno) {
        Caixa caixa = new Caixa(null, aluno);
        if (estaVazio()) 
           this.insiraListaVazia(caixa);
         else {
            this.getUltimo().setProximo(caixa);
            this.setUltimo(caixa);
            this.incrementaNumAlunos();
        }
    }
    
    public void remova(Aluno aluno) {
        if (!estaVazio()) {
            Caixa cursor = this.getPrimeiro();
            int numAlunos = this.getNumAlunos();
            for (int i = 0; i < numAlunos; i++) {
                if (cursor.getAluno().equals(aluno)) {
                    if (cursor.getAluno().equals(this.getPrimeiro().getAluno()) && 
                    cursor.getAluno().equals(this.getUltimo().getAluno())) { //eh primeiro e ultimo e decrementaNumAlunos
                        this.setPrimeiro(null);
                        this.setUltimo(null);
                        this.decrementaNumAlunos();
                        break;
                    }
                    if (cursor.getAluno().equals(this.getPrimeiro().getAluno())) { //eh primeiro e decrementaNumAlunos
                        this.setPrimeiro(this.getPrimeiro().getProximo());
                        this.decrementaNumAlunos();
                        break;
                    }
                    if (cursor.getAluno().equals(this.getUltimo().getAluno())) { //eh ultimo e decrementaNumAlunos
                        Caixa novoUltimo = this.getPrimeiro();
                        for (int j = 0; j < numAlunos - 2 ; j++) { 
                            novoUltimo = novoUltimo.getProximo();
                        }
                        novoUltimo.setProximo(null);
                        this.setUltimo(novoUltimo);
                        break;
                    } 
                    if (!cursor.getAluno().equals(this.getPrimeiro().getAluno()) && 
                    !cursor.getAluno().equals(this.getUltimo().getAluno())) { // nao eh o primeiro e o ultimo e decrementaNumAlunos
                        Caixa paraRemover = cursor;
                        cursor = this.getPrimeiro();
                        for (int k = 0; k < i - 1; k++) {
                            cursor = cursor.getProximo();
                        }
                        cursor.setProximo(paraRemover.getProximo());
                        break;
                    }
                } else {
                    cursor = cursor.getProximo();
                }
            }
        }
    }
    public Aluno[] getTodosAlunos(){
        Aluno[] alunos = new Aluno[numAlunos];

        if(getNumAlunos() == 0)
            return null;
        else{
            // PEGAR TODOS ALUNOS DA LISTA E PASSAR PARA UM ARRAY DE ALUNOS
        }
        return alunos;
    }
}
