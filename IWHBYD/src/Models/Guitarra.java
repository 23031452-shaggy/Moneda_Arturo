package Models;
public class Guitarra implements Instrumento
{
    @Override
    public void afinar(Object afinado)
    {
        if (afinado instanceof Number)
        {
            System.out.println("Se han afinado " + afinado + " Cuerdas");
        }
        else if(afinado instanceof String)
        {
            System.out.println("Se ha ajustado el "+ afinado + " De la guitarra");
        }
    }
    @Override
    public void tocar()
    {
        System.out.println("Estas tocando la guitarra, ñium ñiñiñium ñiumm");
    }
}
