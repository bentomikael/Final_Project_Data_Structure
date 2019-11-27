package br.ufsc.ine5609;

public class Aluno {
    private String matricula, nome, idade, centro, curso;

    public Aluno(String matricula, String nome, String idade, String centro, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.centro = centro;
        this.curso = curso;
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
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
