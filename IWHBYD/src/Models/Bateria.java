package Models;
public class Bateria implements Instrumento
{
    @Override
    public void afinar(Object afinado)
    {
        if (afinado instanceof Number)
        {
            System.out.println("Se han reparado y mejorado " + afinado + " tambores");
        }
        else if(afinado instanceof String)
        {
            System.out.println("Se ha lubricado "+ afinado + " De la bateria");
        }
    }
    @Override
    public void tocar()
    {
        System.out.println("Estas tocando la bateria, tucututunnnnnnnnnn");
    }
}
