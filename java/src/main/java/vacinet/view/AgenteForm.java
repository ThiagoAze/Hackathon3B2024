package vacinet.view;

import vacinet.model.Agente;
import vacinet.service.AgenteService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AgenteForm extends JFrame {
    AgenteService service;

    private boolean permitirCadastro;
    private JLabel labelForm;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelCpf;
    private JFormattedTextField campoCpf;
    private JLabel labelDataNascimento;
    private JFormattedTextField campoDataNascimento;
    private JLabel labelFone;
    private JFormattedTextField campoFone;
    private JLabel labelEmail;
    private JTextField campoEmail;
    private JLabel labelSenha;
    private JTextField campoSenha;
    private JLabel labelRegrasSenha;
    private JButton botaoCancelar;
    private JButton botaoCadastrar;

    public AgenteForm() throws ParseException {
        service = new AgenteService();

        setTitle("Cadastro Agente");
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
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNome, constraints);

        labelCpf = new JLabel("CPF:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelCpf, constraints);

        campoCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoCpf, constraints);

        labelDataNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelDataNascimento, constraints);

        campoDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoDataNascimento, constraints);

        labelFone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelFone, constraints);

        campoFone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoFone, constraints);

        labelEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelEmail, constraints);

        campoEmail = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoEmail, constraints);

        labelSenha = new JLabel("Senha:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(labelSenha, constraints);

        campoSenha = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(campoSenha, constraints);

        labelRegrasSenha = new JLabel("A senha deve ter menos 8 caracteres");
        constraints.gridx = 1;
        constraints.gridy = 7;
        painelEntrada.add(labelRegrasSenha, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> cancelar());
        constraints.gridx = 0;
        constraints.gridy = 8;
        painelEntrada.add(botaoCancelar, constraints);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(e -> salvar());
        constraints.gridx = 1;
        constraints.gridy = 8;
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
            if (valor != 11) throw new RuntimeException("O campo cpf deve ter até 8 caracteres");
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

    private LocalDate validacaoData(String valor, String CAMPO){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (valor.isEmpty()) throw new RuntimeException("Campo %s não pode ser vazio".formatted(CAMPO));
            if (valor.isBlank()) throw new RuntimeException("Campo %s não pode ser espaço".formatted(CAMPO));
            var dataInicioCarreira = campoDataNascimento.getText();
            var data = LocalDate.parse(dataInicioCarreira, formatter);
            System.out.println(data);
            return data;
        } catch (RuntimeException re) {
            JOptionPane.showMessageDialog(this, re.getMessage());
            return null;
        }
    }

    public String formatarNumeros(String valor) {
        var valorFormatado = valor.replaceAll("[^0-9]", "");
        System.out.println(valorFormatado);

        return valor;
    }

    private void salvar() {
        permitirCadastro = true;
        validacaoStrings(campoNome.getText(), "nome");
        validacaoStrings(campoCpf.getText(), "CPF");
        var cpfBanco = formatarNumeros(campoCpf.getText());
        var dataBanco = validacaoData(campoDataNascimento.getText(), "data de nascimento");
        validacaoStrings(campoEmail.getText(), "email");
        validacaoStrings(campoFone.getText(), "fone");
        var foneBanco = formatarNumeros(campoFone.getText());
        validacaoStrings(campoSenha.getText(), "senha");
        validarSenha(campoSenha.getText());
        if (permitirCadastro) {
            JOptionPane.showMessageDialog(this, "cadastrado");
            try {
                var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                Agente agente = new Agente(campoNome.getText(), cpfBanco, Date.valueOf(LocalDate.parse(campoDataNascimento.getText(), formatter)), campoEmail.getText(), foneBanco, campoSenha.getText());
                agente.setId(0);
                setVisible(false);
                var form = new AgenteView(/*agente*/);
                form.setVisible(true);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void limparDados() {
        campoNome.setText("");
        campoCpf.setText("");
        campoDataNascimento.setText("");
        campoFone.setText("");
        campoEmail.setText("");
        campoSenha.setText("");
    }
    private void cancelar() {
        limparDados();
        setVisible(false);
        var form = new MenuForm();
        form.setVisible(true);
    }
}
