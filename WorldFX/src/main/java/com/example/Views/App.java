package com.example.Views;

import com.example.Controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Controller controller = new Controller();
        VentanaPrincipal view = new VentanaPrincipal(controller);
        view.mostrar(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
