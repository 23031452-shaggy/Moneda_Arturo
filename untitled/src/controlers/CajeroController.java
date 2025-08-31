package controlers;

import models.CajeroModel;
import views.CajeroView;

public class CajeroController
{
    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;
    public CajeroController(CajeroModel model, CajeroView view)
    {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }
    public void iniciarSistema()
    {
        view.mostrarBienvenida();
        while (sistemaActivo)
        {
            if(autenticarUsuario())
            {
                ejecutarMenuPrincipal();
            }
            else
            {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero");
    }
    private boolean autenticarUsuario()
    {
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }
    private void ejecutarMenuPrincipal()
    {

    }
}
