package views;
import java.util.Scanner;
/**
 * Representa la vista de un cajero automático en consola.
 */
public class CajeroView
{
    /** Objeto para leer entradas desde la consola. */
    private Scanner scanner;
    /**
     * Crea una nueva vista del cajero automático e inicializa el {Scanner}.
     */
    public CajeroView() {
        scanner = new Scanner(System.in);
    }
    /**
     * Muestra el mensaje de bienvenida del cajero.
     */
    public void mostrarBienvenida()
    {
        System.out.println("===================================================");
        System.out.println("Bienvenido al cajero automatico del banco del bajio");
        System.out.println("===================================================");
    }
    /**
     * Solicita al usuario que ingrese su número de cuenta.
     * @return número de cuenta ingresado por el usuario
     */
    public String solicitarNumeroCuenta()
    {
        System.out.println("Ingresa tu numero de cuenta: ");
        return scanner.nextLine();
    }
    /**
     * Solicita al usuario que ingrese su PIN.
     * @return PIN ingresado por el usuario
     */
    public String solicitarPin()
    {
        System.out.println("Ingresa tu PIN: ");
        return scanner.nextLine();
    }
    /**
     * Muestra el menú principal con las opciones disponibles para el usuario.
     * @param titular nombre del titular de la cuenta autenticada
     */
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
        System.out.println("6.- salir");
        System.out.println("7.- Consultar saldo con Strategy");
        System.out.println("8.- Realizar retiro con Strategy");
    }
    /**
     * Lee la opción seleccionada por el usuario desde la consola.
     * @return número de opción seleccionada, o {-1} si la entrada no es válida
     */
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
    /**
     * Muestra el saldo actual del usuario.
     * @param saldo saldo a mostrar
     */
    public void mostrarSaldo(double saldo)
    {
        System.out.println("================================");
        System.out.println("Tu saldo actual es de : $" + saldo);
        System.out.println("================================");
    }
    /**
     * Solicita al usuario una cantidad de dinero para una operación.
     * @param operacion nombre de la operación a realizar
     * @return cantidad ingresada por el usuario, o {-1} si la entrada no es válida
     */
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
    /**
     * Muestra un mensaje genérico al usuario.
     * @param mensaje mensaje a mostrar
     */
    public <T> void mostrarMensaje(T mensaje)
    {
        System.out.println("====== " + mensaje);
    }
    /**
     * Finaliza la sesión en el cajero, mostrando un mensaje de despedida,
     * cerrando el {Scanner} y terminando la aplicación.
     */
    public void salir()
    {
        mostrarMensaje("Tenga un buen dia");
        scanner.close();
        System.exit(0);
    }
}
