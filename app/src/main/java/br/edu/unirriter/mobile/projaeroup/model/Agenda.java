package br.edu.unirriter.mobile.projaeroup.model;

public class Agenda {
    private String hora;
    private String data;
    private String titulo;

    public Agenda(String hora, String data, String titulo) {
        this.hora = hora;
        this.data = data;
        this.titulo = titulo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
