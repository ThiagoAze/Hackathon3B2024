package vacinet.dao;

import vacinet.model.Alergia;
import vacinet.model.Aviso;
import vacinet.model.Idoso;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class AvisoDao {
    private Connection connection;

    public AvisoDao() throws SQLException {
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

    public void inserir(Aviso aviso) throws SQLException {
        String sql = "insert into aviso(enviaAlertaGeral, nome, descricao, data, hora, idIdoso) values(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setBoolean(1, aviso.getisGeral());
        ps.setString(2, aviso.getNome());
        ps.setString(3, aviso.getDescricao());
        ps.setDate(4, Date.valueOf(LocalDate.now()));
        ps.setTime(5, Time.valueOf(LocalTime.now()));
        ps.setInt(6, aviso.getIdIdoso());

        ps.execute();
    }

    public List<Aviso> listarIdIdoso(Integer idIdoso) throws SQLException {
        List<Aviso> avisos = new ArrayList<Aviso>();

        String sql = "select * from aviso where idIdoso = ? or enviaAlertaGeral = true order by data desc";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, idIdoso);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            avisos.add(new Aviso(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getBoolean("enviaAlertaGeral"),
                    rs.getString("nome"),
                    rs.getString("descricao")));
        }

        rs.close();

        return avisos;
    }
    public List<Aviso> listarGeral() throws SQLException {
        List<Aviso> avisos = new ArrayList<Aviso>();

        ResultSet rs = connection.prepareStatement("select * from aviso where enviaAlertaGeral = true order by asc").executeQuery();
        while (rs.next()) {
            avisos.add(new Aviso(
                    rs.getInt("id"),
                    rs.getInt("idIdoso"),
                    rs.getBoolean("enviaAlertaGeral"),
                    rs.getString("nome"),
                    rs.getString("descricao")));
        }

        rs.close();

        return avisos;
    }
}
