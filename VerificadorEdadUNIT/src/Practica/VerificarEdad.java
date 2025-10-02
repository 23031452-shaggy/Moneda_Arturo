package Practica;

public class VerificarEdad
{
    public static void edad(int año)
    {
        if (esMayorDeEdad(año)) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }
    }
    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }
}
