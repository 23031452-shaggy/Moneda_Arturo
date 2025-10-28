package Models.Decoradores;

import Models.Comida;

public class Peperonni extends ComidaDecorator {
    public Peperonni(Comida comida) { super(comida); }
    @Override
    public String getDescripcion() { return comida.getDescripcion() + " + Peperonni"; }
    @Override
    public double getCosto() {
        return comida.getCosto() + 2.0;
    }
}

