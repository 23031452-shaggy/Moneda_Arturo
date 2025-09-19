package strategies;
import models.CajeroModel;
import views.CajeroView;
public class RealizarRetiroStrategy implements Strategy
{
    @Override
    public void ejecutar(CajeroModel model, CajeroView view)
    {
        double cantidad = view.solicitarCantidad("Retirar ");
        if (cantidad <= 0)
        {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarRetiro(cantidad))
        {
            view.mostrarMensaje("Retiro exitoso de " + cantidad);
        }
        else
        {
            view.mostrarMensaje("Fondos insuficientes");
        }
    }
}
