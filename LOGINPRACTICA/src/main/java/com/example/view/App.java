package com.example.view;

import com.example.controller.UserController;
import com.example.model.UsuarioBuilder;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage;
    private UserController controller;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        controller = new UserController();
        VentanaSeleccion();
    }

    public void VentanaLogin() {
        LoginView loginView = new LoginView(this, controller);
        stage.setScene(new Scene(loginView.getRoot(), 400, 250));
        stage.setTitle("Login");
        stage.show();
    }
    public void VentanaSeleccion()
    {
        SeleccionView seleccionView = new SeleccionView(this);
        stage.setScene(new Scene(seleccionView.getRoot(),400,250));
        stage.setTitle("Seleccionar Interfaz");
        stage.show();
    }
    public void VentanaRegistro() {
        RegistroView registroView = new RegistroView(this, controller);
        stage.setScene(new Scene(registroView.getRoot(), 500, 400));
        stage.setTitle("Registro");
    }

    public void VentanaBienvenido(UsuarioBuilder usuarioBuilder) {
        BienvenidoView bienvenidoView = new BienvenidoView(this, usuarioBuilder);
        stage.setScene(new Scene(bienvenidoView.getRoot(), 400, 250));
        stage.setTitle("Bienvenido");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
