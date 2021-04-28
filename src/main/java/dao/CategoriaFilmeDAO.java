package dao;


import factory.ConnectionFactory;
import model.CategoriaFilme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaFilmeDAO {
    private Connection connection;

    public CategoriaFilmeDAO(){
        this.connection = new ConnectionFactory().getConnection();
        this.createTableCategoria();
    }
    public void createTableCategoria() {
        String sql = "CREATE TABLE IF NOT EXISTS categoriaFilme (" +
                "idCategoria INT PRIMARY KEY AUTO_INCREMENT," +
                "genero VARCHAR(100) NOT NULL," +
                "classification INT NOT NULL" +
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

    public void insertCategorias(CategoriaFilme categoriaFilme) {
        String sql = "INSERT INTO categoriaFilme" +
                " (idCategoria, genero, classification) " +
                "VALUES (?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, categoriaFilme.getIdCategoria());
            stmt.setString(2, categoriaFilme.getGenero());
            stmt.setInt(3, categoriaFilme.getClassification());

            stmt.execute();
            stmt.close();
            System.out.println("Informações inseridas!!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<CategoriaFilme> listCategorias() {
        String sql = "SELECT * FROM categoriaFilme";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            List<CategoriaFilme> categoriasFilme = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            CategoriaFilme categoriaFilme;
            while (resultSet.next()) {
                categoriaFilme = new CategoriaFilme();
                categoriaFilme.setIdCategoria(resultSet.getInt("idCategoria"));
                categoriaFilme.setGenero(resultSet.getString("genero"));
                categoriaFilme.setClassification(resultSet.getInt("classification"));
                categoriasFilme.add(categoriaFilme);
            }
            return categoriasFilme;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CategoriaFilme FindById(int id){
        String sql = "SELECT * FROM categoriaFilme where idCategorias = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet resultSet = stmt.executeQuery();
            CategoriaFilme categoriaFilme = new CategoriaFilme();
            while(resultSet.next()){
                categoriaFilme.setIdCategoria(resultSet.getInt("idCategorias"));
                categoriaFilme.setGenero(resultSet.getString("genero"));
                categoriaFilme.setClassification(resultSet.getInt("classification"));
            }
            return categoriaFilme;

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}