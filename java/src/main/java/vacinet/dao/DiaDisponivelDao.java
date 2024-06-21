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
                    "jdbc:mysql://localhost:3306/<nome>?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void inserir(DiaDisponivel diaDisponivel) throws SQLException {
        String sql = "insert into dia_disponivel(<parametros>) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, diaDisponivel.getId());
        ps.setInt(2, diaDisponivel.getIdAgente());
        ps.setDate(3, diaDisponivel.getData());
        ps.setBoolean(4, diaDisponivel.getPeriodoManha());
        ps.setBoolean(5, diaDisponivel.getPeriodoTarde());
        ps.setInt(6, diaDisponivel.getQuantVisita());
        ps.execute();
    }

    public void atualizar(DiaDisponivel diaDisponivel) throws SQLException {
        String sql = "update dia_disponivel set data = ?, periodo_manha = ?, periodo_tarde = ?, visitas_max = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDate(1, diaDisponivel.getData());
        ps.setBoolean(2, diaDisponivel.getPeriodoManha());
        ps.setBoolean(3, diaDisponivel.getPeriodoTarde());
        ps.setInt(4, diaDisponivel.getQuantVisita());

        ps.setInt(5, diaDisponivel.getId());

        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from dia_disponivel where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<DiaDisponivel> listarPorIdAgente(Agente agente) throws SQLException {
        List<DiaDisponivel> diasDisponiveis = new ArrayList<DiaDisponivel>();

        ResultSet rs = connection.prepareStatement("select * from dia_disponivel where id_agente = %s").executeQuery();
        while (rs.next()) {
            diasDisponiveis.add(new DiaDisponivel(
                    rs.getInt("id"),
                    rs.getInt("id_agente"),
                    rs.getDate("data"),
                    rs.getBoolean("periodoManha"),
                    rs.getBoolean("periodoTarde"),
                    rs.getInt("quantVisita")));
        }

        rs.close();

        return diasDisponiveis;
    }
}
