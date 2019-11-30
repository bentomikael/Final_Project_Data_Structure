package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.estruturas.Hash;
import br.ufsc.ine5609.estruturas.Diretorio;
import java.util.Random;

public class ControleEntradaSaida implements IControle {
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

        Aluno novoAluno = new Aluno(matricula,nome,centro,curso,cota);
        inserirNoDiretorio(novoAluno, defineDiretorioCentro(novoAluno.getCentro(), diretorios));
        inserirNoDiretorio(novoAluno, defineDiretorioCurso(novoAluno.getCurso(), diretorios));
        inserirNoDiretorio(novoAluno, defineDiretorioCotas(novoAluno.getCotas(), diretorios));
        listaPrincipal.inserir(novoAluno);
    }

    public void removerAluno(Aluno aluno, Hash listaPrincipal, Diretorio[] diretorios) {
        removerDoDiretorio(aluno, defineDiretorioCentro(aluno.getCentro(), diretorios));
        removerDoDiretorio(aluno, defineDiretorioCurso(aluno.getCurso(), diretorios));
        removerDoDiretorio(aluno, defineDiretorioCotas(aluno.getCotas(), diretorios));
        listaPrincipal.remover(aluno);
    }

    /**
     * Metodo para inserir um aluno em um diretorio
     */
    private void inserirNoDiretorio(Aluno aluno, Diretorio diretorio) {
        diretorio.getListaAlunos().insiraPrimeiro(aluno);
    }

    /**
     * Metodo para remover um aluno de um diretorio
     */
    private void removerDoDiretorio(Aluno aluno, Diretorio diretorio) {
        diretorio.getListaAlunos().remova(aluno);
    }

    /**
     * Metodo para definer o diretorio centro correto para o aluno
     * @return diretorio correto
     */
    @Override
    public Diretorio defineDiretorioCentro(String centro, Diretorio[] diretorios) {
        if (centro == diretorios[0].getNome()) {
            return diretorios[0];
        } else if (centro == diretorios[1].getNome()) {
            return diretorios[1];
        } else if (centro == diretorios[2].getNome()) {
            return diretorios[2];
        }
        return null;
    }

    /**
     * Metodo para definer o diretorio curso correto para o aluno
     * @return diretorio correto
     */
    @Override
    public Diretorio defineDiretorioCurso(String curso, Diretorio[] diretorios) {
        if (curso == diretorios[3].getNome()) {
            return diretorios[3];
        } else if (curso == diretorios[4].getNome()) {
            return diretorios[4];
        } else if (curso == diretorios[5].getNome()) {
            return diretorios[5];
        }
        return null;
    }

    /**
     * Metodo para definer o diretorio cota correto para o aluno
     * @return diretorio correto
     */
    @Override
    public Diretorio defineDiretorioCotas(String cota, Diretorio[] diretorios) {
        if (cota == diretorios[6].getNome()) {
            return diretorios[6];
        } else if (cota == diretorios[7].getNome()) {
            return diretorios[7];
        }
        return null;
    }

    /**
     * Metodo para gerar uma matricula
     * @return matricula com os caracteres selecionados randomicamente entre os disponiveis no array
     */
    private String gerarMatricula() {
        Random rand = new Random();
        String matricula = "";
        int tamanhaoMatricula = 4;
        String[] caracteres = new String [] {"1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < tamanhaoMatricula; i++) {
            matricula += caracteres[rand.nextInt(9)];
        }
        return matricula;
    }
}
