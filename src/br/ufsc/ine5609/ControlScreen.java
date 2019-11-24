package br.ufsc.ine5609;

import br.ufsc.ine5609.screen.MainFrame;
import br.ufsc.ine5609.screen.ResultadoPesquisa;

public class ControlScreen {
    private MainFrame main;
    private ResultadoPesquisa resultado;

    public ControlScreen(){

    }

    public void pesquisaAluno(String entrada){

        if(Character.isDigit(entrada.charAt(0))) // verifica se comeca com numero
            buscaMatricula(entrada);
        else
            buscaNome(entrada);
    }

    //retornarao um object aluno
    private void buscaMatricula(entrada){

    }
    private void buscaNome(entrada){

    }
    private void abreFrameResposta(Object[] alunos){
        resultado = new ResultadoPesquisa(alunos);
    }
}
