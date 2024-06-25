package vacinet.view;

import vacinet.model.Alergia;
import vacinet.model.Idoso;
import vacinet.model.ProblemaSaude;
import vacinet.service.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class HistoricoSaudeView extends JFrame {
    private AlergiaService serviceAlergia;
    private ProblemaSaudeService serviceProblemaSaude;
    private AgendaService serviceAgenda;
    private VacinaService serviceVacina;
    private AgenteService serviceAgente;
    private JTabbedPane painelTabbed;
    private JPanel painelEntrada;
    private JMenuBar menuBar;
    private JButton botaoirAviso;
    private JButton botaoirHistoricoSaude;
    private JButton botaoirVacinacao;
    private JPanel painelAlergia;
    private JLabel labelAlergia;
    private JButton botaoSalvarAlergia;
    private JButton botaoAdicionarAlergia;
    private Integer idAlergia;
    private JLabel labelNomeAlergia;
    private JTextField campoNomeAlergia;
    private JLabel labelObsAlergia;
    private JTextField campoObsAlergia;

    private JPanel painelHistoricoVacina;
    private JLabel labelHistoricoVacina;

    private JPanel painelProblemaSaude;
    private JLabel labelProblemaSaude;
    private JButton botaoSalvarProblemaSaude;
    private JButton botaoAdicionarProblemaSaude;
    private Integer idProblemaSaude;
    private JLabel labelNomeProblemaSaude;
    private JTextField campoNomeProblemaSaude;
    private JLabel labelObsProblemaSaude;
    private JTextField campoObsProblemaSaude;
    private JLabel labelView;
    private JLabel labelNome;
    private JTextField campoNome;
    private JTable tabelaProblemaSaude;
    private JTable tabelaAlergia;
    private CardLayout cardLayout;
    private Idoso idosoSalvo;

    public HistoricoSaudeView(Idoso idoso) {
        serviceAlergia = new AlergiaService();
        serviceProblemaSaude = new ProblemaSaudeService();
        serviceAgenda = new AgendaService();
        serviceVacina = new VacinaService();
        serviceAgente = new AgenteService();

        idosoSalvo = idoso;
        setTitle("Menu do Usuário");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        painelEntrada = new JPanel(new GridBagLayout());
        cardLayout = new CardLayout();
        painelEntrada.setLayout(cardLayout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        painelEntrada.add(criarMenu());
        JPanel painelSaida = new JPanel(new BorderLayout());

        painelTabbed = new JTabbedPane();

        itemAlergia();
        itemProblemaSaude();
        itemHistoricoVacina();

        painelTabbed.addTab("Alergias", painelAlergia);
        painelTabbed.addTab("Problemas de Saúde", painelProblemaSaude);
        painelTabbed.addTab("Histórico de vacinas", painelHistoricoVacina);

        painelSaida.add(painelTabbed);


        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private JPanel itemHistoricoVacina() {
        painelHistoricoVacina = new JPanel();
        painelHistoricoVacina.setLayout(new BoxLayout(painelHistoricoVacina, BoxLayout.Y_AXIS));

        labelHistoricoVacina = new JLabel("Confira suas últimas vacinas tomadas");
        labelHistoricoVacina.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelHistoricoVacina.setFont(new Font("titulo", 1, 20));
        labelHistoricoVacina.setPreferredSize(new Dimension(70, 60));
        labelHistoricoVacina.setMaximumSize(new Dimension(500, 60));

        painelHistoricoVacina.add(labelHistoricoVacina);

        JTable tabelaHistoricoVacina = new JTable();
        tabelaHistoricoVacina.setModel(carregarDadosHistoricoVacina());
        tabelaHistoricoVacina.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaHistoricoVacina);

        painelHistoricoVacina.add(scrollPane);

        return painelHistoricoVacina;
    }

    private TableModel carregarDadosHistoricoVacina() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Doenças");
        model.addColumn("Data");
        model.addColumn("Hora");
        model.addColumn("Agente");

        serviceAgenda.listarIdoso(idosoSalvo).forEach(agenda ->
                model.addRow(new Object[]{
                        serviceVacina.listarId(agenda.getIdVacina()).get(0).getNome(),
                        serviceVacina.listarId(agenda.getIdVacina()).get(0).getDoenca(),
                        agenda.getData(),
                        agenda.getHora(),
                        serviceAgente.listaId(agenda.getIdAgente()).get(0).getNome()
                })
        );

        return model;
    }

    private JPanel itemProblemaSaude() {
        painelProblemaSaude = new JPanel();
        painelProblemaSaude.setLayout(new BoxLayout(painelProblemaSaude, BoxLayout.Y_AXIS));

        labelProblemaSaude = new JLabel("Adicione problemas de saúde que o idoso possui");
        labelProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelProblemaSaude.setFont(new Font("titulo", 1, 20));
        labelProblemaSaude.setPreferredSize(new Dimension(70, 60));
        labelProblemaSaude.setMaximumSize(new Dimension(500, 60));

        painelProblemaSaude.add(labelProblemaSaude);

        botaoAdicionarProblemaSaude = new JButton("Adicionar");
        botaoAdicionarProblemaSaude.addActionListener(e -> limparCamposProblemaSaude());
        botaoAdicionarProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelProblemaSaude.add(botaoAdicionarProblemaSaude);

        JPanel painelNomeProblemaSaude = new JPanel(new FlowLayout());

        labelNomeProblemaSaude = new JLabel("Problema de Saude:");
        labelNomeProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelNomeProblemaSaude.add(labelNomeProblemaSaude);

        campoNomeProblemaSaude = new JTextField(20);
        campoNomeProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNomeProblemaSaude.setPreferredSize(new Dimension(225, 20));

        painelNomeProblemaSaude.add(campoNomeProblemaSaude);
        painelNomeProblemaSaude.setMaximumSize(new Dimension(400, 50));

        painelProblemaSaude.add(painelNomeProblemaSaude);

        JPanel painelObsProblemaSaude = new JPanel(new FlowLayout());


        labelObsProblemaSaude = new JLabel("Observação:");
        labelObsProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelObsProblemaSaude.add(labelObsProblemaSaude);

        campoObsProblemaSaude = new JTextField(20);
        campoObsProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoObsProblemaSaude.setPreferredSize(new Dimension(225, 20));

        painelObsProblemaSaude.add(campoObsProblemaSaude);
        painelObsProblemaSaude.setMaximumSize(new Dimension(400, 50));

        painelProblemaSaude.add(painelObsProblemaSaude);

        botaoSalvarProblemaSaude = new JButton("Salvar");
        botaoSalvarProblemaSaude.addActionListener(e -> executarSalvarProblemaSaude());
        botaoSalvarProblemaSaude.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelProblemaSaude.add(botaoSalvarProblemaSaude);


        tabelaProblemaSaude = new JTable();
        tabelaProblemaSaude.setModel(carregarDadosProblemaSaude());
        tabelaProblemaSaude.getSelectionModel().addListSelectionListener(e -> selecionarProblemaSaude(e));
        tabelaProblemaSaude.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaProblemaSaude);

        painelProblemaSaude.add(scrollPane);

        return painelProblemaSaude;
    }

    private TableModel carregarDadosProblemaSaude() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Observação");
        model.addColumn("Editar");
        model.addColumn("Excluir");

        serviceProblemaSaude.listarTodos(idosoSalvo.getId()).forEach(problemaSaude ->
                model.addRow(new Object[]{
                        problemaSaude.getId(),
                        problemaSaude.getNome(),
                        problemaSaude.getObs(),
                        "Editar",
                        "Excluir"
                })
        );

        return model;
    }

    private void executarSalvarProblemaSaude() {
        try {
            if (campoNomeProblemaSaude.getText().isEmpty()) throw new RuntimeException("Campo nome não pode ser vazio");
            if (campoNomeProblemaSaude.getText().isBlank()) throw new RuntimeException("Campo nome não pode ser espaço");

            if (campoObsProblemaSaude.getText().isEmpty()) throw new RuntimeException("Campo observação não pode ser vazio");
            if (campoObsProblemaSaude.getText().isBlank()) throw new RuntimeException("Campo observação não pode ser espaço");

            serviceProblemaSaude.salvar(
                    new ProblemaSaude(idProblemaSaude, idosoSalvo.getId(), campoNomeProblemaSaude.getText(), campoObsProblemaSaude.getText())
            );
            limparCamposProblemaSaude();
            tabelaProblemaSaude.setModel(carregarDadosProblemaSaude());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void selecionarProblemaSaude(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaProblemaSaude.getSelectedRow();
            int selectedCol = tabelaProblemaSaude.getSelectedColumn();
            if (selectedRow != -1) {

                idProblemaSaude = (Integer) tabelaProblemaSaude.getValueAt(selectedRow, 0);
                var nomeAlergia = (String) tabelaProblemaSaude.getValueAt(selectedRow, 1);
                var obsAlergia = (String) tabelaProblemaSaude.getValueAt(selectedRow, 2);

                if (selectedCol == 3) {
                    campoNomeProblemaSaude.setText(nomeAlergia);
                    campoObsProblemaSaude.setText(obsAlergia);


                } else if (selectedCol == 4) {
                    serviceProblemaSaude.deletar(new ProblemaSaude(idProblemaSaude, idosoSalvo.getId(), nomeAlergia, obsAlergia));
                    tabelaProblemaSaude.setModel(carregarDadosProblemaSaude());
                } else {
                    tabelaProblemaSaude.setModel(carregarDadosProblemaSaude());
                }
            }
        }
    }

    private JPanel itemAlergia() {
        painelAlergia = new JPanel();
        painelAlergia.setLayout(new BoxLayout(painelAlergia, BoxLayout.Y_AXIS));

        labelAlergia = new JLabel("Adicione alergias que o idoso possui");
        labelAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelAlergia.setFont(new Font("titulo", 1, 20));
        labelAlergia.setPreferredSize(new Dimension(70, 60));
        labelAlergia.setMaximumSize(new Dimension(500, 60));

        painelAlergia.add(labelAlergia);

        JPanel painelNomeAlergia = new JPanel(new FlowLayout());

        labelNomeAlergia = new JLabel("Alergia:");
        labelNomeAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);

        botaoAdicionarAlergia = new JButton("Adicionar");
        botaoAdicionarAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoAdicionarAlergia.addActionListener(e -> limparCamposAlergia());
        painelAlergia.add(botaoAdicionarAlergia);

        painelNomeAlergia.add(labelNomeAlergia);

        campoNomeAlergia = new JTextField(20);
        campoNomeAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNomeAlergia.setMaximumSize(new Dimension(400, 20));

        painelNomeAlergia.setMaximumSize(new Dimension(400, 50));

        painelNomeAlergia.add(campoNomeAlergia);

        painelAlergia.add(painelNomeAlergia);

        JPanel painelObsAlergia = new JPanel(new FlowLayout());


        labelObsAlergia = new JLabel("Observação:");
        labelObsAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelObsAlergia.add(labelObsAlergia);

        campoObsAlergia = new JTextField(20);
        campoObsAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelObsAlergia.setMaximumSize(new Dimension(400, 50));

        painelObsAlergia.add(campoObsAlergia);

        painelAlergia.add(painelObsAlergia);

        botaoSalvarAlergia = new JButton("Salvar");
        botaoSalvarAlergia.addActionListener(e -> executarSalvarAlergia());
        botaoSalvarAlergia.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelAlergia.add(botaoSalvarAlergia);


        tabelaAlergia = new JTable();
        tabelaAlergia.setModel(carregarDadosAlergia());
        tabelaAlergia.getSelectionModel().addListSelectionListener(e -> selecionarAlergia(e));
        tabelaAlergia.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaAlergia);

        painelAlergia.add(scrollPane);

        return painelAlergia;
    }


    private void executarSalvarAlergia() {
        try {
            if (campoNomeAlergia.getText().isEmpty()) throw new RuntimeException("Campo nome não pode ser vazio");
            if (campoNomeAlergia.getText().isBlank()) throw new RuntimeException("Campo nome não pode ser espaço");

            if (campoObsAlergia.getText().isEmpty()) throw new RuntimeException("Campo observação não pode ser vazio");
            if (campoObsAlergia.getText().isBlank()) throw new RuntimeException("Campo observação não pode ser espaço");

            serviceAlergia.salvar(
                    new Alergia(idAlergia, idosoSalvo.getId(), campoNomeAlergia.getText(), campoObsAlergia.getText())
            );
            limparCamposAlergia();

            tabelaAlergia.setModel(carregarDadosAlergia());
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    private void selecionarAlergia(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaAlergia.getSelectedRow();
            int selectedCol = tabelaAlergia.getSelectedColumn();
            if (selectedRow != -1) {
                idAlergia = (Integer) tabelaAlergia.getValueAt(selectedRow, 0);
                var nomeAlergia = (String) tabelaAlergia.getValueAt(selectedRow, 1);
                var obsAlergia = (String) tabelaAlergia.getValueAt(selectedRow, 2);


                if (selectedCol == 3) {
                    campoNomeAlergia.setText(nomeAlergia);
                    campoObsAlergia.setText(obsAlergia);
                    tabelaAlergia.setModel(carregarDadosAlergia());
                } else if (selectedCol == 4) {
                    serviceAlergia.deletar(new Alergia(idAlergia, idosoSalvo.getId(), nomeAlergia, obsAlergia));
                    tabelaAlergia.setModel(carregarDadosAlergia());
                } else {
                    tabelaAlergia.setModel(carregarDadosAlergia());
                }
            }
        }
    }

    private TableModel carregarDadosAlergia() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nome");
        model.addColumn("Observaçao");
        model.addColumn("Editar");
        model.addColumn("Excluir");

        serviceAlergia.listarTodos(idosoSalvo.getId()).forEach(alergia ->
                model.addRow(new Object[]{
                        alergia.getId(),
                        alergia.getNome(),
                        alergia.getObs(),
                        "Editar",
                        "Excluir"
                })
        );

        return model;
    }


    public JPanel criarMenu() {
        JPanel painelMenu = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        menuBar = new JMenuBar();
        botaoirAviso = new JButton("Aviso");
        botaoirAviso.addActionListener(e -> irAviso());
        botaoirHistoricoSaude = new JButton("Histórico de saúde");
        botaoirHistoricoSaude.addActionListener(e -> irHistoricoSaude());
        botaoirVacinacao = new JButton("Vacinação");
        botaoirVacinacao.addActionListener(e -> {
            try {
                irVacinacao();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuBar.add(botaoirAviso);
        menuBar.add(botaoirHistoricoSaude);
        menuBar.add(botaoirVacinacao);
        setJMenuBar(menuBar);

        labelView = new JLabel("Dados do Paciente");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelMenu.add(labelView, constraints);
        labelView.setFont(new Font("titulo", 1, 15));

        labelNome = new JLabel("Nome Completo:");
        labelNome.setFont(new Font("titulo", 0, 15));
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelMenu.add(labelNome, constraints);

        campoNome = new JTextField(40);
        campoNome.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelMenu.add(campoNome, constraints);

        return painelMenu;
    }

    private void irVacinacao() throws ParseException {
        setVisible(false);
        VacinaView form = new VacinaView(idosoSalvo);
        form.setVisible(true);
    }

    private void irHistoricoSaude() {
        setVisible(false);
        HistoricoSaudeView form = new HistoricoSaudeView(idosoSalvo);
        form.setVisible(true);
    }

    public void irAviso() {
        setVisible(false);
        AvisoView form = new AvisoView(idosoSalvo);
        form.setVisible(true);
    }

    public void limparCamposProblemaSaude() {
        idProblemaSaude = null;
        campoNomeProblemaSaude.setText("");
        campoObsProblemaSaude.setText("");
    }

    public void limparCamposAlergia() {
        idAlergia = null;
        campoNomeAlergia.setText("");
        campoObsAlergia.setText("");
    }
}
