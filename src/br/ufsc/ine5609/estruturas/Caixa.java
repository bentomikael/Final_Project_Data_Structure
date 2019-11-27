package br.ufsc.ine5609.estruturas;

import br.ufsc.ine5609.Aluno;

/**
 *
 * @author m1k4
 */
public class Caixa {
    
    private Caixa proximo;
    private Aluno aluno;

    public Caixa(Caixa proximo, Aluno aluno) {
        this.proximo = proximo;
        this.aluno = aluno;
    }

    public Caixa getProximo() {
        return proximo;
    }

    public void setProximo(Caixa proximo) {
        this.proximo = proximo;
    }

    public Object getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
