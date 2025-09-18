package Controllers;
import Views.*;
import Models.*;
public class InstrumentosController
{
    InstrumentosFactory factory = new InstrumentosFactory();
    InstrumentosViews view = new InstrumentosViews();
    private boolean sistemaActivo = true;
    public void iniciarSistema()
    {
        while (sistemaActivo)
        {
            EjecutarMenuPrincipal();
        }
    }
    private void EjecutarMenuPrincipal()
    {
        boolean activo = true;
        while (activo) {
            view.mostrarMenuPrincipal();
            int opcion = view.leerOpcion();
            switch (opcion)
            {
                case 1:
                    menuGuitarra();
                    break;
                case 2:
                    menuBateria();
                    break;
                case 3:
                    view.salir();
                    break;
            }
        }
    }
    public void menuGuitarra()
    {
        view.menuGuitarra();
        Instrumento guitarra = factory.getInstrumento("Guitarra");
        int opcion = view.leerOpcion();
        switch (opcion)
        {
            case 1:
                System.out.println("Cuantas cuerdas quieres afinar ");
                guitarra.afinar(view.leerOpcion());
                break;
            case 2:
                System.out.println("Que pieza desea reparar ");
                guitarra.afinar(view.leer());
                break;
            case 3:
                guitarra.tocar();
        }
    }
    public void menuBateria()
    {
        view.menuBateria();
        Instrumento tambor = factory.getInstrumento("Bateria");
        int opcion = view.leerOpcion();
        switch (opcion)
        {
            case 1:
                System.out.println("Cuantos tambores desea reparar ");
                tambor.afinar(view.leerOpcion());
                break;
            case 2:
                System.out.println("Que pieza desea lubricar ");
                tambor.afinar(view.leer());
                break;
            case 3:
                tambor.tocar();
        }
    }
}
