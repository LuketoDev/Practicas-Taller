package com.tallerwebi.presentacion.Entrenamiento2;

public class ContactoDto {
    private String nombre;
    private String email;
    private String mensaje;

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
