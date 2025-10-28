package com.jn.View;

import java.util.Scanner;

public class ClienteView {
    private final Scanner scanner = new Scanner(System.in);

    public String leerMensaje() {
        System.out.print("Escribe un mensaje: ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("Servidor dice: " + mensaje);
    }
}
