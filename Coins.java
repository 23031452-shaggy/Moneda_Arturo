import java.util.Stack;
import java.util.Scanner;
public class Coins
{
    static Stack dinero = new Stack<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int cont1 = 0;
        int cont2 = 0;
        int cont5 = 0;
        int cont10 = 0;
        int cont20 = 0;
        int cont50 = 0;
        int cont100 = 0;
        int cont200 = 0;
        int cont500 = 0;
        Coins monedas = new Coins();
        System.out.println("Cuantos billetes de 1 euro tiene");
        monedas.LlenarPila(1);
        System.out.println("Cuantos billetes de 2 euros tiene");
        monedas.LlenarPila(2);
        System.out.println("Cuantos billetes de 5 euros tiene");
        monedas.LlenarPila(5);
        System.out.println("Cuantos billetes de 10 euros tiene");
        monedas.LlenarPila(10);
        System.out.println("Cuantos billetes de 20 euros tiene");
        monedas.LlenarPila(20);
        System.out.println("Cuantos billetes de 50 euros tiene");
        monedas.LlenarPila(50);
        System.out.println("Cuantos billetes de 100 euros tiene");
        monedas.LlenarPila(100);
        System.out.println("Cuantos billetes de 200 euros tiene");
        monedas.LlenarPila(200);
        System.out.println("Cuantos billetes de 500 euros tiene");
        monedas.LlenarPila(500);
        System.out.println("Ingrese la cantidad de dinero que necesita");
        int lana = sc.nextInt();
        while (lana > 0 && dinero.isEmpty() == false) {
            int billete = (int) dinero.peek();
            if (billete <= lana) {
                dinero.pop();
                lana = lana - billete;
                switch (billete) {
                    case 500 -> cont500++;
                    case 200 -> cont200++;
                    case 100 -> cont100++;
                    case 50 -> cont50++;
                    case 20 -> cont20++;
                    case 10 -> cont10++;
                    case 5 -> cont5++;
                    case 2 -> cont2++;
                    case 1 -> cont1++;
                }
            } else {
                dinero.pop();
            }
        }
        if (lana >= (cont1) + (cont2 * 2) + (cont5 * 5) + (cont10 * 10) + (cont20 * 20) + (cont50 * 50) + (cont100 * 100) + (cont200 * 200) + (cont500 * 500)) {
            System.out.println("NO CUENTAS CON FONDOS SUFICIENTES");
        } else {
            System.out.println("fueron " + cont500 + " de 500, " + cont200 + " de 200, " + cont100 + " de 100, "
                    + cont50 + " de 50, " + cont20 + " de 20, " + cont10 + " de 10, " + cont5 + " de 5, " + cont2 + " de 2 y " + cont1 + " de 1");

        }
    }
    public void LlenarPila(int a)
    {
        int contador = sc.nextInt();
        for(int i = 0; i < contador; i++)
        {
            dinero.push(a);
        }
    }
}