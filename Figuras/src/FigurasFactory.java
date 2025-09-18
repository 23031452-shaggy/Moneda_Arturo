public class FigurasFactory
{
    public static Figura getFigura(String tipo)
    {
        if(tipo.equalsIgnoreCase("CIRCULO"))
        {
            return new Circulo();
        }
        else if (tipo.equalsIgnoreCase("CUADRADO"))
        {
            return new Cuadrado();
        }
        else if (tipo.equalsIgnoreCase("TRIANGULO"))
        {
            return new Triangulo();
        }
        return null;
    }
}
