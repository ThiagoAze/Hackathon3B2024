package vacinet.dao;

import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DiaDisponivelDao {
    private Connection connection;

    public DiaDisponivelDao() throws SQLException {
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

    public void inserir(DiaDisponivel diaDisponivel) throws SQLException {
        String sql = "insert into diaDisponivel(data, periodoManha, PeriodoTarde, quantVisita, idAgenteSaude) values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, diaDisponivel.getData());
        ps.setBoolean(2, diaDisponivel.getPeriodoManha());
        ps.setBoolean(3, diaDisponivel.getPeriodoTarde());
        ps.setInt(4, diaDisponivel.getQuantVisita());
        ps.setInt(5, diaDisponivel.getIdAgente());

        ps.execute();
    }

    public void atualizar(DiaDisponivel diaDisponivel) throws SQLException {
        String sql = "update diaDisponivel set data = ?, periodoManha = ?, PeriodoTarde = ?, quantVisita = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, diaDisponivel.getData());
        ps.setBoolean(2, diaDisponivel.getPeriodoManha());
        ps.setBoolean(3, diaDisponivel.getPeriodoTarde());
        ps.setInt(4, diaDisponivel.getQuantVisita());

        ps.setInt(5, diaDisponivel.getId());

        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from diaDisponivel where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<DiaDisponivel> listarIdAgente(Integer idAgente) throws SQLException {
        List<DiaDisponivel> diasDisponiveis = new ArrayList<DiaDisponivel>();

        ResultSet rs = connection.prepareStatement("select * from diaDisponivel where idAgenteSaude = %s".formatted(idAgente)).executeQuery();
        while (rs.next()) {
            diasDisponiveis.add(new DiaDisponivel(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getDate("data"),
                    rs.getBoolean("periodoManha"),
                    rs.getBoolean("periodoTarde"),
                    rs.getInt("quantVisita")));
        }

        rs.close();

        return diasDisponiveis;
    }

    public List<DiaDisponivel> listarPeriodoManhaDia(Date data) throws SQLException {
        List<DiaDisponivel> diasDisponiveis = new ArrayList<DiaDisponivel>();
        String sql = "select * from diaDisponivel where data = ? and periodoManha = true order by quantVisita asc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, data);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            diasDisponiveis.add(new DiaDisponivel(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getDate("data"),
                    rs.getBoolean("periodoManha"),
                    rs.getBoolean("periodoTarde"),
                    rs.getInt("quantVisita")));
        }

        rs.close();

        return diasDisponiveis;
    }

    public List<DiaDisponivel> listarId(int id) throws SQLException {
        List<DiaDisponivel> diasDisponiveis = new ArrayList<DiaDisponivel>();


        String sql = "select * from diaDisponivel where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            diasDisponiveis.add(new DiaDisponivel(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getDate("data"),
                    rs.getBoolean("periodoManha"),
                    rs.getBoolean("periodoTarde"),
                    rs.getInt("quantVisita")));
        }

        rs.close();

        return diasDisponiveis;
    }

    public List<DiaDisponivel> listarPeriodoTardeDia(java.sql.Date data) throws SQLException {
        List<DiaDisponivel> diasDisponiveis = new ArrayList<DiaDisponivel>();
        String sql = "select * from diaDisponivel where data = ? and periodoTarde = true order by quantVisita asc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, data);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            diasDisponiveis.add(new DiaDisponivel(
                    rs.getInt("id"),
                    rs.getInt("idAgenteSaude"),
                    rs.getDate("data"),
                    rs.getBoolean("periodoManha"),
                    rs.getBoolean("periodoTarde"),
                    rs.getInt("quantVisita")));
        }

        rs.close();

        return diasDisponiveis;
    }
}
