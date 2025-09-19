public class Verdura implements Strategy
{
    @Override
    public double precioCompra(double a)
    {
        System.out.println("El valor de compra de la verdura es: " + a*8/10);
        return a*8/10;
    }
    @Override
    public double precioVenta(double a)
    {
        System.out.println("El valor de venta de la verdura es: " + a*12/10);
        return a*12/10;
    }
}
