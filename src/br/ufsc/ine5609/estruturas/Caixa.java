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
public class Caixa {
    
    private Caixa proximo;
    private Object elemento;

    public Caixa(Caixa proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Caixa getProximo() {
        return proximo;
    }

    public void setProximo(Caixa proximo) {
        this.proximo = proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
