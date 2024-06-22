package vacinet.view;

import vacinet.model.Acompanhante;
import vacinet.model.Idoso;
import vacinet.service.AcompanhanteService;
import vacinet.service.IdosoService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class AcompanhanteForm extends JFrame {
    AcompanhanteService serviceAcompanhante;
    IdosoService serviceIdoso;
    private boolean permitirCadastro;
    private JLabel labelForm;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelCpf;
    private JFormattedTextField campoCpf;
    private JLabel labelFone;
    private JFormattedTextField campoFone;
    private JLabel labelEmail;
    private JTextField campoEmail;
    private JTextField campoSenha;
    private JLabel labelSenha;
    private JLabel labelRegrasSenha;
    private JButton botaoCancelar;
    private JButton botaoCadastrar;
    private Idoso idosoSalvo;

    public AcompanhanteForm(Idoso idoso) throws ParseException {
        serviceAcompanhante = new AcompanhanteService();
        serviceIdoso = new IdosoService();
        idosoSalvo = idoso;
        setTitle("Cadastro Agente");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(700, 650);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelForm = new JLabel("Cadastro do Idoso");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelForm, constraints);

        labelNome = new JLabel("Nome Completo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNome, constraints);

        campoNome = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        campoCpf.setSize(10, 5);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoCpf, constraints);

        labelFone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelFone, constraints);

        campoFone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
        campoFone.setSize(10, 5);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoFone, constraints);

        labelEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelEmail, constraints);

        campoEmail = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoEmail, constraints);

        labelSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 8;
        painelEntrada.add(labelSenha, constraints);

        campoSenha = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 8;
        painelEntrada.add(campoSenha, constraints);

        labelRegrasSenha = new JLabel("A senha deve ter menos 8 caracteres");
        constraints.gridx = 1;
        constraints.gridy = 9;
        painelEntrada.add(labelRegrasSenha, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> cancelar());
        constraints.gridx = 0;
        constraints.gridy = 10;
        painelEntrada.add(botaoCancelar, constraints);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(e -> cadastrar());
        constraints.gridx = 1;
        constraints.gridy = 10;
        painelEntrada.add(botaoCadastrar, constraints);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

    private void validacaoStrings(String valor, String CAMPO) {
        try {
            if (valor.isEmpty()) throw new RuntimeException("Campo %s não pode ser vazio".formatted(CAMPO));
            if (valor.isBlank()) throw new RuntimeException("Campo %s não pode ser espaço".formatted(CAMPO));

        }catch (RuntimeException e){
            permitirCadastro = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void validarCpf(int valor) {
        try {
            if (valor != 11) throw new RuntimeException("O campo cpf deve ter até 11 caracteres");
        } catch (Exception e){
            permitirCadastro = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void validarSenha(String valor) {
        try {
            var tamanhovalor = valor.length();
            if (tamanhovalor < 8) throw new RuntimeException("O campo senha deve ter pelo menos 8 caracteres");
        } catch (Exception e){
            permitirCadastro = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public String formatarNumeros(String valor) {
        var valorFormatado = valor.replaceAll("[^0-9]", "");
        System.out.println(valorFormatado);

        return valorFormatado;
    }

    private void cadastrar() {
        permitirCadastro = true;
        validacaoStrings(campoNome.getText(), "nome");
        validacaoStrings(campoCpf.getText(), "CPF");
        var cpfBanco = formatarNumeros(campoCpf.getText());
        validarCpf(cpfBanco.length());
        validacaoStrings(campoEmail.getText(), "email");
        validacaoStrings(campoFone.getText(), "telefone");
        var foneBanco = formatarNumeros(campoFone.getText());
        validacaoStrings(campoSenha.getText(), "senha");
        validarSenha(campoSenha.getText());
        if (permitirCadastro) {
            JOptionPane.showMessageDialog(this, "Mandando para outra tela");
            Acompanhante acompanhante = new Acompanhante(idosoSalvo.getId(), campoNome.getText(), cpfBanco, foneBanco, campoEmail.getText(), campoSenha.getText());

        }
    }

    private void cancelar() {
        setVisible(false);
        IdosoForm form = null;
        try {
            form = new IdosoForm(idosoSalvo);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        form.setVisible(true);
    }
}
