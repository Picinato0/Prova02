package model;

public class Filme {
    private int idFilme;
    private String nome;
    private CategoriaFilme categoriaFilme;

    public Filme(){

    }

    public Filme(int idFilme, String nome, CategoriaFilme categoriaFilme){
        this.setIdFilme(idFilme);
        this.setNome(nome);
        this.setCategoriaFilme(categoriaFilme);
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaFilme getCategoriaFilme() {
        return categoriaFilme;
    }

    public void setCategoriaFilme(CategoriaFilme categoriaFilme) {
        this.categoriaFilme = categoriaFilme;
    }
}
