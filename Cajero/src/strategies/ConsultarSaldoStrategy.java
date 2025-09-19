package strategies;
import models.CajeroModel;
import views.CajeroView;
public class ConsultarSaldoStrategy implements Strategy
{
    @Override
    public void ejecutar(CajeroModel model, CajeroView view)
    {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
}
