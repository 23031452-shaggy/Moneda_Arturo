package com.example.controller;
import com.example.DataBaseAccess.InterfazDAO;
import com.example.DataBaseAccess.UsuarioDAO;
import com.example.model.UsuarioBuilder;
import com.example.view.ViewsConsola;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserController {
    ViewsConsola VC = new ViewsConsola();
    private final InterfazDAO interfazDAO;
    private boolean fallo = false;
    public UserController() throws SQLException {
        interfazDAO = new UsuarioDAO();
    }

    public String registro(String nombre, LocalDate nacimiento, String Usuario, String correo,
                           String Contraseña, String confirm) throws SQLException {
        if (nombre.isBlank() || Usuario.isBlank() || correo.isBlank() || Contraseña.isBlank() || confirm.isBlank() || nacimiento == null) {
            fallo = true;
            return "Completa todos los campos.";
        }
        if (!Contraseña.equals(confirm))
        {
            fallo = true;
            return "Las contraseñas no coinciden.";
        }
        if (interfazDAO.findByUsername(Usuario) != null)
        {
            fallo = true;
            return "El usuario ya existe.";
        }
        if (interfazDAO.findByCorreo(correo) != null)
        {
            fallo = true;
            return "El correo ya está registrado.";
        }
        if (!correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
        {
            fallo = true;
            return "Correo inválido.";
        }
        if (!isPasswordStrong(Contraseña))
        {
            fallo = true;
            return "Contraseña débil.";
        }

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
    public void IniciarSistemaConsola() throws SQLException {
        VC.MainConsole();
        boolean sessionActiva = true;
        while (sessionActiva)
        {
            int opcion = ViewsConsola.leerOpcion();
            switch (opcion)
            {
                case 1:
                    ConsolaLogin();
                    break;
                case 2:
                    ConsolaRegistrer();
                    break;
                default:
                    VC.Error("Caracter no valido, favor de ingresar otro");
                    IniciarSistemaConsola();
                    break;
            }
        }
    }

    public void ConsolaLogin() throws SQLException {
        String usuario = VC.UsuarioLogin();
        String contraseña = VC.ContraseñaLogin();
        if(usuario.isBlank() || contraseña.isBlank())
        {
            VC.Error("Ambos campos deben estar completos");
            IniciarSistemaConsola();
        }
        UsuarioBuilder u = login(usuario,contraseña);
        if(u != null)
        {
            if (VC.BienvenidaUsuario(u))
            {
                IniciarSistemaConsola();
            }
        }
        else
        {
            VC.Error("Cuenta no encontrada");
            IniciarSistemaConsola();
        }
    }
    public void ConsolaRegistrer() throws SQLException {
        String nombre = VC.NombreRegistrer();
        LocalDate nacimiento = null;
        String Usuario = VC.UsuarioRegistrer();
        String correo = VC.CorreoRegistrer();
        String Contraseña = VC.ContraseñaRegistrer();
        String confirm = VC.ConfirmarRegistrer();
        try {
            nacimiento = VC.FechaNacimiento();
        } catch (Exception e) {
            VC.Error("Formato de Fecha no valido");
            IniciarSistemaConsola();
        }
        System.out.println(registro(nombre, nacimiento, Usuario, correo, Contraseña, confirm));
        if (fallo = true) {
            fallo = false;
            IniciarSistemaConsola();
        }
    }

}
