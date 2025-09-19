public class Context
{
    private Strategy strategy;
    public Context(Strategy strategy)
    {
        this.strategy = strategy;
    }
    public double Venta(double amount)
    {
        return strategy.precioVenta(amount);
    }
    public double Compra(double amount)
    {
        return strategy.precioCompra(amount);
    }
}