package vacinet.dao;

import vacinet.model.Agenda;
import vacinet.model.Agente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AgenteDao {
    private Connection connection;

    public AgenteDao() throws SQLException {
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

    public void inserir(Agente agente) throws SQLException {
        String sql = "insert into agentesaude(nome, cpf, dataNascimento, telefone, email, senha) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, agente.getNome());
        ps.setString(2, agente.getCpf());
        ps.setDate(3, agente.getDataNascimento());
        ps.setString(4, agente.getFone());
        ps.setString(5, agente.getEmail());
        ps.setString(6, agente.getSenha());
        ps.execute();
    }

    public List<Agente> listarId(Integer id) throws SQLException {
        List<Agente> agentes = new ArrayList<Agente>();
        ResultSet rs = connection.prepareStatement("select * from agentesaude where id = %s".formatted(id)).executeQuery();
        System.out.println(rs);
        while (rs.next()) {
            agentes.add(new Agente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("dataNascimento"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("senha")
                    ));
        }
        rs.close();
        return agentes;
    }

}
