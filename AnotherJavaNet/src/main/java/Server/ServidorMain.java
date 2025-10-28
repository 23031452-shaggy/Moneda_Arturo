package Server;

import java.net.*;
import java.io.*;
import java.time.LocalDateTime;

import View.VentanaServidor;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONObject; //Debemos agregar una dependencia
import View.VentanaServidor;
public class ServidorMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VentanaServidor ventana = new VentanaServidor(stage);
    }
    public static void main(String[] args) {
        launch(args);
        int PUERTO = 8080;

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor escuchando en el puerto " + PUERTO);

            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            PrintWriter salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            String comando;
            while ((comando = entrada.readLine()) != null) {
                System.out.println("Comando recibido: " + comando);

                switch (comando.toUpperCase()) {
                    case "IP":
                        InetAddress ipLocal = InetAddress.getLocalHost();
                        salida.println("IP del servidor: " + ipLocal.getHostAddress());
                        break;
                    case "HORA":
                        salida.println("Fecha y hora actual: " + LocalDateTime.now());
                        break;
                    case "API":
                        try {
                            URL url = new URL("https://catfact.ninja/fact");
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            conn.setRequestMethod("GET");
                            conn.setConnectTimeout(5000);
                            conn.setReadTimeout(5000);

                            BufferedReader apiInput = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            StringBuilder respuestaApi = new StringBuilder();
                            String linea;
                            while ((linea = apiInput.readLine()) != null) {
                                respuestaApi.append(linea);
                            }
                            apiInput.close();

                            JSONObject json = new JSONObject(respuestaApi.toString());
                            String fact = json.getString("fact");

                            salida.println("Dato curioso de gato: " + fact);
                        } catch (Exception e) {
                            salida.println("Error al obtener datos de la API: " + e.getMessage());
                        }
                        break;
                    case "SALIR":
                        salida.println("Conexión finalizada.");
                        clienteSocket.close();
                        System.out.println("Cliente desconectado.");
                        return;
                    default:
                        salida.println("Comando no reconocido. Usa IP, HORA, API o SALIR.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}