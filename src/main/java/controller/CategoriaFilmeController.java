package controller;

import com.google.gson.Gson;
import dao.CategoriaFilmeDAO;
import model.CategoriaFilme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/categoriafilme")
public class CategoriaFilmeController {
    @GET
    @Path("criatabela")
    @Produces("application/json")
    public Response criaTabelaCategoria() {
        CategoriaFilmeDAO categoriaFilmeDAO = new CategoriaFilmeDAO();
        categoriaFilmeDAO.createTableCategoria();
        return Response.ok(new Gson().toJson("Tabela CategoriaFilme criada")).build();
    }


    @GET
    @Path("list")
    @Produces("application/json")
    public Response listCategorias(){
        CategoriaFilmeDAO categoriaFilmeDAO = new CategoriaFilmeDAO();
        List<CategoriaFilme> categoriasFilme = categoriaFilmeDAO.listCategorias();
        return Response.ok(new Gson().toJson(categoriasFilme)).build();
    }
}
