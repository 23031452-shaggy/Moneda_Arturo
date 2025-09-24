public class Restaurante {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza.Builder()
                .masa("Delgada")
                .salsa("Tomate")
                .queso("Mozzarella")
                .pepperoni(true)
                .champinones(true)
                .build();

        Pizza pizza2 = new Pizza.Builder()
                .masa("Gruesa")
                .salsa("BBQ")
                .queso("Cheddar")
                .jamon(true)
                .build();

        System.out.println(pizza1);
        System.out.println(pizza2);
    }
}
