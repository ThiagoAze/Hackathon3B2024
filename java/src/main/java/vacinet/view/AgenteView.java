package vacinet.view;

import vacinet.model.Agenda;
import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;
import vacinet.service.AgendaService;
import vacinet.service.AgenteService;
import vacinet.service.DiaDisponivelService;
import vacinet.service.IdosoService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AgenteView extends JFrame {
    private AgendaService serviceAgenda;
    private DiaDisponivelService serviceDiaDisponivel;
    private AgenteService serviceAgente;
    private IdosoService serviceIdoso;
    private JButton botaoCadastrarDiaDisponivel;
    private JButton botaoAdicionarDiaDisponivel;
    
    private JButton botaoCadastrarAgenda;
    private Integer idDiaData;
    private Integer idAgenda;
    private Integer idIdoso;
    private Idoso idoso;
    private JLabel labelView;
    private JLabel labelPainel;
    private JLabel labelNome;
    private JTextField campoNome;
    private JTabbedPane painelTabbed;
    private JPanel painelDiasDisponiveis;
    private JTable tabelaDiasDisponiveis;
    private JTable tabelaAgenda;
    private JLabel labelDataDiaDisponivel;
    private JFormattedTextField campoDataDiaDisponivel;
    private JLabel labelPeriodoManha;
    private JCheckBox periodoManhaSim;
    private JCheckBox periodoManhaNao;
    private Boolean escolhaPeriodoManha;
    private JLabel labelPeriodoTarde;
    private JCheckBox periodoTardeSim;
    private JCheckBox periodoTardeNao;
    private Boolean escolhaPeriodoTarde;
    private JLabel labelQuantVisita;
    private JTextField campoQuantVisita;
    private JPanel painelAgenda;
    private JLabel labelNomeIdoso;
    private JTextField campoNomeIdoso;
    private JLabel labelCidade;
    private JLabel labelRua;
    private JLabel labelNumero;
    private JLabel labelComplemento;
    private JLabel labelDataAgenda;
    private JFormattedTextField campoDataAgenda;
    private JLabel labelHora;
    private JFormattedTextField campoHora;

    private Agente agente;
    private DateTimeFormatter formatter;
    public AgenteView(Agente agenteCadastrado) throws ParseException {
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        agente = agenteCadastrado;
        serviceAgenda = new AgendaService();
        serviceAgente = new AgenteService();
        serviceDiaDisponivel = new DiaDisponivelService();

        setTitle("Menu do Agente");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelView = new JLabel("Dados do agente de saúde");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(labelView, constraints);

        labelNome = new JLabel("Nome Completo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);


        campoNome = new JTextField(40);
        campoNome.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        JPanel painelSaida = new JPanel(new BorderLayout());

        painelTabbed = new JTabbedPane();

        itemTabDiasDisponiveis();

        itemTabAgenda();

        painelTabbed.addTab("Dias Disponíveis", painelDiasDisponiveis);
        painelTabbed.addTab("Agenda", painelAgenda);

        painelSaida.add(painelTabbed);


        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        formatarCheckBox();

    }

    public void itemTabDiasDisponiveis() throws ParseException {

        painelDiasDisponiveis = new JPanel();
        painelDiasDisponiveis.setLayout(new BoxLayout(painelDiasDisponiveis, BoxLayout.Y_AXIS));

        botaoAdicionarDiaDisponivel = new JButton("Criar Campo");
        botaoAdicionarDiaDisponivel.addActionListener(e -> limparCampos());
        painelDiasDisponiveis.add(botaoAdicionarDiaDisponivel);

        JPanel painelData = new JPanel(new FlowLayout());

        labelDataDiaDisponivel = new JLabel("Data:");
        labelDataDiaDisponivel.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelData.add(labelDataDiaDisponivel);

        campoDataDiaDisponivel = new JFormattedTextField(new MaskFormatter("##/##/####"));
        campoDataDiaDisponivel.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoDataDiaDisponivel.setMaximumSize(new Dimension(400, 20));

        painelData.setMaximumSize(new Dimension(400, 50));

        painelData.add(campoDataDiaDisponivel);

        painelDiasDisponiveis.add(painelData);

        JPanel painelPeriodoManha = new JPanel(new FlowLayout());

        labelPeriodoManha = new JLabel("Atenderá no período da manhã?");
        labelPeriodoManha.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPeriodoManha.add(labelPeriodoManha);

        periodoManhaSim = new JCheckBox("Sim");
        periodoManhaSim.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPeriodoManha.add(periodoManhaSim);

        periodoManhaNao = new JCheckBox("Não");
        periodoManhaNao.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPeriodoManha.add(periodoManhaNao);

        painelPeriodoManha.setMaximumSize(new Dimension(400, 50));

        painelDiasDisponiveis.add(painelPeriodoManha);

        JPanel painelPeriodoTarde = new JPanel(new FlowLayout());

        labelPeriodoTarde = new JLabel("Atenderá no período da tarde?");
        labelPeriodoTarde.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPeriodoTarde.add(labelPeriodoTarde);

        periodoTardeSim = new JCheckBox("Sim");
        periodoTardeSim.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPeriodoTarde.add(periodoTardeSim);

        periodoTardeNao = new JCheckBox("Não");
        periodoTardeNao.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelPeriodoTarde.add(periodoTardeNao);

        painelPeriodoTarde.setMaximumSize(new Dimension(400, 50));

        painelDiasDisponiveis.add(painelPeriodoTarde);

        JPanel painelQuantVisita = new JPanel(new FlowLayout());

        labelQuantVisita = new JLabel("Visita máximos que serão atendidos:");
        labelQuantVisita.setMaximumSize(new Dimension(400, 20));
        labelQuantVisita.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelQuantVisita.add(labelQuantVisita);

        campoQuantVisita = new JTextField(20);
        campoQuantVisita.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelQuantVisita.setMaximumSize(new Dimension(400, 20));
        painelQuantVisita.add(campoQuantVisita);

        painelQuantVisita.setMaximumSize(new Dimension(500, 50));

        painelDiasDisponiveis.add(painelQuantVisita);

        botaoCadastrarDiaDisponivel = new JButton("Salvar");
        botaoCadastrarDiaDisponivel.addActionListener(e -> executarSalvarDiaDisponivel());
        painelDiasDisponiveis.add(botaoCadastrarDiaDisponivel);

        JTable tabelaDias = new JTable();
        //tabelaDias.set
        tabelaDias.setModel(carregarDadosDiaDisponivel());
        tabelaDias.getSelectionModel().addListSelectionListener(e -> selecionarDia(e));
        tabelaDias.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaDias);

        painelDiasDisponiveis.add(scrollPane);

    }

    public void itemTabAgenda() throws ParseException {
        painelAgenda = new JPanel();
        painelAgenda.setLayout(new BoxLayout(painelAgenda, BoxLayout.Y_AXIS));

        JPanel painelIdoso = new JPanel(new FlowLayout());


        JPanel painelData = new JPanel(new FlowLayout());

        labelDataAgenda = new JLabel("Data:");
        labelDataAgenda.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelData.add(labelDataAgenda);

        campoDataAgenda = new JFormattedTextField(new MaskFormatter("##/##/####"));
        campoDataAgenda.setAlignmentX(Component.CENTER_ALIGNMENT);

        campoDataAgenda.setMaximumSize(new Dimension(400, 20));

        painelData.setMaximumSize(new Dimension(400, 50));
        painelData.add(campoDataAgenda);
        painelAgenda.add(painelData);

        JPanel painelEndereco = new JPanel(new FlowLayout());

        labelHora = new JLabel("Hora: ");
        labelHora.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelEndereco.add(labelHora);
        campoHora = new JFormattedTextField(new MaskFormatter("##:##:00"));
        campoHora.setAlignmentX(Component.CENTER_ALIGNMENT);

        campoHora.setMaximumSize(new Dimension(400, 20));
        painelEndereco.add(campoHora);
        painelAgenda.add(painelEndereco);

        botaoCadastrarAgenda = new JButton("Salvar");
        botaoCadastrarAgenda.addActionListener(e -> executarSalvarDiaDisponivel());
        painelAgenda.add(botaoCadastrarAgenda);

        JTable tabelaDias = new JTable();

        tabelaAgenda.setModel(carregarAgenda());
        tabelaAgenda.getSelectionModel().addListSelectionListener(e -> selecionarAgenda(e));
        tabelaAgenda.setDefaultEditor(Object.class, null);


        JScrollPane scrollPane = new JScrollPane(tabelaAgenda);

        painelAgenda.add(scrollPane);
    }



    private DiaDisponivel construirDiaDisponivel(){

        if (campoDataDiaDisponivel.getText().isEmpty()) throw new RuntimeException("Campo data não pode ser vazio");
        if (campoDataDiaDisponivel.getText().isBlank()) throw new RuntimeException("Campo data não pode ser espaço");
        var dataInicioCarreira = campoDataDiaDisponivel.getText();
        var data = LocalDate.parse(dataInicioCarreira, formatter);

        if (campoQuantVisita.getText().isEmpty()) throw new RuntimeException("Campo quantidade de premiações não pode ser vazio");
        if (campoQuantVisita.getText().isBlank()) throw new RuntimeException("Campo quantidade de premiações não pode ser espaço");
        var quantVisitaValidada = Integer.parseInt(campoQuantVisita.getText());
        if (quantVisitaValidada < 0) throw new RuntimeException("Campo quantidade de premiações não pode ser menor que zero");

        System.out.println(idDiaData);

        return (idDiaData == null)
                ? new DiaDisponivel(agente.getId(), Date.valueOf(LocalDate.parse(campoDataDiaDisponivel.getText(), formatter)), escolhaPeriodoManha, escolhaPeriodoTarde, quantVisitaValidada)
                : new DiaDisponivel(idDiaData, agente.getId(), Date.valueOf(LocalDate.parse(campoDataDiaDisponivel.getText(), formatter)), escolhaPeriodoManha, escolhaPeriodoTarde, quantVisitaValidada);
    }
    private void executarSalvarDiaDisponivel() {
        try{
            serviceDiaDisponivel.salvar(construirDiaDisponivel());
            limparCampos();

            tabelaDiasDisponiveis.setModel(carregarDadosDiaDisponivel());
        } catch (NumberFormatException en) {
            JOptionPane.showMessageDialog(this,"A quantidade de premiações deve ser um número");
        } catch (DateTimeException ed){
            JOptionPane.showMessageDialog(this, "As datas devem estar no formato (dia/mes/ano)");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private Agenda construirAgenda() {
        if (campoDataAgenda.getText().isEmpty()) throw new RuntimeException("Campo data não pode ser vazio");
        if (campoDataAgenda.getText().isBlank()) throw new RuntimeException("Campo data não pode ser espaço");
        var dataInicioCarreira = campoDataAgenda.getText();
        var data = LocalDate.parse(dataInicioCarreira, formatter);

        if (campoHora.getText().isEmpty()) throw new RuntimeException("Campo hora não pode ser vazio");
        if (campoHora.getText().isBlank()) throw new RuntimeException("Campo hor não pode ser espaço");

        return (idAgenda != null)
                ? serviceAgenda.listarPorId(idAgenda)
                : null;
    }

    private void executarSalvarAgenda() {
        try{
            serviceAgenda.salvar(construirAgenda());
            limparCampos();

            tabelaAgenda.setModel(carregarDadosDiaDisponivel());
        } catch (NumberFormatException en) {
            JOptionPane.showMessageDialog(this,"A quantidade de premiações deve ser um número");
        } catch (DateTimeException ed){
            JOptionPane.showMessageDialog(this, "As datas devem estar no formato (dia/mes/ano)");
        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void limparCampos() {
        campoDataDiaDisponivel.setText("");
        campoQuantVisita.setText("");
    }

    private DefaultTableModel carregarDadosDiaDisponivel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Horário Periodo da Manhã");
        model.addColumn("Horário Periodo da Tarde");
        model.addColumn("Visita max.");
        model.addColumn("");
        model.addColumn("");

        serviceDiaDisponivel.listarDia(agente).forEach(diaDisponivel ->
                model.addRow(new Object[]{
                        diaDisponivel.getId(),
                        diaDisponivel.getData().toString(),
                        diaDisponivel.getPeriodoManha(),
                        diaDisponivel.getPeriodoTarde(),
                        diaDisponivel.getQuantVisita(),
                        "Editar",
                        "Excluir"
                        }
                )
        );

        return model;
    }

    private DefaultTableModel carregarAgenda() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Data");
        model.addColumn("Hora");
        model.addColumn("Nome idoso");
        model.addColumn("Rua");
        model.addColumn("Cidade");
        model.addColumn("Numero");
        model.addColumn("Complemento");
        model.addColumn("Vacina");
        model.addColumn("Complemento");
        model.addColumn("Status");

        serviceAgenda.listarTudo(agente.getId()).forEach(Agenda ->
                model.addRow(new Object[]{
                                Agenda.getData().toString(),
                                Agenda.getHora().toString(),
                                serviceIdoso.listarIdoso(Agenda.getIdIdoso()).get(0),
                                Agenda.getRua(),
                                Agenda.getCidade(),
                                Agenda.getNumero(),
                                Agenda.getComplemento(),
                                Agenda.getIdVacina(),
                                Agenda.getStatus(),
                                "Editar",
                                "Excluir"
                })
        );

        return model;
    }

    private void selecionarDia(ListSelectionEvent e){
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaDiasDisponiveis.getSelectedRow();
            if (selectedRow != -1) {
                idDiaData = (Integer) tabelaDiasDisponiveis.getValueAt(selectedRow, 0);

                var data = (Date) tabelaDiasDisponiveis.getValueAt(selectedRow, 1);
                campoDataDiaDisponivel.setText(data.toString());

                var periodoManha = (Boolean) tabelaDiasDisponiveis.getValueAt(selectedRow, 2);
                System.out.println(periodoManha);
                periodoTardeSim.setSelected(periodoManha);

                var periodoTarde = (Boolean) tabelaDiasDisponiveis.getValueAt(selectedRow, 3);
                System.out.println(periodoManha);
                periodoTardeSim.setSelected(periodoTarde);

                var quantVisita = (Integer) tabelaDiasDisponiveis.getValueAt(selectedRow, 4);
                campoQuantVisita.setText(data.toString());
            }
        }
    }

    private void selecionarAgenda(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaAgenda.getSelectedRow();
            if (selectedRow != -1) {
                idAgenda = (Integer) tabelaAgenda.getValueAt(selectedRow, 0);
                idIdoso = (Integer) tabelaAgenda.getValueAt(selectedRow, 1);
                idoso = serviceIdoso.listarIdoso(idIdoso).get(0);

                var data = (Date) tabelaAgenda.getValueAt(selectedRow, 2);
                campoDataAgenda.setText(data.toString());

                var horario = (Time) tabelaAgenda.getValueAt(selectedRow, 3);
                campoHora.setText(horario.toString());
            }
        }
    }

    public void formatarCheckBox() {
        periodoManhaSim.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    periodoManhaNao.setSelected(false);
                    escolhaPeriodoManha = true;
                } else {
                    periodoManhaNao.setSelected(true);
                    escolhaPeriodoManha = false;

                }
            }
        });

        periodoManhaNao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    periodoManhaSim.setSelected(false);
                    escolhaPeriodoManha = false;

                } else {
                    periodoManhaSim.setSelected(true);
                    escolhaPeriodoManha = true;

                }
            }
        });

        periodoTardeSim.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    periodoTardeNao.setSelected(false);
                    escolhaPeriodoTarde = true;

                } else {
                    periodoTardeNao.setSelected(true);
                    escolhaPeriodoTarde = false;

                }
            }
        });

        periodoTardeNao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    periodoTardeSim.setSelected(false);
                    escolhaPeriodoTarde = false;

                } else {
                    periodoTardeSim.setSelected(true);
                    escolhaPeriodoTarde = true;

                }
            }
        });
    }
}
