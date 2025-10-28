import Models.Comida;
import Models.Pizza;
import Models.Decoradores.Peperonni;
import Models.Decoradores.Jamon;
import Models.Decoradores.Salchicha;
import Models.Decoradores.Chorizo;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE PIZZERIA CON DECORATOR ===\n");
        Comida comida1 = new Pizza();
        System.out.println("1. " + comida1.getDescripcion());
        System.out.println("   Costo: $" + comida1.getCosto());
        System.out.println();
        Comida comida2 = new Chorizo(new Pizza());
        System.out.println("2. " + comida2.getDescripcion());
        System.out.println("   Costo: $" + comida2.getCosto());
        System.out.println();
        Comida comida3 = new Jamon(new Chorizo(new Pizza()));
        System.out.println("3. " + comida3.getDescripcion());
        System.out.println("   Costo: $" + comida3.getCosto());
        System.out.println();
        Comida comida4 = new Salchicha(new Jamon(new Chorizo(new Pizza())));
        System.out.println("4. " + comida4.getDescripcion());
        System.out.println("   Costo: $" + comida4.getCosto());
        System.out.println();
        Comida comida5 = new Jamon(new Jamon(new Pizza()));
        System.out.println("5. " + comida5.getDescripcion());
        System.out.println("   Costo: $" + comida5.getCosto());
        System.out.println();
        Comida comida6 = new Jamon(new Salchicha(new Pizza()));
        System.out.println("6. " + comida6.getDescripcion());
        System.out.println("   Costo: $" + comida6.getCosto());
        System.out.println();
        Comida comida7 = new Peperonni(new Pizza());
        System.out.println("7. " + comida7.getDescripcion());
        System.out.println("   Costo: $" + comida7.getCosto());
        System.out.println();
        Comida comida8 = new Peperonni(new Chorizo(new Pizza()));
        System.out.println("8. " + comida8.getDescripcion());
        System.out.println("   Costo: $" + comida8.getCosto());
        System.out.println();
        Comida comida9 = new Peperonni(new Salchicha(new Jamon(new Chorizo(new Pizza()))));
        System.out.println("9. " + comida9.getDescripcion());
        System.out.println("   Costo: $" + comida9.getCosto());
        System.out.println();
        Comida comida10 = new Peperonni(new Peperonni(new Pizza()));
        System.out.println("10. " + comida10.getDescripcion());
        System.out.println("    Costo: $" + comida10.getCosto());
        System.out.println();
        Comida comida11 = new
                Peperonni(new Peperonni(new Jamon(new Jamon(new Salchicha(new Peperonni(new Pizza()))))));
        System.out.println("11. " + comida11.getDescripcion());
        System.out.println("    Costo: $" + comida11.getCosto());
        System.out.println("=== ¡Pizzas Terminadas! ===");
    }
}