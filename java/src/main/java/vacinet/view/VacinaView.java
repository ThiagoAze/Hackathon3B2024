package vacinet.view;

import vacinet.model.Agenda;
import vacinet.model.Agente;
import vacinet.model.Idoso;
import vacinet.model.Vacina;
import vacinet.service.AgendaService;
import vacinet.service.AgenteService;
import vacinet.service.VacinaService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class VacinaView extends JFrame {
    private JTable tabelaIndicacao;
    private JTable tabelaProximaVacina;
    private VacinaService serviceVacina;
    private AgendaService serviceAgenda;
    private AgenteService serviceAgente;
    private DateTimeFormatter formatter;
    private Integer idAgenda;
    private JPanel painelEntrada;
    private JTabbedPane painelTabbed;
    private JPanel painelProximaVacina;
    private JLabel labelProximaVacina;
    private JLabel labelDataProximaVacina;
    private JFormattedTextField campoDataProximaVacina;
    private JLabel labelHoraProximaVacina;
    private JFormattedTextField campoHoraProximaVacina;
    private JButton botaoAtualizarProximaVacina;
    private JPanel painelIndicacao;
    private JLabel labelIndicacao;
    private JMenuBar menuBar;
    private JButton botaoirAviso;
    private JButton botaoirHistoricoSaude;
    private JButton botaoirVacinacao;
    private JLabel labelView;
    private JLabel labelNome;
    private JTextField campoNome;
    private CardLayout cardLayout;
    private Idoso idosoSalvo;

    public VacinaView(Idoso idoso) throws ParseException {
        serviceVacina = new VacinaService();
        serviceAgenda = new AgendaService();
        serviceAgente = new AgenteService();

        idosoSalvo = idoso;
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        setTitle("Vacinação");
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

        itemProximaVacina();
        itemIndicacaoVacina();

        painelTabbed.addTab("Próximas vacinas", painelProximaVacina);
        painelTabbed.addTab("Indicações", painelIndicacao);

        painelSaida.add(painelTabbed);


        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void itemProximaVacina() throws ParseException {

        painelProximaVacina = new JPanel();
        painelProximaVacina.setLayout(new BoxLayout(painelProximaVacina, BoxLayout.Y_AXIS));

        labelProximaVacina = new JLabel("Os pedidos de alteração serão verificados por um agente\n" +
                " antes de serem alterados");
        labelProximaVacina.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelProximaVacina.setFont(new Font("titulo", 1, 15));
        labelProximaVacina.setPreferredSize(new Dimension(400, 50));

        painelProximaVacina.add(labelProximaVacina);

        JPanel painelData = new JPanel(new FlowLayout());

        labelDataProximaVacina = new JLabel("Data:");
        labelDataProximaVacina.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelData.add(labelDataProximaVacina);

        campoDataProximaVacina = new JFormattedTextField(new MaskFormatter("##/##/####"));
        campoDataProximaVacina.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoDataProximaVacina.setPreferredSize(new Dimension(225, 20));

        painelData.add(campoDataProximaVacina);
        painelData.setMaximumSize(new Dimension(400, 50));

        painelProximaVacina.add(painelData);

        JPanel painelHora = new JPanel(new FlowLayout());

        labelHoraProximaVacina = new JLabel("Hora:");
        labelHoraProximaVacina.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelHora.add(labelHoraProximaVacina);


        campoHoraProximaVacina = new JFormattedTextField(new MaskFormatter("##:##:00"));
        campoHoraProximaVacina.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoHoraProximaVacina.setPreferredSize(new Dimension(225, 20));
        campoHoraProximaVacina.setMaximumSize(new Dimension(80, 50));
        painelHora.add(campoHoraProximaVacina);
        painelProximaVacina.add(painelHora);
        
        botaoAtualizarProximaVacina = new JButton("Salvar");
        botaoAtualizarProximaVacina.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoAtualizarProximaVacina.addActionListener(e -> executarSalvarProximaVacina());
        botaoAtualizarProximaVacina.setMaximumSize(new Dimension(200, 20));

        painelProximaVacina.add(botaoAtualizarProximaVacina);

        tabelaProximaVacina = new JTable();
        tabelaProximaVacina.setModel(carregarDadosProximaVacina());
        tabelaProximaVacina.getSelectionModel().addListSelectionListener(e -> selecionarProximaVacina(e));
        tabelaProximaVacina.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaProximaVacina);

        painelProximaVacina.add(scrollPane);
    }

    private void itemIndicacaoVacina() throws ParseException {
        painelIndicacao = new JPanel();
        painelIndicacao.setLayout(new BoxLayout(painelIndicacao, BoxLayout.Y_AXIS));

        labelIndicacao = new JLabel("Clique em uma vacina para realizar o seu agendamento");
        labelIndicacao.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelIndicacao.setFont(new Font("titulo", 1, 15));
        labelIndicacao.setPreferredSize(new Dimension(400, 50));

        painelIndicacao.add(labelIndicacao);

        tabelaIndicacao = new JTable();
        tabelaIndicacao.setModel(carregarDadosIndicacao());
        tabelaIndicacao.getSelectionModel().addListSelectionListener(e -> selecionarIndicacao(e));
        tabelaIndicacao.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaIndicacao);

        painelIndicacao.add(scrollPane);
        
    }

    private TableModel carregarDadosIndicacao() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Vacina");
        model.addColumn("Doenças");
        model.addColumn("Data de Início");
        model.addColumn("Data Limite");
        model.addColumn("Observações");
        var dataHoje = LocalDate.now();
        var dataNascimento = idosoSalvo.getDataNascimento().toLocalDate();
        var idade = Period.between(dataNascimento, dataHoje).getYears();
        serviceVacina.listarIdade(idade).forEach(vacina ->
                model.addRow(new Object[]{
                        vacina.getId(),
                        vacina.getNome(),
                        vacina.getDoenca(),
                        vacina.getDataInicio(),
                        vacina.getDataLimite(),
                        vacina.getObs()
                })
        );

        return model;
    }

    private TableModel carregarDadosProximaVacina() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Data");
        model.addColumn("Hora estimada");
        model.addColumn("Vacina");
        model.addColumn("Nome do Agente");
        model.addColumn("Editar");
        model.addColumn("Excluir");
        var dataHoje = LocalDate.now();
        var dataNascimento = idosoSalvo.getDataNascimento().toLocalDate();
        var idade = Period.between(dataNascimento, dataHoje).getYears();

        serviceAgenda.listarProximaVacina(idosoSalvo.getId(), Date.valueOf(LocalDate.now())).forEach(agenda ->
                model.addRow(new Object[]{
                        agenda.getId(),
                        agenda.getData().toString(),
                        agenda.getHora(),
                        serviceVacina.listarId(agenda.getIdVacina()).get(0).getNome(),
                        serviceAgente.listaId(agenda.getIdAgente()).get(0).getNome(),
                        "Editar",
                        "Excluir"
                })
        );

        return model;
    }

    private void selecionarProximaVacina(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaProximaVacina.getSelectedRow();
            int selectedCol = tabelaProximaVacina.getSelectedColumn();
            if (selectedRow != -1) {

                var id = (Integer) tabelaProximaVacina.getValueAt(selectedRow, 0);
                var dataProximaVacina = (String) tabelaProximaVacina.getValueAt(selectedRow, 1);
                var horaProximaVacina = (String) tabelaProximaVacina.getValueAt(selectedRow, 2);

                if (selectedCol == 5) {
                    
                    idAgenda = id;
                    campoDataProximaVacina.setText(dataProximaVacina);
                    campoHoraProximaVacina.setText(horaProximaVacina);
                    serviceAgenda.salvar(serviceAgenda.listarId(id).get(0));
                    tabelaProximaVacina.setModel(carregarDadosProximaVacina());

                } else if (selectedCol == 6) {
                    serviceAgenda.listarId(id).get(0);
                    //serviceVacina.deletar(new Vacina(idAgenda, idosoSalvo.getId(), nomeAlergia, obsAlergia));
                    serviceAgenda.deletar(serviceAgenda.listarId(id).get(0));
                    tabelaProximaVacina.setModel(carregarDadosProximaVacina());
                    tabelaProximaVacina.setModel(carregarDadosProximaVacina());
                } else {
                    tabelaProximaVacina.setModel(carregarDadosProximaVacina());
                }
            }
        }
    }

    private void executarSalvarProximaVacina() {
    }

    private void selecionarIndicacao(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaIndicacao.getSelectedRow();
            if (selectedRow != -1) {

                var vacina = serviceVacina.listarId((Integer) tabelaIndicacao.getValueAt(selectedRow, 0)).get(0);
                System.out.println(vacina);
                VacinaForm form = null;
                try {
                    form = new VacinaForm(idosoSalvo, vacina);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                form.setVisible(true);

            }
        }
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
        //labelView.setPreferredSize(new Dimension(200, 20));
        labelView.setFont(new Font("titulo", 1, 15));
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelMenu.add(labelView, constraints);

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

    public void limparcampos() {

    }
}
