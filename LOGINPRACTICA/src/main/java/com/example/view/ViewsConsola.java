package com.example.view;
import com.example.model.UsuarioBuilder;

import java.time.LocalDate;
import java.util.Scanner;

public class ViewsConsola
{
    private static Scanner scanner = new Scanner(System.in);
    public static int leerOpcion()
    {
        try
        {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
    public void MainConsole()
    {
        System.out.println("===========");
        System.out.println("1.- Login");
        System.out.println("2.- Register");
        System.out.println("===========");
    }
    public String UsuarioLogin()
    {
        System.out.println("Usuario o correo");
        return scanner.nextLine();
    }
    public String ContraseñaLogin()
    {
        System.out.println("Contraseña");
        return scanner.nextLine();
    }
    public boolean BienvenidaUsuario(UsuarioBuilder builder)
    {
        System.out.println("Bienvenido " + builder.getNombreCompleto());
        System.out.println("Registrado el " + builder.getFechaRegistro());
        System.out.println("Presione Enter para cerrar sesion");
        scanner.next();
        return true;
    }
    public String NombreRegistrer()
    {
        System.out.println("Inserte su nombre");
        return scanner.nextLine();
    }
    public LocalDate FechaNacimiento()
    {

        System.out.println("Inserte su fecha de nacimiento");
        return LocalDate.parse(scanner.nextLine());
    }
    public String UsuarioRegistrer()
    {
        System.out.println("Inserte su nombre de usuario");
        return scanner.nextLine();
    }
    public String CorreoRegistrer()
    {
        System.out.println("Ingrese correo");
        return scanner.nextLine();

    }
    public String ContraseñaRegistrer()
    {
        System.out.println("Ingrese Contraseña");
        return scanner.nextLine();
    }
    public String ConfirmarRegistrer()
    {
        System.out.println("Confirma contraseña");
        return scanner.nextLine();
    }
    public void Error(String mensaje){
        System.out.println("Ha ocurrido un error en: " + mensaje);
    }
}
