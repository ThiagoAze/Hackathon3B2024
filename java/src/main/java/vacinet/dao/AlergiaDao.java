package vacinet.dao;

import vacinet.model.Agente;
import vacinet.model.Alergia;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlergiaDao {
    private Connection connection;

    public AlergiaDao() throws SQLException {
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

    public void inserir(Alergia alergia) throws SQLException {
        String sql = "insert into alergia(nome, observacao, idIdoso) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, alergia.getNome());
        ps.setString(2, alergia.getObs());
        ps.setInt(3, alergia.getIdIdoso());
        ps.execute();
    }

    public void atualizar(Alergia alergia) throws SQLException {
        String sql = "update alergia set nome = ?, observacao = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, alergia.getNome());
        ps.setString(2, alergia.getObs());
        ps.setInt(3, alergia.getId());

        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from alergia where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<Alergia> listarIdIdoso(Integer idIdoso) throws SQLException {
        List<Alergia> idosos = new ArrayList<Alergia>();

        ResultSet rs = connection.prepareStatement("select * from alergia where idIdoso = %s".formatted(idIdoso)).executeQuery();
        while (rs.next()) {
            idosos.add(new Alergia(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getString("nome"),
                    rs.getString("observacao")));
        }

        rs.close();

        return idosos;
    }

}
