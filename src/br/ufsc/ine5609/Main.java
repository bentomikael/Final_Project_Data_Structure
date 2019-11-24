package br.ufsc.ine5609;

import br.ufsc.ine5609.screen.MainFrame;
import br.ufsc.ine5609.screen.ResultadoPesquisa;

public class Main{
    public static void main(String args[]){

        //testar os dois frames

        //MainFrame m = new MainFrame();

        //ResultadoPesquisa r = new ResultadoPesquisa();
        ControlScreen c = new ControlScreen();
        c.pesquisaAluno("232");

    }
}