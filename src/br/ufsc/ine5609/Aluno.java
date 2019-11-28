package br.ufsc.ine5609;

public class Aluno {
    private String matricula, nome, cotas, centro, curso;

    public Aluno(String matricula, String nome, String centro, String curso, String cotas) {
        this.matricula = matricula;
        this.nome = nome;
        this.centro = centro;
        this.curso = curso;
        this.cotas = cotas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCotas() {
        return cotas;
    }

    public void setCotas(String idade) {
        this.cotas = idade;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
