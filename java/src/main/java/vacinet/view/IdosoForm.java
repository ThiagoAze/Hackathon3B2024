package vacinet.view;

import vacinet.model.Idoso;
import vacinet.service.AgenteService;
import vacinet.service.IdosoService;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IdosoForm extends JFrame{
    private IdosoService service;
    private boolean permitirCadastro;
    private DateTimeFormatter formatter;
    private JLabel labelForm;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelCpf;
    private JFormattedTextField campoCpf;
    private JLabel labelDataNascimento;
    private JFormattedTextField campoDataNascimento;
    private JLabel labelFone;
    private JFormattedTextField campoFone;
    private String[] generos = {"Masculino", "Feminino", "Prefiro não informar"};
    private JLabel labelGenero;
    private JComboBox boxGenero;
    private JLabel labelEmail;
    private JTextField campoEmail;

    private JLabel labelAcompanhante;
    private JCheckBox acompanhanteSim;
    private JCheckBox acompanhanteNao;
    private Boolean escolhaAcompanhante;
    private JLabel labelSenha;
    private JTextField campoSenha;
    private JLabel labelRegrasSenha;
    private JButton botaoCancelar;
    private JButton botaoCadastrar;

    public IdosoForm(Idoso idosoSalvo) throws ParseException {
        service = new IdosoService();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        setTitle("Cadastro Idoso");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(700, 650);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelForm = new JLabel("Cadastro do Idoso");
        constraints.gridx = 1;
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
        campoCpf.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoCpf, constraints);

        labelDataNascimento = new JLabel("Data de Nascimento:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelDataNascimento, constraints);

        campoDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
        campoDataNascimento.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoDataNascimento, constraints);

        labelFone = new JLabel("Telefone:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelFone, constraints);

        campoFone = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
        campoFone.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoFone, constraints);

        var x = new JFormattedTextField();

        labelGenero = new JLabel("Gênero:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelGenero, constraints);

        boxGenero = new JComboBox(generos);
        boxGenero.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(boxGenero, constraints);

        labelEmail = new JLabel("Email:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        painelEntrada.add(labelEmail, constraints);

        campoEmail = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 6;
        painelEntrada.add(campoEmail, constraints);

        labelAcompanhante = new JLabel("Precisa de acompanhante?");
        constraints.gridx = 0;
        constraints.gridy = 7;
        painelEntrada.add(labelAcompanhante, constraints);

        acompanhanteSim = new JCheckBox("Sim");
        constraints.gridx = 1;
        constraints.gridy = 7;
        painelEntrada.add(acompanhanteSim, constraints);

        acompanhanteNao = new JCheckBox("Não");
        constraints.gridx = 2;
        constraints.gridy = 7;
        painelEntrada.add(acompanhanteNao, constraints);

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

        validarCheckBox();

        validarIdoso(idosoSalvo);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);
        setLocationRelativeTo(null);

    }

    private void validarIdoso(Idoso idoso) {
        if (idoso != null) {

            campoNome.setText(idoso.getNome());
            campoCpf.setText(idoso.getCpf());

            if (idoso.getGenero() == "M") boxGenero.setSelectedIndex(0);
            if (idoso.getGenero() == "F") boxGenero.setSelectedIndex(1);
            if (idoso.getGenero() == "NI") boxGenero.setSelectedIndex(2);
            var dataNascimento = idoso.getDataNascimento().toString();
            campoDataNascimento.setText(idoso.getDataNascimento().toString());
            campoDataNascimento.setText(dataNascimento.substring(5, 7) + "/" + dataNascimento.substring(8, 10) + "/" + dataNascimento.substring(0, 4));

            if (idoso.isAcompanhante()) {
                acompanhanteSim.setSelected(true);
            } else {
                acompanhanteNao.setSelected(true);
            }
            campoFone.setText(idoso.getFone());
            campoEmail.setText(idoso.getEmail());
            campoSenha.setText(idoso.getSenha());
        }
    }

    private void validarStrings(String valor, String CAMPO) {
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
            if (valor != 11) throw new RuntimeException("O campo cpf deve ter 11 caracteres");
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
            if (valor.isEmpty()) throw new RuntimeException("Campo %s não pode ser vazio".formatted(CAMPO));
            if (valor.isBlank()) throw new RuntimeException("Campo %s não pode ser espaço".formatted(CAMPO));
            var data = LocalDate.parse(valor, formatter);

            return data;
        } catch (RuntimeException re) {
            permitirCadastro = false;
            JOptionPane.showMessageDialog(this, "O campo data deve ser dia/mês/ano");
            return null;
        } catch (Exception e) {
            permitirCadastro = false;
            JOptionPane.showMessageDialog(this, "data inválida");
            return null;
        }
    }

    public String formatarNumeros(String valor) {
        var valorFormatado = valor.replaceAll("[^0-9]", "");

        return valorFormatado;
    }

    public String formatarGenero(Integer generoEscolhidoIndex) {
        if (generoEscolhidoIndex == 0) return "M";
        if (generoEscolhidoIndex == 1) return "F";
        if (generoEscolhidoIndex == 2) return "NI";
        return null;
    }

    public void validarAcompanhante() {
        try {
            if (!acompanhanteSim.isSelected() && !acompanhanteNao.isSelected()) throw new RuntimeException("Marque se você precisa de algum acompanhante para auxilia-lo");
        }catch (RuntimeException e) {
            permitirCadastro = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void cadastrar() {
        permitirCadastro = true;
        validarStrings(campoNome.getText(), "nome");
        validarStrings(campoCpf.getText(), "CPF");
        var cpfBanco = formatarNumeros(campoCpf.getText());
        validarCpf(cpfBanco.length());
        var generoEscolhido = formatarGenero(boxGenero.getSelectedIndex());

        var dataBanco = validacaoData(campoDataNascimento.getText(), "data de nascimento");
        validarStrings(campoEmail.getText(), "email");
        validarStrings(campoFone.getText(), "telefone");
        var foneBanco = formatarNumeros(campoFone.getText());
        validarStrings(campoSenha.getText(), "senha");
        validarSenha(campoSenha.getText());

        validarAcompanhante();
        if (permitirCadastro) {

            JOptionPane.showMessageDialog(this, "Mandando para outra tela");
            Idoso idoso = new Idoso(campoNome.getText(), cpfBanco, Date.valueOf(LocalDate.parse(campoDataNascimento.getText(), formatter)), foneBanco, campoEmail.getText(), campoSenha.getText(), generoEscolhido, escolhaAcompanhante);

            if (escolhaAcompanhante) {
                setVisible(false);
                AcompanhanteForm form = null;
                try {
                    form = new AcompanhanteForm(idoso);
                    form.setVisible(true);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                setVisible(false);
                HistoricoSaudeView form = null;

                service.salvar(idoso);
                System.out.println(idoso);
                idoso.setId(service.listarLogin(idoso.getCpf(), idoso.getSenha()).getId());
                form = new HistoricoSaudeView(idoso);
                form.setVisible(true);

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

    private void validarCheckBox(){
        acompanhanteSim.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    acompanhanteNao.setSelected(false);
                    escolhaAcompanhante = true;

                } else {
                    acompanhanteNao.setSelected(true);
                    escolhaAcompanhante = false;

                }
            }
        });

        acompanhanteNao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    acompanhanteSim.setSelected(false);
                    escolhaAcompanhante = false;
                } else {
                    acompanhanteSim.setSelected(true);
                    escolhaAcompanhante = true;

                }
            }
        });
    }
}
