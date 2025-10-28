package Models.Decoradores;

import Models.Comida;

public class Chorizo extends ComidaDecorator {

    public Chorizo(Comida comida) {
        super(comida);
    }

    @Override
    public String getDescripcion() {
        return comida.getDescripcion() + " + Chorizo";
    }

    @Override
    public double getCosto() {
        return comida.getCosto() + 5.0;
    }
}
