package Models.Decoradores;

import Models.Comida;

public class Salchicha extends ComidaDecorator {

    public Salchicha(Comida comida) {
        super(comida);
    }

    @Override
    public String getDescripcion() {
        return comida.getDescripcion() + " + Salchicha";
    }

    @Override
    public double getCosto() {
        return comida.getCosto() + 6.0;
    }
}