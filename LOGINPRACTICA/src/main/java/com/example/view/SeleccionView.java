package com.example.view;

import com.example.controller.UserController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SeleccionView
{
    private final GridPane root;
    public SeleccionView(App app)
    {
        root = new GridPane();
        root.setPadding(new Insets(15));
        root.setHgap(10);
        root.setVgap(10);
        Label text = new Label("favor de ingresar con que interfaz desea continuar:");
        Button FX = new Button("JAVAFX");
        Button CONSOLE = new Button("Consola");
        root.add(text, 0, 0);
        root.add(FX,0,1);
        root.add(CONSOLE,1,1);
        FX.setOnAction(e ->
            app.VentanaLogin()
        );
        CONSOLE.setOnAction(e ->
        {
            Stage stage = (Stage) CONSOLE.getScene().getWindow();
            stage.close();
            try {
                UserController UC = new UserController();
                UC.IniciarSistemaConsola();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }
    public GridPane getRoot() {
        return root;
    }
}
