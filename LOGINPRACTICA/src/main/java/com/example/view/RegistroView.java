package com.example.view;

import com.example.controller.UserController;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class RegistroView {
    private final GridPane root;

    public RegistroView(App app, UserController controller) {
        root = new GridPane();
        root.setPadding(new Insets(15));
        root.setHgap(10);
        root.setVgap(10);

        Label lblNombre = new Label("Nombre completo:");
        TextField tfNombre = new TextField();

        Label lblFN = new Label("Fecha de nacimiento:");
        DatePicker dpFN = new DatePicker();

        Label lblUser = new Label("Username:");
        TextField tfUser = new TextField();

        Label lblCorreo = new Label("Correo:");
        TextField tfCorreo = new TextField();

        Label lblPass = new Label("Contraseña:");
        PasswordField pfPass = new PasswordField();

        Label lblConf = new Label("Confirmar:");
        PasswordField pfConf = new PasswordField();

        Button btnRegistrar = new Button("Registrar");
        Button btnVolver = new Button("Volver");
        Label lblMsg = new Label();

        root.add(lblNombre, 0, 0); root.add(tfNombre, 1, 0);
        root.add(lblFN, 0, 1); root.add(dpFN, 1, 1);
        root.add(lblUser, 0, 2); root.add(tfUser, 1, 2);
        root.add(lblCorreo, 0, 3); root.add(tfCorreo, 1, 3);
        root.add(lblPass, 0, 4); root.add(pfPass, 1, 4);
        root.add(lblConf, 0, 5); root.add(pfConf, 1, 5);
        root.add(btnRegistrar, 0, 6);
        root.add(btnVolver, 1, 6);
        root.add(lblMsg, 0, 7, 2, 1);

        btnRegistrar.setOnAction(e -> {
            try {
                String msg = controller.registro(
                        tfNombre.getText().trim(),
                        dpFN.getValue(),
                        tfUser.getText().trim(),
                        tfCorreo.getText().trim(),
                        pfPass.getText(),
                        pfConf.getText()
                );
                if ("OK".equals(msg)) {
                    lblMsg.setText("Registro exitoso. Inicia sesión.");
                } else {
                    lblMsg.setText(msg);
                }
            } catch (Exception ex) {
                lblMsg.setText("Error: " + ex.getMessage());
            }
        });

        btnVolver.setOnAction(e -> app.VentanaLogin());
    }

    public GridPane getRoot() {
        return root;
    }
}
