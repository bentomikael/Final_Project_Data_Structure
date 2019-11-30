package br.ufsc.ine5609.telas;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.Constantes;

public class Interface {

    public void listarAlunos(Aluno[] alunos){
        if(alunos == null) {
            System.out.println("------------------Nenhum aluno encontrado------------------");
        } else if (alunos[0] == null) {
            System.out.println("------------------Matricula nao existe------------------");
        } else {
            System.out.printf("%s %15s %15s %14s %12s \n",
                    " ___________", " __________ ", "________ ", " _________", " ________");
            System.out.printf("%1s %15s %13s %17s %-8s \n",
                    "| Matricula |",
                    "|    Nome    |",
                    "| Centro |",
                    "|   Curso  |",
                    "|  Cotas? |");
            for (Aluno a : alunos)
                System.out.printf("%10s %15s %14s %18s %8s \n",
                        a.getMatricula(),
                        a.getNome(),
                        a.getCentro(),
                        a.getCurso(),
                        a.getCotas());
        }
    }

    public void mostrarOpcoesHome(){
        System.out.println("1 - Adicionar Aluno");
        System.out.println("2 - Remover Aluno");
        System.out.println("3 - Buscar um Aluno");
        System.out.println("4 - Buscar conjunto de Alunos");
        System.out.println("5 - Listar Alunos");

    }

    public void mostrarOpcoesCentros(boolean ehCadastro){
        if (! ehCadastro)
            System.out.println("0 - Nenhum");
        System.out.println("1 - "+ Constantes.CTC);
        System.out.println("2 - "+ Constantes.CCS);
        System.out.println("3 - "+ Constantes.CCE);
    }

    public void mostrarOpcoesCursos(boolean ehCadastro){
        if (! ehCadastro)
            System.out.println("0 - Nenhum");
        System.out.println("1 - "+ Constantes.SISTEMAS);
        System.out.println("2 - "+ Constantes.COMPUTACAO);
        System.out.println("3 - "+ Constantes.ENGENHARIA);
    }

    public void mostrarOpcoesCotas(boolean ehCadastro){
        if (! ehCadastro)
            System.out.println("0 - Nenhum");
        System.out.println("1 - "+ Constantes.SIM);
        System.out.println("2 - "+ Constantes.NAO);
    }

    public void pedeNome() {
        System.out.println("Digite o nome do aluno");
    }

    public void pedeMatricula() {
        System.out.println("Digite a matricula do aluno");
    }

    public void mMatriculaInvalida() {
        System.out.println("Matricula Invalida! Tente Novamente");
    }

    public void mOpcaoInvalida() {
        System.out.println("** Opcao Invalida! Tente Novamente **");
    }
}
