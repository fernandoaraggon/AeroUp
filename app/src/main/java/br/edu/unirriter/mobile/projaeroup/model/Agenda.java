package br.edu.unirriter.mobile.projaeroup.model;

public class Agenda {
    private String hora;
    private String data;
    private String titulo;
    private String localinst;

    public Agenda(String hora, String data, String titulo, String localinst) {
        this.hora = hora;
        this.data = data;
        this.titulo = titulo;
        this.localinst = localinst;
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

    public String getLocalinst() {
        return localinst;
    }

    public void setLocalinst(String localinst) {
        this.localinst = localinst;
    }
}
