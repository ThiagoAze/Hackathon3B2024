package vacinet.view;

import vacinet.model.*;
import vacinet.service.*;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class VacinaForm extends JFrame{
    private AgendaService serviceAgenda;
    private VacinaService serviceVacina;
    private AgenteService serviceAgente;
    private IdosoService serviceIdoso;
    private DiaDisponivel diaDisponivel;
    private DiaDisponivelService serviceDiaDisponivel;
    private DateTimeFormatter formatter;
    private Idoso idosoSalvo;
    private Vacina vacinaSalva;
    private JLabel labelForm;
    private JLabel labelCep;
    private JFormattedTextField campoCep;
    private String[] estados = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
            "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais",
            "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
            "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins",
            "Distrito Federal"
    };
    private JLabel labelEstado;
    private JComboBox boxEstado;
    private JLabel labelCidade;
    private JTextField campoCidade;
    private JLabel labelRua;
    private JTextField campoRua;
    private JLabel labelComplemento;
    private JTextField campoComplemento;
    private JLabel labelNumero;
    private JTextField campoNumero;
    private String[] periodos = {"Período da Manhã", "Período da Tarde"};
    private JLabel labelPeriodo;
    private JComboBox boxPeriodo;
    private JLabel labelData;
    private JFormattedTextField campoData;
    private JLabel diaForm;
    private JButton botaoBuscar;
    private JButton botaCancelar;
    private JButton botaoAgendar;
    private Boolean permitirAgendamento;

    public VacinaForm(Idoso idoso, Vacina vacina) throws ParseException {
        idosoSalvo = idoso;
        vacinaSalva = vacina;
        serviceAgenda = new AgendaService();
        serviceAgente = new AgenteService();
        serviceVacina = new VacinaService();
        serviceIdoso = new IdosoService();
        serviceDiaDisponivel = new DiaDisponivelService();
        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        setTitle("Agendamento");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 650);
        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        labelForm = new JLabel("Agendamento de Vacinação");
        constraints.gridx = 2;
        constraints.gridy = 0;
        painelEntrada.add(labelForm, constraints);

        labelCep = new JLabel("Cep:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelCep, constraints);

        campoCep = new JFormattedTextField(new MaskFormatter("#####-###"));
        campoCep.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoCep, constraints);

        labelEstado = new JLabel("Estado:");
        constraints.gridx = 2;
        constraints.gridy = 1;
        painelEntrada.add(labelEstado, constraints);

        boxEstado = new JComboBox(estados);

        boxEstado.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 3;
        constraints.gridy = 1;
        painelEntrada.add(boxEstado, constraints);

        labelCidade = new JLabel("Cidade:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelCidade, constraints);

        campoCidade = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoCidade, constraints);

        labelRua = new JLabel("Rua:");
        constraints.gridx = 2;
        constraints.gridy = 2;
        painelEntrada.add(labelRua, constraints);

        campoRua = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 2;
        painelEntrada.add(campoRua, constraints);

        labelNumero = new JLabel("Numero:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelNumero, constraints);

        campoNumero = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoNumero, constraints);

        labelComplemento = new JLabel("Complemento:");
        constraints.gridx = 2;
        constraints.gridy = 3;
        painelEntrada.add(labelComplemento, constraints);

        campoComplemento = new JTextField(20);
        constraints.gridx = 3;
        constraints.gridy = 3;
        painelEntrada.add(campoComplemento, constraints);

        botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(e -> buscar());
        constraints.gridx = 2;
        constraints.gridy = 4;
        painelEntrada.add(botaoBuscar, constraints);

        labelData = new JLabel("Data:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(labelData, constraints);

        campoData = new JFormattedTextField(new MaskFormatter("##/##/####"));
        campoData.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(campoData, constraints);

        labelPeriodo = new JLabel("Período:");
        constraints.gridx = 2;
        constraints.gridy = 5;
        painelEntrada.add(labelPeriodo, constraints);

        boxPeriodo = new JComboBox(periodos);

        boxPeriodo.setPreferredSize(new Dimension(225, 20));
        constraints.gridx = 3;
        constraints.gridy = 5;
        painelEntrada.add(boxPeriodo, constraints);

        botaCancelar = new JButton("Cancelar");
        botaCancelar.addActionListener(e -> cancelar());
        constraints.gridx = 1;
        constraints.gridy = 10;
        painelEntrada.add(botaCancelar, constraints);

        botaoAgendar = new JButton("Agendar");
        botaoAgendar.addActionListener(e -> agendar());
        constraints.gridx = 2;
        constraints.gridy = 10;
        painelEntrada.add(botaoAgendar, constraints);

        getContentPane().add(painelEntrada, BorderLayout.CENTER);
        setLocationRelativeTo(null);

    }

    private void buscar() {
        var ultimaAgenda = serviceAgenda.listarEndereco(idosoSalvo);

        if (ultimaAgenda.equals(null)) {
            JOptionPane.showMessageDialog(this, "CEP não encontrado");
        } else {
            campoCep.setText(ultimaAgenda.getCep());
            campoNumero.setText(String.valueOf(ultimaAgenda.getNumero()));
            campoRua.setText(ultimaAgenda.getRua());
            campoCidade.setText(ultimaAgenda.getCidade());
            campoComplemento.setText(ultimaAgenda.getComplemento());
        }
    }

    public String escolhaPeriodo(Integer periodoEscolhidoIndex){
        if (periodoEscolhidoIndex == 0) return "manha";
        if (periodoEscolhidoIndex == 1) return "tarde";
        return null;
    }

    public String escolhaEstado(Integer estadoEscolhidoIndex){
        if (estadoEscolhidoIndex == 0) return "Acre";
        if (estadoEscolhidoIndex == 1) return "Alagoas";
        if (estadoEscolhidoIndex == 2) return "Amapá";
        if (estadoEscolhidoIndex == 3) return "Amazonas";
        if (estadoEscolhidoIndex == 4) return "Bahia";
        if (estadoEscolhidoIndex == 5) return "Ceará";
        if (estadoEscolhidoIndex == 6) return "Espírito Santo";
        if (estadoEscolhidoIndex == 7) return "Goiás";
        if (estadoEscolhidoIndex == 8) return "Maranhão";
        if (estadoEscolhidoIndex == 9) return "Mato Grosso";
        if (estadoEscolhidoIndex == 10) return "Mato Grosso do Sul";
        if (estadoEscolhidoIndex == 11) return "Minas Gerais";
        if (estadoEscolhidoIndex == 12) return "Pará";
        if (estadoEscolhidoIndex == 13) return "Paraíba";
        if (estadoEscolhidoIndex == 14) return "Paraná";
        if (estadoEscolhidoIndex == 15) return "Pernambuco";
        if (estadoEscolhidoIndex == 16) return "Piauí";
        if (estadoEscolhidoIndex == 17) return "Rio de Janeiro";
        if (estadoEscolhidoIndex == 18) return "Rio Grande do Norte";
        if (estadoEscolhidoIndex == 19) return "Rio Grande do Sul";
        if (estadoEscolhidoIndex == 20) return "Rondônia";
        if (estadoEscolhidoIndex == 21) return "Roraima";
        if (estadoEscolhidoIndex == 22) return "Santa Catarina";
        if (estadoEscolhidoIndex == 23) return "São Paulo";
        if (estadoEscolhidoIndex == 24) return "Sergipe";
        if (estadoEscolhidoIndex == 25) return "Tocantins";
        if (estadoEscolhidoIndex == 26) return "Distrito Federal";
        return null;
    }

    public void validarString(String valor, String CAMPO) {
        try {
            if (valor.isEmpty()) throw new RuntimeException("Campo %s não pode ser vazio".formatted(CAMPO));
            if (valor.isBlank()) throw new RuntimeException("Campo %s não pode ser espaço".formatted(CAMPO));

        }catch (RuntimeException e){
            permitirAgendamento = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void validarCep(int valor) {
        try {
            if (valor != 8) throw new RuntimeException("O campo cep deve ter 8 caracteres");
        } catch (Exception e){
            permitirAgendamento = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }


    private LocalDate validacaoData(String valor, String CAMPO, Date dataLimite){
        try {
            if (valor.equals("  /  /    ")) throw new RuntimeException("Campo %s não pode ser vazio".formatted(CAMPO));
            if (valor.isBlank()) throw new RuntimeException("Campo %s não pode ser espaço".formatted(CAMPO));
            var data = LocalDate.parse(valor, formatter);

            var dataHoje = LocalDate.now();

            var dataLimiteLocalDate = LocalDate.parse(dataLimite.toString());

            if (data.isBefore(dataHoje)) {
                throw new RuntimeException("Campo %s não pode ser anterior a hoje".formatted(CAMPO));
            } else if (data.isAfter(dataLimiteLocalDate)) {
                throw new RuntimeException("Campo %s não pode ser posterior à data limite".formatted(CAMPO));
            }

            diaDisponivel = validarDiaDisponivel(Date.valueOf(LocalDate.parse(campoData.getText(), formatter)));
            return data;
        } catch (RuntimeException re) {
            permitirAgendamento = false;
            JOptionPane.showMessageDialog(this, re.getMessage());
            return null;
        } catch (Exception e) {
            permitirAgendamento = false;
            JOptionPane.showMessageDialog(this, "data inválida");
            return null;
        }
    }

    private int validarNumero(String valor, String CAMPO) {
        try {
            if (valor.isEmpty()) throw new RuntimeException("Campo %s não pode ser vazio".formatted(CAMPO));
            if (valor.isBlank()) throw new RuntimeException("Campo %s não pode ser espaço".formatted(CAMPO));
            var numero = Integer.parseInt(valor);
            if (numero < 0) throw new RuntimeException("Campo quantidade de premiações não pode ser menor que zero");
            return numero;
        }catch (RuntimeException e){
            permitirAgendamento = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
            return 0;
        }
    }

    public DiaDisponivel validarDiaDisponivel(Date valor) {
        try {
            var agentesManha = serviceDiaDisponivel.listarPeriodoManhaDia(valor);
            var agentesTarde = serviceDiaDisponivel.listarPeriodoTardeDia(valor);
            if (escolhaPeriodo(boxPeriodo.getSelectedIndex()) == "manha") {
                if (agentesManha.size() != 0){
                    return agentesManha.get(0);
                } else {
                    throw new RuntimeException("Não encontramos profissionais tente agendar sua vacinação em outro dia ou horário outro");
                }
            } else {
                if (agentesTarde.size() != 0){
                    return agentesTarde.get(0);
                } else {
                    throw new RuntimeException("Não encontramos profissionais tente agendar sua vacinação em outro dia ou horário outro");

                }
            }
        } catch (RuntimeException e) {
            permitirAgendamento = false;
            JOptionPane.showMessageDialog(this, e.getMessage());
            return null;
        }
    }

    public String formatarNumeros(String valor) {
        var valorFormatado = valor.replaceAll("[^0-9]", "");

        return valorFormatado;
    }

    public void agendar() {
        permitirAgendamento = true;
        validarString(campoRua.getText(),"Rua");
        validarString(formatarNumeros(campoCep.getText()), "CEP");
        validarCep(formatarNumeros(campoCep.getText()).length());
        validacaoData(campoData.getText(), "data da visita", vacinaSalva.getDataLimite());

        validarString(campoComplemento.getText(), "Complemento");
        validarString(campoCidade.getText(), "Cidade");
        var numero = validarNumero(formatarNumeros(campoNumero.getText()), "Número");


        if (permitirAgendamento){
            serviceAgenda.salvar(new Agenda(diaDisponivel.getIdAgente(), idosoSalvo.getId(), vacinaSalva.getId(),
                    Date.valueOf(LocalDate.parse(campoData.getText(), formatter)), null, campoRua.getText(), formatarNumeros(campoCep.getText()),
                numero, campoComplemento.getText(), escolhaEstado(boxEstado.getSelectedIndex()), campoCidade.getText(), false, false, escolhaPeriodo(boxPeriodo.getSelectedIndex())));
            setVisible(false);
        }
    }

    public void cancelar() {
        setVisible(false);
    }

}
