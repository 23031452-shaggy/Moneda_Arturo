public class Cliente
{
    public static void main(String[] args)
    {
        double ValorManzana = 1000;
        double ValorZanahoria = 400;
        Strategy fruta = new Fruta();
        Strategy verdura = new Verdura();
        Context context = new Context(fruta);
        context.Compra(ValorManzana);
        context.Venta(ValorManzana);
        context = new Context(verdura);
        context.Compra(ValorZanahoria);
        context.Venta(ValorZanahoria);
    }
}
