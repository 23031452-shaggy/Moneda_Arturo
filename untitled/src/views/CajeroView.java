package views;
import java.util.Scanner;
public class CajeroView
{
    private Scanner scanner;
    public CajeroView() {
        scanner = new Scanner(System.in);
    }
    public void mostrarBienvenida()
    {
        System.out.println("===================================================");
        System.out.println("Bienvenido al cajero automatico del banco del bajio");
        System.out.println("===================================================");
    }
    public String solicitarNumeroCuenta()
    {
        System.out.println("Ingresa tu numero de cuenta: ");
        return scanner.nextLine();
    }
    public String solicitarPin()
    {
        System.out.println("Ingresa tu PIN: ");
        return scanner.nextLine();
    }
    public void mostrarMenuPrincipal(String titular)
    {
        System.out.println("================================");
        System.out.println("Bienvenid@" + titular);
        System.out.println("================================");
        System.out.println("1.- Consultar saldo");
        System.out.println("2.- Retirar");
        System.out.println("3.- Depositar");
        System.out.println("4.- Transferir");
        System.out.println("5.- Cambiar NIP");
        //Tarea: Definir opciones restantes COMPLETO?
        System.out.println("6.- salir");
    }
    public int leerOpcion()
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
    public void mostrarSaldo (double saldo)
    {
        System.out.println("================================");
        System.out.println("Tu saldo actual es de : $" + saldo);
        System.out.println("================================");
    }
    public double solicitarCantidad(String operacion)
    {
        System.out.println("Ingresa la cantidad a " + operacion + ": ");
        try
        {
            return Double.parseDouble(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
    public void mostrarMensaje(String mensaje)
    {
        System.out.println("====== " + mensaje);
    }
    public boolean salir()
    {
        mostrarMensaje("Tenga un Buen dia");
        scanner.close();
        return false;
    }
    //Tarea personalizar mensajes de error y de exito COMPLETO?
    //Tarea metodo para salir y cerrar el scanner COMPLETO
}