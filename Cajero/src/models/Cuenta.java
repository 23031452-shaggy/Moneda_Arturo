package models;
import java.security.MessageDigest;
/**
 * @author Arturo
 */
public class Cuenta {
    private boolean cuentaActiva = true;
    private boolean permiteTransferencias = true;
    /** Número de cuenta bancaria. */
    private String numeroCuenta;

    /** NIP o PIN asociado a la cuenta. */
    private String pin;

    /** Saldo actual de la cuenta. */
    private double saldo;

    /** Nombre del titular de la cuenta. */
    private String titular;
    /*
     * Crea una nueva cuenta bancaria.
     * @param numeroCuenta número único de cuenta
     * @param pin PIN inicial
     * @param saldoInicial saldo con el que inicia la cuenta
     * @param titular nombre del titular de la cuenta
     */
    public Cuenta(String numeroCuenta, String pin, double saldoInicial, String titular)
    {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }
    public void setCuentaActiva(boolean cuentaActiva) {
        this.cuentaActiva = cuentaActiva;
    }

    public void setPermiteTransferencias(boolean permiteTransferencias) {
        this.permiteTransferencias = permiteTransferencias;
    }
    public boolean getCuentaActiva() {
        return cuentaActiva;
    }
    public boolean getPermiteTransferencias() {
        return permiteTransferencias;
    }

    /**
     * Obtiene el número de cuenta.
     * @return número de cuenta
     */
    public String getNumeroCuenta()
    {
        return numeroCuenta;
    }

    /**
     * Obtiene el PIN asociado a la cuenta.
     * @return PIN de la cuenta
     */
    public String getPin()
    {
        return pin;
    }
    /**
     * Obtiene el saldo actual de la cuenta.
     * @return saldo actual
     */
    public double getSaldo()
    {
        return saldo;
    }
    /**
     * Obtiene el nombre del titular de la cuenta.
     * @return titular de la cuenta
     */
    public String getTitular()
    {
        return titular;
    }
    /**
     * Valida si el PIN ingresado coincide con el de la cuenta.
     * @param pinIngresado PIN a validar
     * @return {true} si el PIN coincide, {false} en caso contrario
     */
    public boolean validarPin(String pinIngresado)
    {
        return this.pin.equals(pinIngresado);
    }
    /**
     * Retira una cantidad de dinero de la cuenta si hay saldo suficiente.
     * @param cantidad monto a retirar
     * @return {true} si el retiro fue exitoso, {false} si no se pudo realizar
     */
    public boolean retirar(double cantidad)
    {
        if(cantidad > 0 && cantidad <= this.saldo)
        {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    /**
     * Deposita una cantidad de dinero en la cuenta.
     * @param cantidad monto a depositar
     * @return {true} si el depósito fue exitoso, {false} si la cantidad no es válida
     */
    public boolean depositar(double cantidad)
    {
        if(cantidad > 0)
        {
            saldo += cantidad;
            return true;
        }
        return false;
    }
    /**
     * Transfiere dinero desde esta cuenta a otra (se descuenta de esta cuenta).
     * @param cantidad monto a transferir
     * @return {true} si la transferencia (retiro) fue exitosa, {false} en caso contrario
     */
    public boolean transferir(double cantidad)
    {
        return retirar(cantidad);

    }
    /**
     * Cambia el NIP (PIN) de la cuenta.
     * @param pinNuevo nuevo PIN
     */
    public void CambiarNip(String pinNuevo)
    {
        pin = pinNuevo;
    }
}
