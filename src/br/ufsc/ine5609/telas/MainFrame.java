package br.ufsc.ine5609.telas;

import br.ufsc.ine5609.Aluno;
import br.ufsc.ine5609.Constantes;
import br.ufsc.ine5609.ControleBuscas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    private ControleBuscas controleBuscas;
    private JMenuBar menuBar;
    private JButton bt_voltar;
    private JScrollPane scroll;
    private JTable tabela;
    private JPanel painelBotao;
    private JButton bt_pesquisarGrupo;
    private JButton bt_pesquisarIndividuo;
    private final String[] colunas;

    public MainFrame(String[][] alunos) {

        super("Lista Alunos");
        colunas = new String[]{"Matrícula", "Nome", "Centro", "Curso", "Cotista?"};
        controleBuscas = ControleBuscas.getInstance();
        menuBar = new JMenuBar();

        bt_voltar = new JButton("Voltar");
        bt_pesquisarGrupo = new JButton("Fazer Pesquisa de um grupo");
        bt_pesquisarGrupo.addActionListener(new AcaoPesquisarGrupo());
        bt_pesquisarIndividuo = new JButton("Pesquisar por matrícula");
        bt_pesquisarIndividuo.addActionListener(new AcaoPesquisarIndividuo());

        menuBar.setLayout(new BorderLayout());
        menuBar.add(bt_voltar, BorderLayout.LINE_START);
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

            /*JPanel resultado = new JPanel();
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
            */
            JComboBox primeiro = new JComboBox();
            JComboBox segundo = new JComboBox();
            JComboBox terceiro = new JComboBox();

            primeiro.addItem("-"); // indica que esta opcao sera vazia
            segundo.addItem("-"); // indica que esta opcao sera vazia
            terceiro.addItem("-"); // indica que esta opcao sera vazia

            //opcoes para serem selecionadas
            terceiro.addItem(Constantes.SIM);
            terceiro.addItem(Constantes.NAO);
            for (String item: Constantes.TODOS_CURSOS)
                primeiro.addItem(item);
            for (String item: Constantes.TODOS_CENTROS)
                segundo.addItem(item);

            JPanel dialogPanel = new JPanel();
            dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
            dialogPanel.add(new JLabel("Curso"));
            dialogPanel.add(primeiro);
            dialogPanel.add(new JLabel("Centro"));
            dialogPanel.add(segundo);
            dialogPanel.add(new JLabel("Cotista?"));
            dialogPanel.add(terceiro);

            int result = JOptionPane.showConfirmDialog(null, dialogPanel,
                    "Insira os parametros para sua pesquisa", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION ) {
                pesquisaGrupos(
                        primeiro.getSelectedItem().toString(),
                        segundo.getSelectedItem().toString(),
                        terceiro.getSelectedItem().toString()
                );
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


    private void pesquisaGrupos(String primeiro, String segundo, String terceiro){
        if(primeiro != segundo && segundo != terceiro)
            controleBuscas.pesquisaGrupos(primeiro, segundo, terceiro);
        else
            JOptionPane.showMessageDialog(null,"Você não selecionou nenhum grupo para ser pesquisado");
    }
    private void pesquisaAluno(String entrada){
        if(! entrada.equals(""))
            controleBuscas.pesquisaAluno(entrada);
        else
            JOptionPane.showMessageDialog(null,"Você precisa inserir algo para ser pesquisado");
    }
}

