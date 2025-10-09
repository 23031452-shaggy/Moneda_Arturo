package com.example.controller;
import com.example.dao.InterfazDAO;
import com.example.dao.UsuarioDAO;
import com.example.model.UsuarioBuilder;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserController {
    private final InterfazDAO interfazDAO;

    public UserController() throws SQLException {
        interfazDAO = new UsuarioDAO();
    }

    public String registro(String nombre, LocalDate nacimiento, String Usuario, String correo,
                           String Contraseña, String confirm) throws SQLException {
        if (nombre.isBlank() || Usuario.isBlank() || correo.isBlank() || Contraseña.isBlank() || confirm.isBlank() || nacimiento == null)
            return "Completa todos los campos.";

        if (!Contraseña.equals(confirm)) return "Las contraseñas no coinciden.";
        if (interfazDAO.findByUsername(Usuario) != null) return "El usuario ya existe.";
        if (interfazDAO.findByCorreo(correo) != null) return "El correo ya está registrado.";
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) return "Correo inválido.";
        if (!isPasswordStrong(Contraseña)) return "Contraseña débil.";

        String hashed = BCrypt.hashpw(Contraseña, BCrypt.gensalt());
        UsuarioBuilder usuarioBuilder = new UsuarioBuilder.Builder()
                .setUsuario(Usuario)
                .setCorreo(correo)
                .setPasswordHash(hashed)
                .setNombreCompleto(nombre)
                .setFechaNacimiento(nacimiento)
                .setFechaRegistro(LocalDateTime.now())
                .build();

        return interfazDAO.insert(usuarioBuilder) ? "OK" : "Error al registrar.";
    }

    public UsuarioBuilder login(String dato, String password) throws SQLException {
        UsuarioBuilder u = interfazDAO.findByUsernameOrCorreo(dato);
        if (u != null && BCrypt.checkpw(password, u.getPasswordHash())) {
            return u;
        }
        return null;
    }

    private boolean isPasswordStrong(String intento) {
        return intento.length() >= 8 &&
                intento.matches(".*[A-Z].*") &&
                intento.matches(".*[a-z].*") &&
                intento.matches(".*[0-9].*") &&
                intento.matches(".*[!@#$%^&*()].*");
    }
}
