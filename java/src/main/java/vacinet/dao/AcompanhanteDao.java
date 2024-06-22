package vacinet.dao;

import vacinet.model.Acompanhante;
import vacinet.model.Idoso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AcompanhanteDao {
    private Connection connection;

    public AcompanhanteDao() throws SQLException {
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

    public void inserir(Acompanhante acompanhante) throws SQLException {
        String sql = "insert into idoso(<parametros>) values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, acompanhante.getIdIdoso());
        ps.setString(2, acompanhante.getNome());
        ps.setString(3, acompanhante.getCpf());
        ps.setString(4, acompanhante.getFone());
        ps.setString(5, acompanhante.getEmail());
        ps.setString(6, acompanhante.getSenha());

        ps.execute();
    }

    public List<Acompanhante> listarPorId(Integer id) throws SQLException {
        List<Acompanhante> acompanhantes = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from acompanhante where id = %s".formatted(id)).executeQuery();
        while (rs.next()) {
            acompanhantes.add(new Acompanhante(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("fone"),
                    rs.getString("email"),
                    rs.getString("senha")
            ));
        }
        rs.close();
        return acompanhantes;
    }
    public List<Acompanhante> listarPorIdIdoso(Integer idIdoso) throws SQLException {
        List<Acompanhante> acompanhantes = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from acompanhante where idIdoso = %s".formatted(idIdoso)).executeQuery();
        while (rs.next()) {
            acompanhantes.add(new Acompanhante(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("fone"),
                    rs.getString("email"),
                    rs.getString("senha")
            ));
        }
        rs.close();
        return acompanhantes;
    }
}
