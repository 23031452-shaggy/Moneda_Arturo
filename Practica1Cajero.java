import java.util.Scanner;
import java.util.Stack;
public class Practica1Cajero {
    public static void main(String[] args) {
        UsuarioManejo obj = new UsuarioManejo();
        System.out.println("=== Bienvenido al Cajero ===");
        obj.sesion();
        try
        {
            System.out.println("Bienvenido, " + obj.nombres[obj.usuarioActual]);
        }catch (java.lang.ArrayIndexOutOfBoundsException e)
        {
            return;
        }
        obj.interfaz();
    }
}
class UsuarioManejo
{
    Stack pila = new Stack();
    Stack copia = new Stack();
    int intentos = 0;
    int usuarioActual = -1;
    String[] usuarios = {"1234", "5678"};
    String[] nombres = {"Juan", "Maria"};
    boolean salir = false;
    Scanner scanner = new Scanner(System.in);
    double[] saldos = {1000.0, 2500.0};
    public void interfaz()
    {
        while(!salir)
        {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.println("5 mostrar historial");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
            if (opcion == 1) {
                System.out.println("Su saldo es: $" + saldos[usuarioActual]);
            } else if (opcion == 2) {
                System.out.print("Ingrese cantidad a retirar: ");
                double retiro = scanner.nextDouble();
                if (retiro <= saldos[usuarioActual]) {
                    saldos[usuarioActual] -= retiro;
                    pila.push("Retiro de " + retiro);
                    System.out.println("Retiro exitoso. Nuevo saldo: $" + saldos[usuarioActual]);
                } else {
                    System.out.println("Fondos insuficientes.");
                }
            } else if (opcion == 3) {
                System.out.print("Ingrese cantidad a depositar: ");
                double deposito = scanner.nextDouble();
                pila.push("deposito de " + deposito);
                saldos[usuarioActual] += deposito;
                System.out.println("Depósito exitoso. Nuevo saldo: $" + saldos[usuarioActual]);
            } else if (opcion == 4) {
                salir = true;
                System.out.println("Gracias por usar el cajero.");
            } else if (opcion == 5) {
                System.out.println("este es tu historial de movimientos");
                System.out.println(pila.clone());
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
    public void sesion()
    {
        while (intentos < 3 && usuarioActual == -1) {
            System.out.print("Ingrese su PIN: ");
            String pin = scanner.nextLine();
            for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].equals(pin)) {
                    usuarioActual = i;
                    break;
                }
            }
            if (usuarioActual == -1) {
                System.out.println("PIN incorrecto.");
                intentos++;
            }
            if (intentos == 3)
            {
                System.out.println("USUARIO NO AUTORIZADO, CERRANDO PROGRAMA");
                return;
            }
        }
    }
}
