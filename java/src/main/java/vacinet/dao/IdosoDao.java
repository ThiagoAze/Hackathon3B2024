package vacinet.dao;

import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IdosoDao {
    private Connection connection;

    public IdosoDao() throws SQLException {
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

    public void inserir(Idoso idoso) throws SQLException {
        String sql = "insert into idoso(<parametros>) values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, idoso.getNome());
        ps.setString(2, idoso.getCpf());
        ps.setDate(3, idoso.getDataNascimento());
        ps.setString(4, idoso.getFone());
        ps.setString(5, idoso.getEmail());
        ps.setString(6, idoso.getSenha());
        ps.setBoolean(7, idoso.isAcompanhante());
        ps.setString(8, idoso.getGenero());
        ps.execute();
    }

    public List<Idoso> listarPorId(Integer id) throws SQLException {
        List<Idoso> idosos = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from idoso where id = %s".formatted(id)).executeQuery();
        while (rs.next()) {
            idosos.add(new Idoso(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("dataNascimento"),
                    rs.getString("fone"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("genero"),
                    rs.getBoolean("acompanhante")));
        }

        rs.close();

        return idosos;
    }
}
