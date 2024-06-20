package vacinet.dao;

import vacinet.model.Agente;

import java.sql.*;

public class AgenteDao {
    private Connection connection;

    public AgenteDao() throws SQLException {
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

    public void inserir(Agente agente) throws SQLException {
        String sql = "insert into agente(<parametros>) values(?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agente.getNome());
        ps.setString(2, agente.getCpf());
        ps.setDate(3, agente.getDataNascimento());
        ps.setString(4, agente.getFone());
        ps.setString(5, agente.getEmail());
        ps.setString(5, agente.getSenha());
        ps.execute();
    }
    /*
    public void confirmarLogin(String cpf, String senha) throws SQLException {
        String sql = "Select * from agente where cpf = ? and senha = ?";
        ResultSet rs = connection.prepareStatement("select * from diretor where cpf = %s and senha = %s".formatted(cpf, senha)).executeQuery();
        System.out.println(rs);
    }
     */
}
