package Models.Decoradores;

import Models.Comida;
public abstract class ComidaDecorator implements Comida {
    protected Comida comida;
    public ComidaDecorator(Comida comida) {
        this.comida = comida;
    }
    @Override
    public String getDescripcion() {
        return comida.getDescripcion();
    }
    @Override
    public double getCosto() {
        return comida.getCosto();
    }
}