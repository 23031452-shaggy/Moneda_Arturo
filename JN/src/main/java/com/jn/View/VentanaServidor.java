package com.jn.View;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaServidor {
    private ObservableList<String> mensajes;

    public VentanaServidor(Stage stage) {
        mensajes = FXCollections.observableArrayList();

        ListView<String> lista = new ListView<>(mensajes);
        lista.setStyle("-fx-control-inner-background: #ee0011; ");
        VBox root = new VBox(lista);
        root.setStyle("-fx-background-color: #1eeee1; -fx-font-family: 'Overdrive Sunset'; -fx-font-size: 20px ");

        Scene escena = new Scene(root, 500, 300);
        stage.setTitle("Servidor - Mensajes Recibidos");
        stage.setScene(escena);
        stage.show();
    }

    public void agregarMensaje(String texto) {
        Platform.runLater(() -> mensajes.add(texto));
    }
}
