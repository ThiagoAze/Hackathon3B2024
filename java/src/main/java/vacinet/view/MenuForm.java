package vacinet.view;

import javax.swing.*;
import java.awt.*;

public class MenuForm extends JFrame{
    private JButton botaoUsuario;
    private JButton botaoAgente;
    private JLabel labelMenu;

    public MenuForm(){
        setTitle("Menu de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);




        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelMenu = new JLabel("Cadastro");
        constraints.gridx = 0;
        constraints.gridy = 0;
        painelEntrada.add(labelMenu, constraints);

        botaoUsuario = new JButton("Cadastrar Usuário");
        botaoUsuario.addActionListener(e -> irFormIdoso());
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(botaoUsuario, constraints);

        botaoAgente = new JButton("Cadastrar Agente de Saúde");
        botaoAgente.addActionListener(e -> irFormAgente());
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(botaoAgente, constraints);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);

        setLocationRelativeTo(null);

    }
    private void irFormIdoso() {
        //setVisible(false);
        //var form = new IdosoForm();
        //form.setVisible(true);
    }

    private void irFormAgente() {
        setVisible(false);
        var form = new AgenteForm();
        form.setVisible(true);
    }
}
