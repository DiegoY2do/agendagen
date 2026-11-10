package com.agendagen;

public interface ICrud<T> {
    
    /**
     * Metodo para agregar un objeto.
     * Recibe un Objeto y devuelve un bool si se agrega.
     *
     * @param objeto
     * @return Un valor de verdad
     */
    public boolean agregar(T objeto);

    /**
     * Metodo para verificar la existencia de un objeto.
     * Recibe un objeto y determina si está en la lista.
     * Devuelve true si sí está, false si no.
     *
     * @param objeto
     * @return
     */
    public boolean existe(T objeto);


    /**
     * Imprime en consola todos los objetos de la lista.
     * No devuelve nada.
     */
    public void listar();

    /**
     * Metodo para eliminar un objeto de la lista.
     * Recibe un objeto y trata de eliminarlo de la lista si existe.
     * Devuelve true si lo elimino y false si no.
     *
     * @param objeto
     * @return
     */
    public boolean eliminar(T objeto);
}
