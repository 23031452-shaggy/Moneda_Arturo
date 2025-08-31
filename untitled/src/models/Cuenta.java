package models;

public class Cuenta
{
    private String numeroCuenta;
    private String pin;
    private double saldo;
    private String titular;
    public Cuenta(String numeroCuenta, String pin, double saldoInicial, String titular)
    {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldoInicial;
        this.titular = titular;
    }
    public String getNumeroCuenta()
    {
        return numeroCuenta;
    }
    public String getPin()
    {
        return pin;
    }
    public double getSaldo()
    {
        return saldo;
    }
    public String getTitular()
    {
        return titular;
    }

    //Reglas de negocio

    public boolean validarPin(String pinIngresado)
    {
        return this.pin.equals(pinIngresado);
    }
    public boolean retirar(double cantidad)
    {
        if(cantidad > 0 && cantidad <= this.saldo)
        {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    public boolean depositar(double cantidad)
    {
        if(cantidad > 0)
        {
            saldo += cantidad;
            return true;
        }
        return false;
    }
    public boolean transferir(double cantidad)
    {
        return retirar(cantidad);
    }
    public void CambiarNip(String pinNuevo)
    {
        pin = pinNuevo;
    }
    //Tarea: diesñar los comportamientos restantes
    //Transferir COMPLETO
    //Cambiar NIP COMPLETO?
}
