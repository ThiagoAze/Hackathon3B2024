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
                    "jdbc:mysql://localhost:3306/<nome>?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void inserir(Agenda agenda) throws SQLException {
        String sql = "insert into agenda (<parametros>) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, agenda.getIdIdoso());
        ps.setInt(2, agenda.getIdAgente());
        ps.setDate(3, agenda.getData());
        ps.setTime(4, agenda.getHora());
        ps.setString(5, agenda.getRua());
        ps.setString(6, agenda.getCep());
        ps.setInt(7, agenda.getNumero());
        ps.setString(8, agenda.getComplemento());
        ps.setString(9, agenda.getEstado());
        ps.setString(10, agenda.getCidade());
        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from agenda where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<Agenda> listarTodos(Integer idAgente) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        ResultSet rs = connection.prepareStatement("select * from agenda where idAgente = %s".formatted(idAgente)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgente"),
                    rs.getInt("idIdoso"),
                    rs.getDate("data"),
                    rs.getTime("hora"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("status"),
                    rs.getInt("vacina")));
        }
        rs.close();
        return agendas;
    }

    public Agenda listarTodosPorId(Integer id) throws SQLException {
        ResultSet rs = connection.prepareStatement("select * from agenda where id = %s".formatted(id)).executeQuery();
        System.out.println(rs);
        Agenda agenda = new Agenda(
                rs.getInt("id"),
                rs.getInt("idAgente"),
                rs.getInt("idIdoso"),
                rs.getDate("data"),
                rs.getTime("hora"),
                rs.getString("rua"),
                rs.getString("cep"),
                rs.getInt("numero"),
                rs.getString("complemento"),
                rs.getString("estado"),
                rs.getString("cidade"),
                rs.getBoolean("status"),
                rs.getInt("vacina"));

        rs.close();
        return agenda;
    }

    public List<Agenda> listarTodosPorIdoso(Integer idAgente, Integer idIdoso) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        ResultSet rs = connection.prepareStatement("select * from agenda where idAgente = %s and idIdoso = %s".formatted(idAgente, idIdoso)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgente"),
                    rs.getInt("idIdoso"),
                    rs.getDate("data"),
                    rs.getTime("hora"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("status"),
                    rs.getInt("vacina")));
        }
        rs.close();
        return agendas;
    }

    public List<Agenda> listarTodosPorData(Integer idAgente, Date data) throws SQLException {
        List<Agenda> agendas = new ArrayList<Agenda>();

        ResultSet rs = connection.prepareStatement("select * from agenda where idAgente = %s and data = %s".formatted(idAgente, data)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agendas.add(new Agenda(
                    rs.getInt("id"),
                    rs.getInt("idAgente"),
                    rs.getInt("idIdoso"),
                    rs.getDate("data"),
                    rs.getTime("hora"),
                    rs.getString("rua"),
                    rs.getString("cep"),
                    rs.getInt("numero"),
                    rs.getString("complemento"),
                    rs.getString("estado"),
                    rs.getString("cidade"),
                    rs.getBoolean("status"),
                    rs.getInt("vacina")));
        }
        rs.close();
        return agendas;
    }

    public void atualizar(Agenda agenda) throws SQLException {
        String sql = "update agenda set data = ?, hora = ?, where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, agenda.getData());
        ps.setTime(2, agenda.getHora());
        ps.setInt(3, agenda.getId());

        ps.execute();
    }
}
