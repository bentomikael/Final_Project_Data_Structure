/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

/**
 *
 * @author m1k4
 */
public class ListaEncadeada {
    
    private int numElementos;
    private Caixa primeiro, ultimo;

    public ListaEncadeada() {
        this.numElementos = 0;
        this.primeiro = null;
        this.ultimo = null;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElements) {
        this.numElementos = numElements;
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
    
    private void incrementaNumElementos() {
        this.numElementos++;
    }
    
    private void decrementaNumElementos() {
        this.numElementos--;
    }
    
    private boolean estaVazio() {
        return (getNumElementos() == 0);
    }
    
    private void insiraListaVazia(Caixa caixa) {
        this.setPrimeiro(caixa);
        this.setUltimo(caixa);
        this.incrementaNumElementos();
    }
    
    public void insiraPrimeiro(Object elemento) {
        Caixa caixa = new Caixa(null, elemento);
        if (estaVazio()) 
           this.insiraListaVazia(caixa);
         else {
            caixa.setProximo(this.getPrimeiro());
            this.setPrimeiro(caixa);
            this.incrementaNumElementos();
        }
    }
    
    public void insiraUltimo(Object elemento) {
        Caixa caixa = new Caixa(null, elemento);
        if (estaVazio()) 
           this.insiraListaVazia(caixa);
         else {
            this.getUltimo().setProximo(caixa);
            this.setUltimo(caixa);
            this.incrementaNumElementos();
        }
    }
    
    public void remova(Object elemento) { // refactor for removeById
        if (!estaVazio()) {
            
            Caixa cursor = this.getPrimeiro();
            for (int i = 0; i < this.getNumElementos() - 1; i++) {
                if (cursor.equals(elemento)) { // cursor.getElemento().equals() 
                    if (cursor.equals(this.getPrimeiro()) && cursor.equals(this.getUltimo())) { //is primeiro and ultimo and decrementaNumElementos
                        this.setPrimeiro(null);
                        this.setUltimo(null);
                        this.decrementaNumElementos();
                    }
                    if (cursor.equals(this.getPrimeiro())) { //is primeiro and decrementaNumElementos
                        this.setPrimeiro(this.getPrimeiro().getProximo());
                        this.decrementaNumElementos();
                    }
                    if (cursor.equals(this.getUltimo())) { //is ultimo and decrementaNumElementos
                        Caixa novoUltimo = this.getPrimeiro();
                        for (int j = 0; j < this.getNumElementos() - 2 ; j++) { 
                            novoUltimo = novoUltimo.getProximo();
                        }
                        novoUltimo.setProximo(null);
                        this.setUltimo(novoUltimo);
                    } 
                    if (!cursor.equals(this.getPrimeiro()) && !cursor.equals(this.getUltimo())) { // not is the primeiro and the ultimo and decrementaNumElementos
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
