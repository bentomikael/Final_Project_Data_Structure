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
    
    public void remova(Object aluno) { // refactor for removeById
        if (!estaVazio()) {
            
            Caixa cursor = this.getPrimeiro();
            for (int i = 0; i < this.getNumAlunos() - 1; i++) {
                if (cursor.equals(aluno)) { // cursor.getaluno().equals() 
                    if (cursor.equals(this.getPrimeiro()) && cursor.equals(this.getUltimo())) { //is primeiro e ultimo e decrementaNumAlunos
                        this.setPrimeiro(null);
                        this.setUltimo(null);
                        this.decrementaNumAlunos();
                    }
                    if (cursor.equals(this.getPrimeiro())) { //is primeiro e decrementaNumAlunos
                        this.setPrimeiro(this.getPrimeiro().getProximo());
                        this.decrementaNumAlunos();
                    }
                    if (cursor.equals(this.getUltimo())) { //is ultimo e decrementaNumAlunos
                        Caixa novoUltimo = this.getPrimeiro();
                        for (int j = 0; j < this.getNumAlunos() - 2 ; j++) { 
                            novoUltimo = novoUltimo.getProximo();
                        }
                        novoUltimo.setProximo(null);
                        this.setUltimo(novoUltimo);
                    } 
                    if (!cursor.equals(this.getPrimeiro()) && !cursor.equals(this.getUltimo())) { // not is the primeiro e the ultimo e decrementaNumAlunos
                        Caixa paraRemover = cursor;
                        cursor = this.getPrimeiro();
                        for (int k = 0; k < i - 1; k++) {
                            cursor = cursor.getProximo();
                        }
                        cursor.setProximo(paraRemover.getProximo());
                    }
                } else {
                    cursor = cursor.getProximo();
                }
            }
        }
    }
}
