package br.edu.unirriter.mobile.projaeroup.model;

public class Breve {
    private String titulo;
    private String estado;

    public Breve(String titulo, String estado) {
        this.titulo = titulo;
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
