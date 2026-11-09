package com.agendagen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private final List<Contacto> contactos;
    private final int tamanoMaximo;

    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        contactos = new ArrayList<>(tamanoMaximo);
    }

    public Agenda() {
        this(10);
    }


    /**
     * Metodo para agregar un contacto.
     * Recibe un Objeto Contacto y no devuelve nada.
     * Asegurarse de que no se sobrepase el límite (tamanoMaximo)
     *
     * @param contacto
     */
    public void agregarContacto(Contacto contacto) {
        if (agendaLlena()) {
            System.out.println("La agenda está llena, no se pueden añadir más contactos.");
            return;
        }

        if (contacto == null
                || contacto.getNombre() == null || contacto.getNombre().trim().isEmpty()
                || contacto.getApellido() == null || contacto.getApellido().trim().isEmpty()) {
            System.out.println("El nombre y el apellido no pueden estar vacíos.");
            return;
        }

        if (existeContacto(contacto)) {
            System.out.println("El contacto " + contacto.getNombre() + " "
                    + contacto.getApellido() + " ya existe en la agenda.");
            return;
        }

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
        try {
            Contacto c = buscarContacto(nombre, apellido, numero);
            c.setTelefono(numero);
            System.out.println("Teléfono actualizado correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
        return contactos.contains(contacto);
    }

    /**
     * Imprime en consola todos los contactos de la agenda
     * No devuelve nada.
     */
    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }

        List<Contacto> ordenados = new ArrayList<>(contactos);
        ordenados.sort(
                Comparator.comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER)
        );

        for (Contacto c : ordenados) {
            System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
        }
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
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)
                    && c.getApellido().equalsIgnoreCase(apellido)) {
                return c;
            }
        }
        throw new Exception("No se ha encontrado el contacto: " + nombre + " " + apellido);
    }

    public Contacto buscarContacto() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre a buscar: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido a buscar: ");
        String apellido = sc.nextLine();

        Contacto c = buscarContacto(nombre, apellido, "");

        System.out.println("\n");

        System.out.println("Contacto encontrado:");
        System.out.println("Nombre: " + c.getNombre());
        System.out.println("Apellido: " + c.getApellido());
        System.out.println("Teléfono: " + c.getTelefono());
        return c;
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
        boolean eliminado = contactos.remove(contacto);
        System.out.println(eliminado ? "Contacto eliminado." : "El contacto no existe.");
        return eliminado;
    }

    /**
     * Indica si la agenda ya está llena. (tamanoMaximo)
     * Devuelve true si lo esta y false si no.
     *
     * @return
     */
    public boolean agendaLlena() {
        return contactos.size() >= tamanoMaximo;
    }

    public int espaciosLibres() {
        return tamanoMaximo - contactos.size();
    }
}