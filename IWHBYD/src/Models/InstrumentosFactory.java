package Models;
public class InstrumentosFactory
{
    public static Instrumento getInstrumento(String tipo)
    {
        if(tipo.equalsIgnoreCase("GUITARRA"))
        {
            return new Guitarra();
        }
        else if (tipo.equalsIgnoreCase("BATERIA"))
        {
            return new Bateria();
        }
        return null;
    }
}
