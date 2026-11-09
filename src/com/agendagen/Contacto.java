package com.agendagen;

import java.util.Objects;

public class Contacto {

    private String nombre;
    private String apellido;
    private String numero;

    public Contacto(String nombre, String apellido, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }

    /**
     * Método que obtiene el nombre
     *
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Método que obtiene el apellido
     *
     * @return
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Método que obtiene el telefono
     *
     * @return
     */
    public String getTelefono() {
        return this.numero;
    }

    /**
     * Metodo que asigna un nombre nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que asigna un apellido nuevo
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Metodo que asigna un numero nuevo
     */
    public void setTelefono(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;
        Contacto otro = (Contacto) o;
        return nombre.equalsIgnoreCase(otro.nombre)
                && apellido.equalsIgnoreCase(otro.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - Tel: " + numero;
    }

}