package vacinet.dao;

import vacinet.model.Agenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgendaDao {
    private Connection connection;

    public AgendaDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vacinet?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void inserir(Agenda agenda) throws SQLException {
        String sql = "insert into agenda (data, horario, rua, cep, numero, complemento, cidade, estado, statusAgendamento, periodo, statusVisita, idAgenteSaude, idIdoso, idVacina) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, agenda.getData());
        ps.setTime(2, agenda.getHora());
        ps.setString(3, agenda.getRua());
        ps.setString(4, agenda.getCep());
        ps.setInt(5, agenda.getNumero());
        ps.setString(6, agenda.getComplemento());
        ps.setString(7, agenda.getCidade());
        ps.setString(8, agenda.getEstado());
        ps.setBoolean(9, agenda.getStatusAgendamento());
        ps.setString(10, agenda.getPeriodo());
        ps.setBoolean(11, agenda.getStatusVisita());
        ps.setInt(12, agenda.getIdAgente());
        ps.setInt(13, agenda.getIdIdoso());
        ps.setInt(14, agenda.getIdVacina());
        ps.execute();
    }

    public void atualizar(Agenda agenda) throws SQLException {
        String sql = "update agenda set data = ?, horario = ?, statusAgendamento = true where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, agenda.getData());
        ps.setTime(2, agenda.getHora());
        ps.setInt(3, agenda.getId());

        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from agenda where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<Agenda> listarTodosAgente(Integer idAgenteSaude) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        String sql = "select * from agenda where idAgenteSaude = ? order by data, horario desc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idAgenteSaude);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")
                    ));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarTodosId(Integer id) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();
        ResultSet rs = connection.prepareStatement("select * from agenda where id = %s order by data, horario desc".formatted(id)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarProximaVacina(Integer idIdoso, Date dataHoje) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        String sql = "select * from agenda where idIdoso = ? and data > ? and statusAgendamento = true and statusVisita = false order by data, horario desc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idIdoso);
        statement.setDate(2, dataHoje);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarTodosAgenteIdoso(Integer idAgenteSaude, Integer idIdoso) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        ResultSet rs = connection.prepareStatement("select * from agenda where idAgenteSaude = %s and idIdoso = %s".formatted(idAgenteSaude, idIdoso)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarTodosIdoso(Integer idIdoso) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        String sql = "select * from agenda where idIdoso = ? and statusVisita = true";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idIdoso);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarTodosAgenteData(Integer idAgenteSaude, Date data) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        ResultSet rs = connection.prepareStatement("select * from agenda where idAgenteSaude = %s and data = %s".formatted(idAgenteSaude, data)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")
                    ));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarUltimaVacina(Integer idIdoso, Date dataHoje) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        String sql = "select * from agenda where idIdoso = ? and data < ? or statusVisita = true order by data, horario desc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idIdoso);
        statement.setDate(2, dataHoje);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarEndereco(Integer idIdoso) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        String sql = "select * from agenda where idIdoso = ? order by data desc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idIdoso);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getInt("idIdoso"),
                    rs.getInt("idVacina"),
                    rs.getDate("data"),
                    rs.getTime("horario"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("statusAgendamento"),
                    rs.getBoolean("statusVisita"),
                    rs.getString("periodo")));
        }
        rs.close();
        return agendas;
    }
}
