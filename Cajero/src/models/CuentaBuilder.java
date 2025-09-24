package models;
public class CuentaBuilder {
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;

    private boolean cuentaActiva = true;
    private boolean permiteTransferencias = true;

    public CuentaBuilder numeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        return this;
    }

    public CuentaBuilder pin(String pin) {
        this.pin = pin;
        return this;
    }

    public CuentaBuilder saldo(double saldo) {
        this.saldo = saldo;
        return this;
    }

    public CuentaBuilder titular(String titular) {
        this.titular = titular;
        return this;
    }

    public CuentaBuilder cuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
        return this;
    }

    public CuentaBuilder permiteTransferencias(boolean permiteTransferencias) {
        this.permiteTransferencias = permiteTransferencias;
        return this;
    }

    public Cuenta build() {
        Cuenta cuenta = new Cuenta(numeroCuenta, pin, saldo, titular);
        cuenta.setCuentaActiva(cuentaActiva);
        cuenta.setPermiteTransferencias(permiteTransferencias);
        return cuenta;
    }
}
