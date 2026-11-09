package com.agendagen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListarContactos {
    public static void listarContactos(List<Contacto> contactos) {
        if (contactos == null || contactos.isEmpty()) {
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
}