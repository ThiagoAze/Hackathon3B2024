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
                    "jdbc:mysql://localhost:3306/vacinet?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void inserir(Acompanhante acompanhante) throws SQLException {
        String sql = "insert into acompanhante(nome, cpf, telefone, email, senha, idIdoso) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, acompanhante.getNome());
        ps.setString(2, acompanhante.getCpf());
        ps.setString(3, acompanhante.getFone());
        ps.setString(4, acompanhante.getEmail());
        ps.setString(5, acompanhante.getSenha());
        ps.setInt(6, acompanhante.getIdIdoso());

        ps.execute();
    }

    public List<Acompanhante> listarId(Integer id) throws SQLException {
        List<Acompanhante> acompanhantes = new ArrayList<>();

        ResultSet rs = connection.prepareStatement("select * from acompanhante where id = %s".formatted(id)).executeQuery();
        while (rs.next()) {
            acompanhantes.add(new Acompanhante(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("senha")
            ));
        }
        rs.close();
        return acompanhantes;
    }
}
