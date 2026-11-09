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
                    System.out.print("Ingrese nombre: ");
                    String nAdd = sc.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String aAdd = sc.nextLine();
                    System.out.print("Ingrese teléfono: ");
                    String tAdd = sc.nextLine();
                    agenda.agregarContacto(new Contacto(nAdd, aAdd, tAdd));
                    break;
                case 2:
                    System.out.print("Nombre a verificar: ");
                    String nVer = sc.nextLine();
                    System.out.print("Apellido a verificar: ");
                    String aVer = sc.nextLine();
                    boolean existe = agenda.existeContacto(new Contacto(nVer, aVer, ""));
                    if (existe) {
                        System.out.println("👉 El contacto SÍ existe en la agenda.");
                    } else {
                        System.out.println("👉 El contacto NO existe en la agenda.");
                    }
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
                    System.out.print("Nombre del contacto a eliminar: ");
                    String nDel = sc.nextLine();
                    System.out.print("Apellido del contacto a eliminar: ");
                    String aDel = sc.nextLine();
                    agenda.eliminarContacto(new Contacto(nDel, aDel, ""));
                    break;
                case 6:
                    System.out.print("Nombre del contacto: ");
                    String nMod = sc.nextLine();
                    System.out.print("Apellido del contacto: ");
                    String aMod = sc.nextLine();
                    System.out.print("Nuevo teléfono: ");
                    String tMod = sc.nextLine();
                    agenda.modificarTelefono(nMod, aMod, tMod);
                    break;
                case 7:
                    if (agenda.agendaLlena()) {
                        System.out.println("🔴 La agenda está LLENA.");
                    } else {
                        System.out.println("🟢 La agenda NO está llena, aún hay espacio.");
                    }
                    break;
                    break;
                case 8:
                    agenda.espaciosLibres();
                    break;
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
}