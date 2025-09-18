public class cliente
{
    public static void main(String[] args)
    {
        FigurasFactory factory = new FigurasFactory();
        Figura cuadrado = factory.getFigura("cuadrado");
        cuadrado.dibujar();
        Figura circulo = factory.getFigura("circulo");
        circulo.dibujar();
        Figura triangulo = factory.getFigura("Triangulo");
        triangulo.dibujar();
    }
}
