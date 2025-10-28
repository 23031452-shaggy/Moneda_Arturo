package com.jn.Controller;

import com.jn.Model.ClienteModel;
import com.jn.View.ClienteView;

public class ClienteController {
    private final ClienteModel modelo;
    private final ClienteView vista;

    public ClienteController(ClienteModel modelo, ClienteView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        System.out.println("Conectado al servidor. Escribe 'SALIR' para terminar.");
        boolean salir = false;

        while (!salir) {
            String mensaje = vista.leerMensaje();
            modelo.enviarMensaje(mensaje);

            if (mensaje.equalsIgnoreCase("SALIR")) {
                salir = true;
                break;
            }

            try {
                String respuesta = modelo.recibirRespuesta();
                vista.mostrarMensaje(respuesta);
            } catch (Exception e) {
                System.out.println("Error al recibir respuesta: " + e.getMessage());
            }
        }

        try {
            modelo.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error cerrando conexión: " + e.getMessage());
        }
    }
}
