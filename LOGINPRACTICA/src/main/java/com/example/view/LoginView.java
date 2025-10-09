package com.example.view;

import com.example.controller.UserController;
import com.example.model.UsuarioBuilder;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class LoginView {
    private final GridPane root;

    public LoginView(App app, UserController controller) {
        root = new GridPane();
        root.setPadding(new Insets(20));
        root.setVgap(10);
        root.setHgap(10);

        Label lblUser = new Label("Usuario o correo:");
        TextField tfUser = new TextField();

        Label lblPass = new Label("Contraseña:");
        PasswordField pfPass = new PasswordField();

        Button btnLogin = new Button("Iniciar sesión");
        Button btnRegister = new Button("Registrarse");
        Label lblMsg = new Label();

        root.add(lblUser, 0, 0); root.add(tfUser, 1, 0);
        root.add(lblPass, 0, 1); root.add(pfPass, 1, 1);
        root.add(btnLogin, 0, 2);
        root.add(btnRegister, 1, 2);
        root.add(lblMsg, 0, 3, 2, 1);

        btnLogin.setOnAction(e -> {
            try {
                String dato = tfUser.getText().trim();
                String pass = pfPass.getText();
                if (dato.isBlank() || pass.isBlank()) {
                    lblMsg.setText("Rellena todos los campos.");
                    return;
                }
                UsuarioBuilder u = controller.login(dato, pass);
                if (u != null) {
                    app.VentanaBienvenido(u);
                } else {
                    lblMsg.setText("Datos incorrectos.");
                }
            } catch (Exception ex) {
                lblMsg.setText("Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        btnRegister.setOnAction(e -> app.VentanaRegistro());
    }

    public GridPane getRoot() {
        return root;
    }
}
