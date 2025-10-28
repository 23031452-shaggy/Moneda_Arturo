package Models;

public class Pizza implements Comida {

    @Override
    public String getDescripcion() {
        return "Pizza simple";
    }

    @Override
    public double getCosto() {
        return 20.0;
    }
}