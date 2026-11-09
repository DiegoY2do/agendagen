package com.agendagen;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Contacto> contactos;
    private final int tamanoMaximo;

    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        contactos = new ArrayList<>(tamanoMaximo);
    }


    /**
     * Metodo para agregar un contacto.
     * Recibe un Objeto Contacto y no devuelve nada.
     * Asegurarse de que no se sobrepase el límite (tamanoMaximo)
     * 
     * @param contacto
     */
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    /**
     * Metodo para modificar el numero de un contacto
     * Recibe el nombre, apellido del contacto a modificarle el y numero.
     * No devuelve nada, Si quieren, imprimir en consola que todo bien.
     * Assegurase de numero válido. 
     * 
     * @param nombre
     * @param apellido
     * @param numero
     */
    public void modificarTelefono(String nombre, String apellido, String numero) {
        return ;
    }

    /**
     * Metodo para verificar la existencia de un contacto
     * Recibe un objeto Contacto y determina si está en la lista de contactos
     * Devuelve true si sí está, false si no.
     * 
     * @param contacto
     * @return
     */
    public boolean existeContacto(Contacto contacto) {
        return false;
    }

    /**
     * Imprime en consola todos los contactos de la agenda
     * No devuelve nada.
     */
    public void listarContactos() {
        return ;
    }

    /**
     * Metodo para buscar un contacto especifico.
     * Recibe cono cadenas el nombre, el apellido y el numero.
     * Devuelve el contacto si es que existe, si no dice que no (puede lanzar una excepción)
     * 
     * @param nombre
     * @param apellido
     * @param number
     * @return
     */
    public Contacto buscarContacto(String nombre, String apellido, String number) throws Exception {
        return new Contacto("nombre", "apellido", "numero");
    }

    /**
     * Metodo para eliminar un contacto
     * Recibe un objeto Contacto trata de eliminarlo de la agenda si si esta
     * Devuelve true si lo elimino y false si no.
     * 
     * @param contacto
     * @return
     */
    public boolean eliminarContacto(Contacto contacto) {
        return false;
    }

    /**
     * Indica si la agenda ya está llena. (tamanoMaximo)
     * Devuelve true si lo esta y false si no.
     * 
     * @return
     */
    public boolean agendaLlena() {
        return false;
    }
}