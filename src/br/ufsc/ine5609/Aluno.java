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

    public String getNome() {
        return nome;
    }

    public String getCotas() {
        return cotas;
    }

    public String getCentro() {
        return centro;
    }

    public String getCurso() {
        return curso;
    }

}
