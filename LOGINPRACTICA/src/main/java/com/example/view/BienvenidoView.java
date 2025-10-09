package com.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import com.example.model.UsuarioBuilder;

public class BienvenidoView {
    private final VBox root;

    public BienvenidoView(App app, UsuarioBuilder usuarioBuilder) {
        root = new VBox(10);
        root.setPadding(new Insets(20));

        Label lbl = new Label("Bienvenido, " + usuarioBuilder.getNombreCompleto());
        Label lblFecha = new Label("Registrado el: " + usuarioBuilder.getFechaRegistro());
        Button btnSalir = new Button("Cerrar sesión");
        btnSalir.setOnAction(e -> app.VentanaLogin());

        root.getChildren().addAll(lbl, lblFecha, btnSalir);
    }

    public VBox getRoot() {
        return root;
    }
}
