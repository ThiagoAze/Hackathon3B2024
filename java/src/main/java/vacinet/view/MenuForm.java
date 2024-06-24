package vacinet.view;

import vacinet.model.Agente;
import vacinet.model.Idoso;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;

public class MenuForm extends JFrame{
    private JButton botaoUsuario;
    private JButton botaoAgente;
    private JButton botaoAgenteSimulado;
    private JButton botaoUsuarioSimulado;
    private JLabel labelMenu;

    public MenuForm(){
        setTitle("Menu de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);




        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelMenu = new JLabel("Como gostaria de se cadastrar?");
        labelMenu.setFont(new Font("titulo", 1, 20));
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelMenu, constraints);

        botaoUsuario = new JButton("Usuário");
        botaoUsuario.setPreferredSize(new Dimension(215, 30));
        botaoUsuario.setFont(new Font("botao", 0, 15));

        botaoUsuario.addActionListener(e -> irFormIdoso());
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(botaoUsuario, constraints);

        botaoAgente = new JButton("Agente de Saúde");
        botaoAgente.setPreferredSize(new Dimension(215, 30));
        botaoAgente.setFont(new Font("botao", 0, 15));

        botaoAgente.addActionListener(e -> irFormAgente());
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(botaoAgente, constraints);

        botaoAgenteSimulado = new JButton("Agente de Saúde Simulado");
        botaoAgenteSimulado.setPreferredSize(new Dimension(215, 30));
        botaoAgenteSimulado.setFont(new Font("botao", 0, 15));

        botaoAgenteSimulado.addActionListener(e -> irAgenteView());
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(botaoAgenteSimulado, constraints);

        botaoUsuarioSimulado = new JButton("Usuário Simulado");
        botaoUsuarioSimulado.setPreferredSize(new Dimension(215, 30));
        botaoUsuarioSimulado.setFont(new Font("botao", 0, 15));

        botaoUsuarioSimulado.addActionListener(e -> irIdosoView());
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(botaoUsuarioSimulado, constraints);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);

        setLocationRelativeTo(null);

    }

    private void irIdosoView() {
        setVisible(false);
        IdosoView form = null;

        form = new IdosoView(new Idoso(81, "Usuário 1", "25485433215", Date.valueOf("1960-07-14"), "15484411514",
                    "emailteste@gmail.com", "whuyegsougueg", "M", false));

        form.setVisible(true);

    }

    private void irAgenteView() {
        setVisible(false);
        AgenteView form = null;
        try {
            form = new AgenteView(new Agente(2, "Agente", "00758951423", Date.valueOf("1999-10-10"), "12365478548", "Emailteste@gmail.com",
                    "wdawdwdfrergrggr"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        form.setVisible(true);
    }

    private void irFormIdoso() {
        setVisible(false);
        IdosoForm form = null;
        try {
            form = new IdosoForm(null);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        form.setVisible(true);
    }

    private void irFormAgente() {
        setVisible(false);
        AgenteForm form = null;
        try {
            form = new AgenteForm();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        form.setVisible(true);
    }
}
