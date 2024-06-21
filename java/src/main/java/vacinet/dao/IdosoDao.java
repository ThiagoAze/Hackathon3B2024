package vacinet.dao;

import vacinet.model.Idoso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
