package views;
import controlers.CajeroController;
import models.CajeroModel;
public class CajeroAutomatico
{
    public static void main(String[] args)
    {
        CajeroModel model = new CajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);
        controller.iniciarSistema();
    }
}