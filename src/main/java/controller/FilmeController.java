package controller;

import com.google.gson.Gson;
import dao.FilmeDAO;
import model.Filme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/filme")
public class FilmeController {
    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaFilme() {
        FilmeDAO filmeDAO = new FilmeDAO();
        filmeDAO.createTableFilme();
        return Response.ok(new Gson().toJson("Tabela Filme criada")).build();
    }


    @GET
    @Path("list")
    @Produces("application/json")
    public Response listFilmes(){
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filme> filmes = filmeDAO.listFilmes();
        return Response.ok(new Gson().toJson(filmes)).build();
    }
}
