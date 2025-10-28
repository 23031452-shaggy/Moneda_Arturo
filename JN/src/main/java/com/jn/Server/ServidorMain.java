package com.jn.Server;

import com.jn.View.VentanaServidor;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain extends Application {

    private static final int PUERTO = 9090;

    @Override
    public void start(Stage stage) {
        VentanaServidor ventana = new VentanaServidor(stage);
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
                ventana.agregarMensaje("Servidor escuchando en el puerto " + PUERTO);

                Socket clienteSocket = serverSocket.accept();
                ventana.agregarMensaje("Cliente conectado: " + clienteSocket.getInetAddress());

                BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

                String mensaje;
                while ((mensaje = entrada.readLine()) != null) {
                    ventana.agregarMensaje("Cliente: " + mensaje);
                    StringBuilder invertido = new StringBuilder();
                    for (char c : mensaje.toCharArray()) {
                        if (Character.isUpperCase(c)) {
                            invertido.append(Character.toLowerCase(c));
                        } else if (Character.isLowerCase(c)) {
                            invertido.append(Character.toUpperCase(c));
                        } else {
                            invertido.append(c);
                        }
                    }

                    salida.println(invertido.toString());
                    ventana.agregarMensaje("Servidor: " + invertido.toString());

                    if (mensaje.equalsIgnoreCase("SALIR")) {
                        clienteSocket.close();
                        ventana.agregarMensaje("Cliente desconectado.");
                        break;
                    }
                }

            } catch (IOException e) {
                ventana.agregarMensaje("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
