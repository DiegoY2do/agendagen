package com.agendagen;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda(10);

        agenda.agregarContacto(new Contacto("Luis", "Pérez", "5512345678"));
        agenda.agregarContacto(new Contacto("ana", "Torres", "5587654321"));
        agenda.agregarContacto(new Contacto("Ana", "Gómez", "5511223344"));
        agenda.agregarContacto(new Contacto("Carlos", "Ruiz", "5599887766"));

        agenda.listarContactos();
    }
}