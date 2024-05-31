package org.example.h691_lab6_20210795.beans;

public class Actor {
    private  int idActor;
    private  String Nombre;
    private  String Apellido;
    private int anoNacimiento;
    private boolean ganoOscar;
    private String titulo_pelicula;

    public String getTitulo_pelicula() {
        return titulo_pelicula;
    }

    public void setTitulo_pelicula(String titulo_pelicula) {
        this.titulo_pelicula = titulo_pelicula;
    }

    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public boolean isganoOscar() {
        return ganoOscar;
    }

    public void setganoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }
}
