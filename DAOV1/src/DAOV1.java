/*
-- Crear base de datos
CREATE DATABASE IF NOT EXISTS escuela
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_general_ci;
USE escuela;
CREATE TABLE IF NOT EXISTS estudiantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) UNIQUE NOT NULL
);

INSERT INTO estudiantes (nombre, correo) VALUES
('Juan Pérez', 'juan.perez@mail.com'),
('Ana López', 'ana.lopez@mail.com'),
('Carlos Ruiz', 'carlos.ruiz@mail.com');
*/

import java.util.List;
import java.sql.*;
import java.util.*;

class Estudiante {
    private int id;
    private String nombre;
    private String correo;

    // Constructores
    public Estudiante() {}
    public Estudiante(int id, String nombre, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
}


interface EstudianteDAO {
    void insertar(Estudiante e);
    Estudiante obtenerPorId(int id);
    List<Estudiante> listar();
    void actualizar(Estudiante e);
    void eliminar(int id);
}




class EstudianteDAOImpl implements EstudianteDAO {
    private Connection conn;

    public EstudianteDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Estudiante e) {
        String sql = "INSERT INTO estudiantes (nombre, correo) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getCorreo());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Estudiante obtenerPorId(int id) {
        String sql = "SELECT * FROM estudiantes WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Estudiante(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo")
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    @Override
    public void actualizar(Estudiante e) {
        String sql = "UPDATE estudiantes SET nombre=?, correo=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNombre());
            stmt.setString(2, e.getCorreo());
            stmt.setInt(3, e.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE FROM estudiantes WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

public class DAOV1 {
    public static void main(String[] args) {
        ConfiguracionBD config = ConfiguracionBD.getInstancia();
        config.mostrarConfiguracion();
        try (Connection conn = config.getConexion()) {
            EstudianteDAO dao = new EstudianteDAOImpl(conn);

            // Insertar
            dao.insertar(new Estudiante(0, "Oscar", "oscar14@mail.com"));

            // Listar
            for (Estudiante e : dao.listar()) {
                System.out.println(e.getId() + " - " + e.getNombre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class ConfiguracionBD {
    private static ConfiguracionBD instancia;
    private String url;
    private String usuario;
    private String password;

    private ConfiguracionBD() {
        this.url = "jdbc:mysql://localhost:3306/escuela";
        this.usuario = "root";
        this.password = "turomon11";
    }

    public static ConfiguracionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionBD();
        }
        return instancia;
    }

    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUsuario()
    {
        return usuario;
    }
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    { this.password = password;
    }

    public Connection getConexion() {
        try {
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void mostrarConfiguracion() {
        System.out.println("URL: " + url);
        System.out.println("Usuario: " + usuario);
        System.out.println("Password: " + password);
    }
}
