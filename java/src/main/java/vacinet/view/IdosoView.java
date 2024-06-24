package vacinet.view;

import vacinet.model.Idoso;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class IdosoView extends JFrame {
    private JPanel painelEntrada;
    private JMenuBar menuBar;
    private JButton botãoirAviso;
    private JButton botãoirHistoricoSaude;
    private JButton botãoirVacinacao;
    private JLabel labelView;
    private JLabel labelNome;
    private JTextField campoNome;
    private CardLayout cardLayout;
    private Idoso idosoSalvo;
    public IdosoView(Idoso idoso) {
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

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        //getContentPane().add(painelSaida, BorderLayout.CENTER);
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public JPanel criarMenu() {
        JPanel painelMenu = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        menuBar = new JMenuBar();
        botãoirAviso = new JButton("Aviso");
        botãoirAviso.addActionListener(e -> irAviso());
        botãoirHistoricoSaude = new JButton("Histórico de saúde");
        botãoirHistoricoSaude.addActionListener(e -> irHistoricoSaude());
        botãoirVacinacao = new JButton("Vacinação");
        botãoirVacinacao.addActionListener(e -> {
            try {
                irVacinacao();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });

        menuBar.add(botãoirAviso);
        menuBar.add(botãoirHistoricoSaude);
        menuBar.add(botãoirVacinacao);
        setJMenuBar(menuBar);

        labelView = new JLabel("Dados do Paciente");
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelMenu.add(labelView, constraints);

        labelNome = new JLabel("Nome Completo:");
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

    public void limparCampos() {
    }
}
