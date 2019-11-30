package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.Hash;

public class ControleBuscas implements IControle {
    private static final ControleBuscas INSTANCE = new ControleBuscas();

    private ControleBuscas() {
    }

    public static ControleBuscas getInstance(){
        return INSTANCE;
    }

    public Aluno[] pesquisaGrupos(String[] opcoes, Diretorio[] diretorios){

        String centro = opcoes[0];
        String curso = opcoes[1];
        String cotas = opcoes[2];

        Diretorio diretorioCentro = defineDiretorioCentro(centro, diretorios);
        Diretorio diretorioCurso = defineDiretorioCurso(curso, diretorios);
        Diretorio diretorioCotas = defineDiretorioCotas(cotas, diretorios);

        if (diretorioCentro != null && diretorioCurso != null && diretorioCotas != null) {
            return pesquisaDiretoriosABC(diretorioCentro, diretorioCurso, diretorioCotas);
        } else if (diretorioCentro != null && diretorioCurso != null) {
            return pesquisaDiretoriosAB(diretorioCentro, diretorioCurso);
        } else if (diretorioCentro != null && diretorioCotas != null) {
            return pesquisaDiretoriosAB(diretorioCentro, diretorioCotas);
        } else if (diretorioCurso != null && diretorioCotas != null) {
            return pesquisaDiretoriosAB(diretorioCurso, diretorioCotas);
        } else if (diretorioCentro != null) {
            return diretorioCentro.getListaAlunos().getTodosAlunos();
        } else if (diretorioCurso != null) {
            return diretorioCurso.getListaAlunos().getTodosAlunos();
        } else if (diretorioCotas != null) {
            return diretorioCotas.getListaAlunos().getTodosAlunos();
        }
        return null;
    }

    private Aluno[] pesquisaDiretoriosAB(Diretorio diretorioA, Diretorio diretorioB) {

        Diretorio diretorioAB = new Diretorio("AB");

        Aluno[] alunosDiretorioA = diretorioA.getListaAlunos().getTodosAlunos();
        Aluno[] alunosDiretorioB = diretorioB.getListaAlunos().getTodosAlunos();

        for (int i = 0; i < alunosDiretorioA.length; i++) {
            for (int j = 0; j < alunosDiretorioB.length; j++) {
                if (alunosDiretorioA[i].getMatricula() == alunosDiretorioB[j].getMatricula()) {
                    diretorioAB.getListaAlunos().insiraPrimeiro(alunosDiretorioA[i]);
                }
            }
        }
        return diretorioAB.getListaAlunos().getTodosAlunos();
    }

    private Aluno[] pesquisaDiretoriosABC(Diretorio diretorioA, Diretorio diretorioB, Diretorio diretorioC) {

        Diretorio diretorioABC = new Diretorio("ABC");

        Aluno[] alunosDiretorioAB = pesquisaDiretoriosAB(diretorioA, diretorioB);
        Aluno[] alunosDiretorioC = diretorioC.getListaAlunos().getTodosAlunos();

        if(alunosDiretorioAB != null) {
            for (int i = 0; i < alunosDiretorioAB.length; i++) {
                for (int j = 0; j < alunosDiretorioC.length; j++) {
                    if (alunosDiretorioAB[i].getMatricula() == alunosDiretorioC[j].getMatricula()) {
                        diretorioABC.getListaAlunos().insiraPrimeiro(alunosDiretorioAB[i]);
                    }
                }
            }
        }

        return diretorioABC.getListaAlunos().getTodosAlunos();
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
    public Diretorio defineDiretorioCotas(String cotas, Diretorio[] diretorios) {
        if (cotas == diretorios[6].getNome()) {
            return diretorios[6];
        } else if (cotas == diretorios[7].getNome()) {
            return diretorios[7];
        }
        return null;
    }

    /**
     * Metodo para retornar um aluno buscando pela matricula na lista principal
     * @return aluno encontrado
     */
    public Aluno encontraAlunoPelaMatricula(String matricula, Hash listaPrincipal) {
        return listaPrincipal.encontrarPorChave(matricula);
    }
}
