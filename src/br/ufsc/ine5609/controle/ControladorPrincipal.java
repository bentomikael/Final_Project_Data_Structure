package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.Constantes;

public class ControladorPrincipal {
    private ControleBuscas controleBuscas;
    private ControleTelas controleTelas;

    public ControladorPrincipal() {
        controleBuscas = ControleBuscas.getInstance();
        controleTelas = ControleTelas.getInstance();
    }
    public void iniciar(){
        opcaoDoMenu(controleTelas.inicio()); //exibe tela inicial e aguarda opcao
    }

    private void opcaoDoMenu(int opcao){ // recebe opcao e direciona
        switch (opcao){
            case 1:
                adicionaAluno(controleTelas.adicionaAluno());
                break;
            case 2:
                removeAluno();
                break;
            case 3:
                exibeAlunos(controleBuscas.pesquisaAluno(controleTelas.buscaAluno())); //pesquisa e exibe resultado
                break;
            case 4:
                exibeAlunos(pesquisaEmDiretorios(controleTelas.buscaGrupo())); //pesquisa e exibe resultado
                break;
            case 5:
                exibeAlunos(getListaAlunos());
                break;
        }
    }
    private void exibeAlunos(Aluno[] alunos){
        controleTelas.exibeAlunos(alunos);
        iniciar();
    }

    private boolean removeAluno(){
        return true;
    }
    private Object[] adicionaAluno(Object[] dadosAluno){
        String nome = (String) dadosAluno[0];
        String[] grupos = converteOpcoes(new int[]{(int) dadosAluno[1],(int) dadosAluno[2],(int) dadosAluno[3]});
        return new Object[]{nome,grupos[0],grupos[1],grupos[2]};
    }

    private Aluno[] pesquisaEmDiretorios(int[] opcoes){
        return controleBuscas.pesquisaGrupos(converteOpcoes(opcoes));
    }
    private String[] converteOpcoes(int[] opcoes) {
        String[] resposta = new String[3];
        if (opcoes[0] == 0) {
            resposta[0] = "-";
        } else if (opcoes[0] == 1) {
            resposta[0] = Constantes.CTC;
        } else if (opcoes[0] == 2) {
            resposta[0] = Constantes.CCS;
        } else if (opcoes[0] == 3) {
            resposta[0] = Constantes.CFH;
        } else if (opcoes[0] == 4) {
            resposta[0] = Constantes.CCE;
        }

        if (opcoes[0] == 0) {
            resposta[0] = "-";
        } else if (opcoes[1] == 1) {
            resposta[1] = Constantes.ADMINISTRACAO;
        } else if (opcoes[1] == 2) {
            resposta[1] = Constantes.SISTEMAS;
        } else if (opcoes[1] == 3) {
            resposta[1] = Constantes.COMPUTACAO;
        } else if (opcoes[1] == 4) {
            resposta[1] = Constantes.ENGENHARIA;
        }

        if (opcoes[0] == 0) {
            resposta[0] = "-";
        } else if (opcoes[2] == 1) {
            resposta[2] = Constantes.SIM;
        } else {
            resposta[2] = Constantes.NAO;
        }
        return resposta;
    }

    private Aluno[] getListaAlunos(){
        return controleBuscas.getListaAlunos();
    }



}
