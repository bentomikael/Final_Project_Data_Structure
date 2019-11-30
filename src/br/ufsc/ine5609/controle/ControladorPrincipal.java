package br.ufsc.ine5609.controle;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.Constantes;
import br.ufsc.ine5609.estruturas.Diretorio;
import br.ufsc.ine5609.estruturas.Hash;

public class ControladorPrincipal {
    private ControleBuscas controleBuscas;
    private ControleEntradaSaida controleEntradaSaida;
    private ControleTelas controleTelas;
    private Hash listaPrincipal;
    private Diretorio[] diretorios;

    public ControladorPrincipal(Hash listaPrincipal, Diretorio[] diretorios) {
        controleBuscas = ControleBuscas.getInstance();
        controleEntradaSaida = ControleEntradaSaida.getInstance();
        controleTelas = ControleTelas.getInstance();
        this.listaPrincipal = listaPrincipal;
        this.diretorios = diretorios;

    }

    public void iniciar(){
        opcaoDoMenu(controleTelas.inicio()); //exibe tela inicial e aguarda opcao
    }

    private void opcaoDoMenu(int opcao){ // recebe opcao e direciona
        switch (opcao){
            case 1:
                adicionaAluno(controleTelas.adicionaAluno(), this.listaPrincipal, this.diretorios); // recebe os dados do aluno, a lista principal e os diretorios
                break;
            case 2:
                removeAluno(controleBuscas.encontraAlunoPelaMatricula(controleTelas.pegaMatricula(), this.listaPrincipal),
                        this.listaPrincipal, this.diretorios); //recebe o aluno, a lista principal e os diretorios
                break;
            case 3:
                exibeUnicoAluno(controleBuscas.encontraAlunoPelaMatricula(controleTelas.pegaMatricula(), this.listaPrincipal)); //pesquisa e exibe resultado
                break;
//            case 666:
//                exibeAlunos(pesquisaEmDiretorios(controleTelas.buscaGrupo())); //pesquisa e exibe resultado
//                break;
            case 4:
                exibeAlunos(pesquisaEmDiretorios(controleTelas.buscaGrupo(), this.diretorios)); //pesquisa e exibe resultado
                break;
            case 5:
                exibeAlunos(getListaAlunos()); // funcionando, lista todos os alunos
                break;
        }
    }

    private void adicionaAluno(Object[] dadosNovoAluno, Hash listaPrincipal, Diretorio[] diretorios) {
        Object[] dadosParaInserir = converteDadosAluno(dadosNovoAluno);
        this.controleEntradaSaida.inserirNovoAluno(dadosParaInserir, listaPrincipal, diretorios);
        iniciar();
    }

    private void removeAluno(Aluno aluno, Hash listaPrincipal, Diretorio[] diretorios) {
        this.controleEntradaSaida.removerAluno(aluno, listaPrincipal, diretorios);
        iniciar();
    }

    private void exibeUnicoAluno(Aluno aluno) {
        Aluno[] unicoAluno = new Aluno[] { aluno };
        controleTelas.exibeAlunos(unicoAluno);
        iniciar();
    }

    private void exibeAlunos(Aluno[] alunos){
        controleTelas.exibeAlunos(alunos);
        iniciar();
    }

    private Object[] converteDadosAluno(Object[] dadosAluno){
        String nome = (String) dadosAluno[0];
        String[] grupos = converteOpcoes(new int[]{(int) dadosAluno[1],(int) dadosAluno[2],(int) dadosAluno[3]});
        return new Object[]{nome,grupos[0],grupos[1],grupos[2]};
    }

    private Aluno[] pesquisaEmDiretorios(int[] opcoes, Diretorio[] diretorios){
        return controleBuscas.pesquisaGrupos(converteOpcoes(opcoes), diretorios);
    }
    //abaixo foi removida ADMINISTRACAO e CFH

    private String[] converteOpcoes(int[] opcoes) {
        String[] resposta = new String[3];
        if (opcoes[0] == 0) {
            resposta[0] = "-";
        } else if (opcoes[0] == 1) {
            resposta[0] = Constantes.CTC;
        } else if (opcoes[0] == 2) {
            resposta[0] = Constantes.CCS;
        } else if (opcoes[0] == 3) {
            resposta[0] = Constantes.CCE;
        }

        if (opcoes[1] == 0) {
            resposta[1] = "-";
        } else if (opcoes[1] == 1) {
            resposta[1] = Constantes.SISTEMAS;
        } else if (opcoes[1] == 2) {
            resposta[1] = Constantes.COMPUTACAO;
        } else if (opcoes[1] == 3) {
            resposta[1] = Constantes.ENGENHARIA;
        }

        if (opcoes[2] == 0) {
            resposta[2] = "-";
        } else if (opcoes[2] == 1) {
            resposta[2] = Constantes.SIM;
        } else {
            resposta[2] = Constantes.NAO;
        }
        return resposta;
    }

    private Aluno[] getListaAlunos(){
        return this.listaPrincipal.getArrayAlunos();
    }

    public ControleEntradaSaida getControleEntradaSaida() {
        return this.controleEntradaSaida;
    }

    public Diretorio[] getDiretorios() {
        return this.diretorios;
    }


}
