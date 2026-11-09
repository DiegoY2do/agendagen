package com.agendagen;

public class Contacto {

    String nombre;
    String apellido;
    String numero;

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

}
