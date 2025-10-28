package Models.Decoradores;

import Models.Comida;
public class Jamon extends ComidaDecorator {

    public Jamon(Comida comida) {
        super(comida);
    }

    @Override
    public String getDescripcion() {
        return comida.getDescripcion() + " + Jamon";
    }

    @Override
    public double getCosto() {
        return comida.getCosto() + 8.0;
    }
}