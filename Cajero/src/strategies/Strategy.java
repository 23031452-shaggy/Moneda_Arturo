package strategies;
import models.CajeroModel;
import views.CajeroView;
public interface Strategy
{
    void ejecutar(CajeroModel model, CajeroView view);
}
