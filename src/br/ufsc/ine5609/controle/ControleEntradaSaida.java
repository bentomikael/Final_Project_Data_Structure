package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.estruturas.Hash;
import br.ufsc.ine5609.estruturas.Diretorio;
import java.util.Random;

public class ControleEntradaSaida {
    private static final ControleEntradaSaida INSTANCE = new ControleEntradaSaida();

    private ControleEntradaSaida() {
    }

    public static ControleEntradaSaida getInstance() {
        return INSTANCE;
    }

    public void inserirNovoAluno(Object[] dadosNovoAluno, Hash listaPrincipal, Diretorio[] diretorios) {

        String matricula = gerarMatricula();
        String nome = (String) dadosNovoAluno[0];
        String centro = (String) dadosNovoAluno[1];
        String curso = (String) dadosNovoAluno[2];
        String cota = (String) dadosNovoAluno[3];

        //teste
        System.out.println(matricula);
        System.out.println(nome);
        System.out.println(centro);
        System.out.println(curso);
        System.out.println(cota);
        //teste

        Aluno novoAluno = new Aluno(matricula,nome,centro,curso,cota);

        inserirNoDiretorioCentro(novoAluno, diretorios);
        inserirNoDiretorioCurso(novoAluno, diretorios);
        inserirNoDiretorioCota(novoAluno, diretorios);

        listaPrincipal.inserir(novoAluno);
    }

    private void inserirNoDiretorioCentro(Aluno aluno, Diretorio[] diretorios) {
        if (aluno.getCentro() == diretorios[0].getNome()) { //CTC
            diretorios[0].getListaAlunos().insiraPrimeiro(aluno);
        } else if (aluno.getCentro() == diretorios[1].getNome()) { //CCS
            diretorios[1].getListaAlunos().insiraPrimeiro(aluno);
        } else if (aluno.getCentro() == diretorios[2].getNome()) { //CCE
            diretorios[2].getListaAlunos().insiraPrimeiro(aluno);
        }
    }

    private void inserirNoDiretorioCurso(Aluno aluno, Diretorio[] diretorios) {
        if (aluno.getCurso() == diretorios[3].getNome()) { //SISTEMAS
            diretorios[3].getListaAlunos().insiraPrimeiro(aluno);
        } else if (aluno.getCurso() == diretorios[4].getNome()) { //COMPUTACAO
            diretorios[4].getListaAlunos().insiraPrimeiro(aluno);
        } else if (aluno.getCurso() == diretorios[5].getNome()) { //ENGENHARIA
            diretorios[5].getListaAlunos().insiraPrimeiro(aluno);
        }
    }

    private void inserirNoDiretorioCota(Aluno aluno, Diretorio[] diretorios) {
        if (aluno.getCotas() == diretorios[6].getNome()) { //SIM
            diretorios[6].getListaAlunos().insiraPrimeiro(aluno);
        } else if (aluno.getCotas() == diretorios[7].getNome()) { //NAO
            diretorios[7].getListaAlunos().insiraPrimeiro(aluno);
        }
    }

    /**
     * Metodo para gerar uma matricula
     * @return matricula com os caracteres selecionados randomicamente entre os disponiveis no array
     */
    private String gerarMatricula() {
        Random rand = new Random();
        String matricula = "";
        int tamanhaoMatricula = 4; //SETA O TAMANHO DA MATRICULA
        String[] caracteres = new String [] {"1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < tamanhaoMatricula; i++) {
            matricula += caracteres[rand.nextInt(9)];
        }
        return matricula;
    }


}
