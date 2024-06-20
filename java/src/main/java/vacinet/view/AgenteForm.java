package vacinet.view;

import vacinet.service.AgenteService;

import javax.swing.*;
import java.awt.*;

public class AgenteForm extends JFrame {
    AgenteService service;
    private JLabel labelForm;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelCpf;
    private JTextField campoCpf;
    private JLabel labelDataNascimento;
    private JTextField campoDataNascimento;
    private JLabel labelFone;
    private JTextField campoFone;
    private JLabel labelEmail;
    private JTextField campoEmail;
    private JLabel labelSenha;
    private JTextField campoSenha;
    private JLabel labelRegrasSenha;
    private JButton botaoCancelar;
    private JButton botaoCadastrar;

    public AgenteForm() {
        service = new AgenteService();

        setTitle("Diretor");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(700, 650);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelForm = new JLabel("Cadastro do agente de saúde");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelForm, constraints);

        labelNome = new JLabel("Nome Completo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        campoNome.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JTextField(20);
        campoCpf.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoCpf, constraints);

        labelDataNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelDataNascimento, constraints);

        campoDataNascimento = new JTextField(20);
        campoDataNascimento.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoDataNascimento, constraints);

        labelFone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelFone, constraints);

        campoFone = new JTextField(20);
        campoFone.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoFone, constraints);

        labelEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelEmail, constraints);

        campoEmail = new JTextField(20);
        campoEmail.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoEmail, constraints);

        labelSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(labelSenha, constraints);

        campoSenha = new JTextField(20);
        campoSenha.setEnabled(false);
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(campoSenha, constraints);

        labelRegrasSenha = new JLabel("A senha deve ter menos 8 caracteres");
        constraints.gridx = 1;
        constraints.gridy = 7;
        painelEntrada.add(labelRegrasSenha, constraints);

        botaoCancelar = new JButton("Cadastrar Agente de Saúde");
        botaoCancelar.addActionListener(e -> cancelar());
        constraints.gridx = 0;
        constraints.gridy = 8;
        painelEntrada.add(botaoCancelar, constraints);

        botaoCadastrar = new JButton("Cadastrar Agente de Saúde");
        botaoCadastrar.addActionListener(e -> cadastrar());
        constraints.gridx = 1;
        constraints.gridy = 8;
        painelEntrada.add(botaoCadastrar, constraints);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    private void cadastrar() {

    }

    private void cancelar() {
    }
}
