package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.Constantes;
import br.ufsc.ine5609.telas.Interface;

import java.util.Scanner;

public class ControleTelas {
    private static final ControleTelas INSTANCE = new ControleTelas();
    private Scanner key; // entrada de dados
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
        return inputInt(4);
    }

    public Object[] adicionaAluno(){
        Object[] dadosAluno = new Object[4];
        tela.pedeNome();
        dadosAluno[0] = key.nextLine(); // nome do aluno

        tela.mostrarOpcoesCentros(true);
        int opcaoCentro = inputInt(3); // centro 1, 2, 3

        switch (opcaoCentro) {
            case 1:
                dadosAluno[1] = Constantes.CTC;
                break;
            case 2:
                dadosAluno[1] = Constantes.CCS;
                break;
            case 3:
                dadosAluno[1] = Constantes.CCE;
                break;
        }

        tela.mostrarOpcoesCursos(true);
        int opcaoCurso = inputInt(3); // curso 1, 2, 3

        switch (opcaoCurso) {
            case 1:
                dadosAluno[2] = Constantes.SISTEMAS;
                break;
            case 2:
                dadosAluno[2] = Constantes.COMPUTACAO;
                break;
            case 3:
                dadosAluno[2] = Constantes.ENGENHARIA;
                break;
        }


        tela.mostrarOpcoesCotas(true);
        int opcaoCota = inputInt(2); // cota

        switch (opcaoCota) {
            case 1:
                dadosAluno[3] = Constantes.SIM;
                break;
            case 2:
                dadosAluno[3] = Constantes.NAO;
                break;
        }

        return dadosAluno;

    }
    public String buscaAluno(){
        tela.mostrarOpcoesBuscaAluno();
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
        boolean valid = false;
        do {
            toInt = key.nextLine();
            if (toInt.equals("")) { //verifica se deu apenas enter
                valid = false;
                tela.mOpcaoInvalida();
            }else{
                try {
                    option = Integer.valueOf(toInt); //converte para int
                    if (option < 0)
                        valid = false;
                    else
                        valid = true;
                } catch (NumberFormatException e) { //se nao conseguiu converter eh pq nao tem apenas numeros
                    tela.mOpcaoInvalida();
                    valid = false;
                }
                // verifica se esta no limite indicado. se limite = 0,limite infinito
                if (valid == true && numeroMaximo != 0 && option > numeroMaximo) {
                    valid = false;
                    tela.mOpcaoInvalida();
                }
            }
        } while (!valid);
        return option;
    }
}
