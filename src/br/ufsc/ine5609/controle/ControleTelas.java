package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.telas.Interface;

import java.util.Scanner;

public class ControleTelas {
    private static final ControleTelas INSTANCE = new ControleTelas();
    private Scanner key;
    private int option;
    private Interface tela;

    private ControleTelas() {
        key = new Scanner(System.in);
        tela = new Interface();
    }
    public static ControleTelas getInstance(){
        return INSTANCE;
    }

    public int inicio() {
        tela.mostrarOpcoesHome();
        return inputInt(5);
    }

    public Object[] adicionaAluno(){
        Object[] dadosAluno = new Object[4];
        tela.pedeNome();
        dadosAluno[0] = key.nextLine();

        tela.mostrarOpcoesCentros(true);
        dadosAluno[1] = inputInt(3);
        tela.mostrarOpcoesCursos(true);
        dadosAluno[2] = inputInt(3);
        tela.mostrarOpcoesCotas(true);
        dadosAluno[3] = inputInt(2);
        return dadosAluno;
    }

    public String pegaMatricula() {
        tela.pedeMatricula();
        return key.nextLine();
    }

    public int[] buscaGrupo(){
        int[] arrayGrupos = new int[3];
        tela.mostrarOpcoesCentros(false);
        arrayGrupos[0] =  inputInt(4);
        tela.mostrarOpcoesCursos(false);
        arrayGrupos[1] =  inputInt(4);
        tela.mostrarOpcoesCotas(false);
        arrayGrupos[2] = inputInt(2);
        return arrayGrupos;
    }

    public void exibeAlunos(Aluno[] alunos){
        tela.listarAlunos(alunos);
        System.out.println("\n Pressione uma tecla para continuar");
        key.nextLine();
    }

    /**
     * Recebe uma String,garante que contem apenas numeros e converte para int.
     * entra em loop até um valor correto ser inserido.
     * @param numeroMaximo maior numero de entrada permitido
     * @return retorna inteiro positivo
     */
    private int inputInt(int numeroMaximo) {
        String toInt;
        boolean valid;
        do {
            toInt = key.nextLine();
            if (toInt.equals("")) {
                valid = false;
                tela.mOpcaoInvalida();
            }else{
                try {
                    option = Integer.valueOf(toInt);
                    if (option < 0)
                        valid = false;
                    else
                        valid = true;
                } catch (NumberFormatException e) {
                    tela.mOpcaoInvalida();
                    valid = false;
                }

                if (valid == true && numeroMaximo != 0 && option > numeroMaximo) {
                    valid = false;
                    tela.mOpcaoInvalida();
                }
            }
        } while (!valid);
        return option;
    }
}
