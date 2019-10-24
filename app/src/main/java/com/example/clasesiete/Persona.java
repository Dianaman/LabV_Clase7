package com.example.clasesiete;

public class Persona {
    private String nombre;
    private String apellido;
    private String telefono;
    private String fotoUrl;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Persona(String nombre, String apellido, String telefono, String fotoUrl) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.fotoUrl = fotoUrl;
    }

    public String getFoto() {
        return fotoUrl;
    }

    public void setFoto(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return this.nombre + " " + this.apellido + ", " + this.telefono;
    }
}
