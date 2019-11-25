package br.ufsc.ine5609.telas;

import br.ufsc.ine5609.Buscas;
import javafx.scene.control.ComboBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MainFrame extends JFrame {

    private JScrollPane scroll;
    private JTable tabela;
    private JPanel painelBotao;
    private JButton bt_pesquisarGrupo;
    private JButton bt_pesquisarIndividuo;
    private final String[] colunas;


    public MainFrame(Object[][] alunos) {

        super("Lista Alunos");

        //teste
        colunas = new String[]{"Matrícula", "Nome", "Idade", "Centro"};

        bt_pesquisarGrupo = new JButton("Fazer Pesquisa de um grupo");
        bt_pesquisarGrupo.addActionListener(new AcaoPesquisarGrupo());
        bt_pesquisarIndividuo = new JButton("Pesquisar por matrícula");
        bt_pesquisarIndividuo.addActionListener(new AcaoPesquisarIndividuo());

        Container container = getContentPane();
        setLayout(new BorderLayout());
        tabela = new JTable(alunos, colunas);
        painelBotao = new JPanel();

        //adiciona componentes nos paineis
        scroll = new JScrollPane(tabela);
        painelBotao.add(Box.createVerticalStrut(35)); // espacamento vertical
        painelBotao.add(bt_pesquisarIndividuo);
        painelBotao.add(bt_pesquisarGrupo);

        //adiciona paineis no container principal
        container.add(scroll);
        container.add(painelBotao, BorderLayout.SOUTH);

        //configuracoes do frame para ser iniciado
        setContentPane(container);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocation(450, 200);
        setVisible(true);

    }


    private class AcaoPesquisarGrupo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JComboBox primeiro = new JComboBox();
            JComboBox segundo = new JComboBox();
            primeiro.addItem("teste");
            segundo.addItem("-");

            JPanel dialogPanel = new JPanel();
            dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
            dialogPanel.add(new JLabel("Parametro 1"));
            dialogPanel.add(primeiro);
            dialogPanel.add(new JLabel("Parametro 2"));
            dialogPanel.add(segundo);

            int result = JOptionPane.showConfirmDialog(null, dialogPanel,
                    "Insira os parametros para sua pesquisa", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                pesquisaGrupos(primeiro.getSelectedItem().toString(),segundo.getSelectedItem().toString());
            }
        }
    }

    private class AcaoPesquisarIndividuo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JTextField tf_entrada = new JTextField();

            JPanel dialogPanel = new JPanel();
            dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
            dialogPanel.add(new JLabel("Matrícula ou Nome"));
            dialogPanel.add(tf_entrada);

            int result = JOptionPane.showConfirmDialog(null, dialogPanel,
                    "Pesquisa de Aluno por matrícula ou nome", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                pesquisaAluno(tf_entrada.getText());
            }
        }
    }

    private void pesquisaGrupos(String primeiro, String segundo){
        System.out.println(primeiro + " "+ segundo);
        Buscas.pesquisaGrupos(primeiro,segundo);
    }
    private void pesquisaAluno(String entrada){
        System.out.println(entrada);
        Buscas.pesquisaAluno(entrada);
    }
}

