package com.agendagen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(10);
        Scanner sc = new Scanner(System.in);
        int opcion;

        // Contactos de prueba (borrar antes de entregar)
        agenda.agregarContacto(new Contacto("Luis", "Pérez", "5512345678"));
        agenda.agregarContacto(new Contacto("ana", "Torres", "5587654321"));
        agenda.agregarContacto(new Contacto("Ana", "Gómez", "5511223344"));
        agenda.agregarContacto(new Contacto("Carlos", "Ruiz", "5599887766"));

        do {
            System.out.println("\n--- AGENDA ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Existe contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. Agenda llena");
            System.out.println("8. Espacios libres");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            System.out.println("\n");
            switch (opcion) {
                case 1:
                    agenda.agregarContacto(pedirContacto(sc, true));
                    break;
                case 2:
                    System.out.println(agenda.existeContacto(pedirContacto(sc, false))
                            ? "El contacto existe." : "El contacto no existe.");
                    break;
                case 3:
                    agenda.listarContactos();
                    break;
                case 4:
                    try {
                        agenda.buscarContacto();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    agenda.eliminarContacto(pedirContacto(sc, false));
                    break;
                case 6:
                    System.out.println("Ingresa nombre, apellido y el NUEVO teléfono.");
                    Contacto datos = pedirContacto(sc, true);
                    agenda.modificarTelefono(datos.getNombre(), datos.getApellido(), datos.getTelefono());
                    break;
                case 7:
                    System.out.println(agenda.agendaLlena()
                            ? "La agenda está llena." : "La agenda aún tiene espacio.");
                    break;
                case 8:
                    System.out.println("Espacios libres: " + agenda.espaciosLibres());
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static Contacto pedirContacto(Scanner sc, boolean conTelefono) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        String telefono = "";
        if (conTelefono) {
            System.out.print("Teléfono: ");
            telefono = sc.nextLine();
        }
        return new Contacto(nombre, apellido, telefono);
    }
}