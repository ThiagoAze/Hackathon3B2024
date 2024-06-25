package vacinet.view;

import vacinet.model.Aviso;
import vacinet.model.Idoso;
import vacinet.service.AgendaService;
import vacinet.service.AgenteService;
import vacinet.service.AvisoService;
import vacinet.service.VacinaService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.text.ParseException;

public class AvisoView extends JFrame {
    private VacinaService serviceVacina;
    private AgendaService serviceAgenda;
    private AgenteService serviceAgente;
    private AvisoService serviceAviso;
    private JTabbedPane painelTabbed;
    private JPanel painelEntrada;
    private JMenuBar menuBar;
    private JButton botaoirAviso;
    private JButton botaoirHistoricoSaude;
    private JButton botaoirVacinacao;
    private JLabel labelView;
    private JLabel labelNome;
    private JTextField campoNome;
    private CardLayout cardLayout;
    private Idoso idosoSalvo;

    public AvisoView(Idoso idoso) {
        serviceVacina = new VacinaService();
        serviceAgenda = new AgendaService();
        serviceAgente = new AgenteService();
        serviceAviso = new AvisoService();

        idosoSalvo = idoso;
        setTitle("Avisos");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        painelEntrada = new JPanel(new GridBagLayout());
        cardLayout = new CardLayout();
        painelEntrada.setLayout(cardLayout);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        painelEntrada.add(criarMenu());
        JPanel painelSaida = new JPanel(new BorderLayout());

        painelSaida.add(criarAlerta());

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public JPanel criarAlerta() {
        JPanel painelAlerta = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JTable tabelaAlerta = new JTable();
        tabelaAlerta.setModel(carregarDadosAlerta());
        tabelaAlerta.getSelectionModel().addListSelectionListener(e -> selecionarAlerta(e));
        tabelaAlerta.setDefaultEditor(Object.class, null);
        tabelaAlerta.setFont(new Font("tabela", 0, 15));
        JScrollPane scrollPane = new JScrollPane(tabelaAlerta);
        tabelaAlerta.setPreferredScrollableViewportSize(new Dimension(1200, 500));
        painelAlerta.add(scrollPane);
        return painelAlerta;
    }

    private void selecionarAlerta(ListSelectionEvent e) {

    }


    private TableModel carregarDadosAlerta() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Título");
        model.addColumn("Descrição");
        serviceAviso.listarIdIdoso(idosoSalvo.getId()).forEach(aviso ->
                model.addRow(new Object[]{
                        aviso.getNome(),
                        aviso.getDescricao()
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
        campoNome.setText(idosoSalvo.getNome());
        campoNome.setEnabled(false);
        campoNome.setFont(new Font("titulo", 1, 15));
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

    public void limparCampos() {

    }
}
