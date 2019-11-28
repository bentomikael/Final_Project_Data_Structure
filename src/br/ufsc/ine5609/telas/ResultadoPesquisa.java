package br.ufsc.ine5609.telas;

import br.ufsc.ine5609.Aluno;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ResultadoPesquisa extends JFrame{
    private String[] colunas;
    private JTable tabela;
    private JScrollPane scroll;

    public ResultadoPesquisa(String[][] alunos){ //recebera como parametro array de alunos
        super("Resultado da Pesquisa");
        Container container = getContentPane();
        colunas = new String[]{"Matrícula", "Nome", "Centro", "Curso", "Cotista?"};

        // verifica se a lista de resposta esta vazia
        if(alunos.length == 0) {
            container.setLayout(new GridBagLayout());
            container.add(new JLabel("Nenhum resultado encontrado"));
        }else {
            tabela = new JTable(alunos, colunas);
            scroll = new JScrollPane(tabela);
            container.add(scroll);
        }

        //configuracoes do frame para ser iniciado
        setContentPane(container);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(500, 450);
        setLocation(450, 200);
        //setVisible(true);
    }
    public void exibir(){
        JPanel resultado = new JPanel();
        Object [][] dados = {
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
                {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
                {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
        };
        String[] colunas = new String[]{"Matrícula", "Nome", "Centro", "Curso", "Cotista?"};
        JTable tabela = new JTable(dados,colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        resultado.add(scroll);

        int result = JOptionPane.showConfirmDialog(null, resultado,
                "Insira os parametros para sua pesquisa", JOptionPane.OK_CANCEL_OPTION);
    }


}
