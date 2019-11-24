package br.ufsc.ine5609.screen;

import javax.swing.*;
import java.awt.*;

public class ResultadoPesquisa extends JFrame{
    private String[] colunas;
    private JTable tabela;
    private JScrollPane scroll;

    public ResultadoPesquisa(){ //recebera como parametro array de alunos
        super("Resultado da Pesquisa");
        Container container = getContentPane();
        colunas = new String[]{"Matrícula", "Nome", "Idade","Centro"};

        //teste
        Object[][] alunos = new Object[][]{
               // {"1919", "José", "22","CTC"},
               // {"1111", "João", "33","CCJ"},
               // {"0150", "Maria", "19","CFH"}
        };

        boolean listaVazia = (alunos.length == 0);
        if(listaVazia) {
            container.setLayout(new GridBagLayout());
            container.add(new JLabel("Nenhum resultado encontrado"));
        }else {
            tabela = new JTable(alunos, colunas);
            scroll = new JScrollPane(tabela);
            container.add(scroll);
        }

        //configuracoes do frame para ser iniciado
        setContentPane(container);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocation(450, 200);
        setVisible(true);
    }
}
