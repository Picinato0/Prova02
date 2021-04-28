package dao;

import factory.ConnectionFactory;
import model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection connection;

    public FilmeDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableFilme();
    }
    public void createTableFilme() {
        String sql = "CREATE TABLE IF NOT EXISTS filme (" +
                "idFilme INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(100) NOT NULL," +
                "categoriaFilme varchar(100) NOT NULL" +
                ");";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.execute();
            stmt.close();

            System.out.println("Tabela State criada com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertFilmes(Filme filme) {
        String sql = "INSERT INTO filme" +
                " (idFilme, nome, categoriaFilme) " +
                "VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, filme.getIdFilme());
            stmt.setString(2, filme.getNome());
            stmt.setInt(3, filme.getCategoriaFilme().getIdCategoria());

            stmt.execute();
            stmt.close();
            System.out.println("Informações inseridas!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Filme> listFilmes() {
        String sql = "SELECT * FROM filme";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            List<Filme> filmes = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            Filme filme;
            CategoriaFilmeDAO categoriaFilmeDAO = new CategoriaFilmeDAO();
            while (resultSet.next()) {
                filme = new Filme();
                filme.setIdFilme(resultSet.getInt("idFilme"));
                filme.setNome(resultSet.getString("nome"));
                filme.setCategoriaFilme(categoriaFilmeDAO.FindById(resultSet.getInt("categoriaFilme")));
                filmes.add(filme);
            }
            return filmes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
