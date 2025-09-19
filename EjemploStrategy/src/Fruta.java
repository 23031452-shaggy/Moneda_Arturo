public class Fruta implements Strategy
{

    @Override
    public double precioCompra(double a)
    {
        System.out.println("El valor de compra de la fruta es: " + a*5/6);
        return a*7/10;
    }
    @Override
    public double precioVenta(double a)
    {
        System.out.println("El valor de venta de la fruta es: " + a*6/5);
        return a*11/10;
    }
}
