package vacinet.dao;

import vacinet.model.DiaDisponivel;
import vacinet.model.Vacina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacinaDao {
    private Connection connection;

    public VacinaDao() throws SQLException {
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

    public void inserir(Vacina vacina) throws SQLException {
        String sql = "insert into vacina(<parametros>) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "nome");
        ps.setString(2, "idadeMin");
        ps.setString(3, "idadeMax");
        ps.setString(4, "dataInicio");
        ps.setString(5, "dataLimite");
        ps.setString(6, "doenca");
        ps.setString(7, "observacao");
        ps.execute();
    }

    public void atualizar(Vacina vacina) throws SQLException {
        String sql = "update vacina set nome = ?, idadeMinimaima = ?, idadeMaximaima = ?, dataInicio = ?, dataFinal = ?, doenca = ?, observacao = ? where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, vacina.getNome());
        ps.setInt(2, vacina.getIdadeMin());
        ps.setInt(3, vacina.getIdadeMax());
        ps.setDate(4, vacina.getDataInicio());
        ps.setDate(5, vacina.getDataLimite());
        ps.setString(6, vacina.getDoenca());
        ps.setString(7, vacina.getObs());

        ps.setInt(8, vacina.getId());

        ps.execute();
    }

    public void deletar(int id) throws SQLException {
        String sql = "delete from vacina where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.execute();
    }

    public List<Vacina> listarDia(Date dia) throws SQLException {
        List<Vacina> vacinas = new ArrayList<Vacina>();

        ResultSet rs = connection.prepareStatement("select * from vacina where %s between idadeMinima and idadeMaxima".formatted(dia)).executeQuery();
        while (rs.next()) {
            vacinas.add(new Vacina(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idadeMinima"),
                    rs.getInt("idadeMaxima"),
                    rs.getDate("dataInicio"),
                    rs.getDate("dataFinal"),
                    rs.getString("doenca"),
                    rs.getString("observacao")));
        }

        rs.close();
        return vacinas;
    }

    public List<Vacina> listarIdade(int idade) throws SQLException {
        List<Vacina> vacinas = new ArrayList<Vacina>();

        ResultSet rs = connection.prepareStatement("select * from vacina where %s between idadeMinima and idadeMaxima".formatted(idade)).executeQuery();
        while (rs.next()) {
            vacinas.add(new Vacina(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idadeMinima"),
                    rs.getInt("idadeMaxima"),
                    rs.getDate("dataInicio"),
                    rs.getDate("dataFinal"),
                    rs.getString("doenca"),
                    rs.getString("observacao")));
        }

        rs.close();
        return vacinas;
    }

    public List<Vacina> listarId(int id) throws SQLException {
        List<Vacina> vacinas = new ArrayList<Vacina>();

        ResultSet rs = connection.prepareStatement("select * from vacina where id = %s".formatted(id)).executeQuery();
        while (rs.next()) {
            vacinas.add(new Vacina(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("idadeMinima"),
                    rs.getInt("idadeMaxima"),
                    rs.getDate("dataInicio"),
                    rs.getDate("dataFinal"),
                    rs.getString("doenca"),
                    rs.getString("observacao")));
        }

        rs.close();
        return vacinas;
    }
}
