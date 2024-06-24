package vacinet.dao;

import vacinet.model.Agente;
import vacinet.model.DiaDisponivel;
import vacinet.model.Idoso;
import vacinet.model.ProblemaSaude;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemaSaudeDao {
    private Connection connection;

    public ProblemaSaudeDao() throws SQLException {
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
    public void inserir(ProblemaSaude problemaSaude) throws SQLException {
        String sql = "insert into problemasaude(nome, observacao, idIdoso) values(?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, problemaSaude.getNome());
        ps.setString(2, problemaSaude.getObs());
        ps.setInt(3, problemaSaude.getIdIdoso());

        ps.execute();
    }

    public void atualizar(ProblemaSaude problemaSaude) throws SQLException {
        String sql = "update problemaSaude set nome = ?, set observacao = ?  where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, problemaSaude.getNome());
        ps.setString(2, problemaSaude.getObs());
        ps.setInt(3, problemaSaude.getId());
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from problemasaude where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<ProblemaSaude> listarIdoso(Integer idIdoso) throws SQLException {
        List<ProblemaSaude> problemasSaude = new ArrayList<ProblemaSaude>();

        ResultSet rs = connection.prepareStatement("select * from problemasaude where idIdoso = %s".formatted(idIdoso)).executeQuery();
        while (rs.next()) {
            problemasSaude.add(new ProblemaSaude(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getString("nome"),
                    rs.getString("observacao")));
        }

        rs.close();

        return problemasSaude;
    }
}
