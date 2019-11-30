package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.estruturas.Hash;

import java.util.Random;

public class ControleEntradaSaida {
    private static final ControleEntradaSaida INSTANCE = new ControleEntradaSaida();

    private ControleEntradaSaida() {
    }

    public static ControleEntradaSaida getInstance() {
        return INSTANCE;
    }

    public void inserirNovoAluno(Object[] dadosNovoAluno, Hash listaPrincipal) {

        String matricula = gerarMatricula();
        String nome = dadosNovoAluno[0].toString();
        String centro = dadosNovoAluno[1].toString();
        String curso = dadosNovoAluno[2].toString();
        String cota = dadosNovoAluno[3].toString();

        System.out.println(matricula);
        System.out.println(nome);
        System.out.println(centro);
        System.out.println(curso);
        System.out.println(cota);

        listaPrincipal.inserir(new Aluno(matricula,nome,centro,curso,cota));
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
