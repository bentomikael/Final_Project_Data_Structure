package br.ufsc.ine5609;

public class Aluno {
    private String matricula, nome, idade, centro;

    public Aluno(String matricula, String nome, String idade, String centro) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
        this.centro = centro;
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
}
