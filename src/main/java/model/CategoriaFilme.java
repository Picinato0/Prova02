package model;

public class CategoriaFilme {
    private int idCategoria;
    private String genero;
    private int classification;

    public CategoriaFilme(){

    }

    public CategoriaFilme(int idCategoria, String genero, int classification){
        this.setIdCategoria(idCategoria);
        this.setGenero(genero);
        this.setClassification(classification);
    }


    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }
}
