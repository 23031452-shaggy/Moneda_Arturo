package Views;

import java.util.Scanner;

public class InstrumentosViews
{
    private Scanner scanner = new Scanner(System.in);
    public void mostrarMenuPrincipal()
    {
        System.out.println("==================================================================");
        System.out.println("Bienvenido de vuelta arturo, escribe el instrumento que eliges hoy");
        System.out.println("==================================================================");
        System.out.println("1.- Guitarra");
        System.out.println("2.- Bateria");
        System.out.println("3.- Salir");
    }
    public void menuGuitarra()
    {
        System.out.println("Que desea hacer con su guitarra ");
        System.out.println("1.- Afinar");
        System.out.println("2.- Ajustar");
        System.out.println("3.- tocar");
    }
    public void menuBateria()
    {
        System.out.println("Que desea hacer con su bateria");
        System.out.println("1.- Reparar tambores ");
        System.out.println("2.- Lubricar piezas");
        System.out.println("3.- tocar");
    }
    public int leerOpcion()
    {
        try
        {
            return Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
    }
    public Object leer()
    {
        return scanner.nextLine();
    }
    public void salir()
    {
        System.out.println("Eso es todo");
        scanner.close();
        System.exit(0);
    }
}
