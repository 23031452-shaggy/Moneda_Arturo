package models;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa el modelo de un cajero automático que gestiona cuentas bancarias.
 */
public class CajeroModel
{
    /** Colección de cuentas disponibles en el cajero, identificadas por número de cuenta. */
    private Map<String, Cuenta> cuentas;
    /** Cuenta actualmente autenticada en el cajero. */
    private Cuenta cuentaActual;
    /**
     * Crea una nueva instancia del modelo de cajero e inicializa las cuentas.
     */
    public CajeroModel()
    {
        cuentas = new HashMap<String, Cuenta>();
        inicializarCuentas();
    }
    /**
     * Inicializa un conjunto de cuentas predeterminadas en el cajero.
     */
    private void inicializarCuentas()
    {
        cuentas.put("12345", new Cuenta("12345", "1111", 5000, "Pedro Perez Pereira"));
        cuentas.put("67890", new Cuenta("67890", "1234", 3500, "Pobre Pintor Portugues"));
        cuentas.put("09876", new Cuenta("09876", "5678", 7350, "Pinta Preciosos Paisajes"));
    }
    /**
     * Autentica una cuenta en el cajero verificando número de cuenta y NIP.
     * @param numeroCuenta número de cuenta a autenticar
     * @param pin NIP asociado a la cuenta
     * @return {true} si la autenticación fue exitosa, {false} en caso contrario
     */
    public boolean autenticar(String numeroCuenta, String pin)
    {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if(cuenta != null && cuenta.validarPin(pin))
        {
            this.cuentaActual= cuenta;
            return true;
        }
        return false;
    }

    /**
     * Obtiene la cuenta actualmente autenticada.
     * @return la cuenta autenticada o {null} si no hay ninguna
     */
    public Cuenta getCuentaActual()
    {
        return this.cuentaActual;
    }
    /**
     * Consulta el saldo de la cuenta actual.
     * @return saldo de la cuenta, o {0} si no hay cuenta autenticada
     */
    public double consultarSaldo()
    {
        return this.cuentaActual != null ? cuentaActual.getSaldo() : 0;
    }
    /**
     * Realiza un retiro de la cuenta actual.
     * @param cantidad monto a retirar
     * @return {true} si el retiro fue exitoso, {false} si no se pudo realizar
     */
    public boolean realizarRetiro(double cantidad)
    {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    /**
     * Realiza un depósito en la cuenta actual.
     * @param cantidad monto a depositar
     * @return {true} si el depósito fue exitoso, {false} si la cantidad es inválida o no hay cuenta autenticada
     */
    public boolean realizarDeposito(double cantidad)
    {
        if(cuentaActual != null && cantidad > 0)
        {
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }
    /**
     * Verifica si una cuenta existe en el cajero.
     * @param numeroCuenta número de cuenta a verificar
     * @return {true} si la cuenta existe, {false} en caso contrario
     */
    public boolean cuentaExistente(String numeroCuenta)
    {
        return cuentas.containsKey(numeroCuenta);
    }
    /**
     * Realiza una transferencia desde la cuenta actual hacia otra cuenta existente.
     * @param cantidad monto a transferir
     * @param numCuenta número de cuenta destino
     * @return {true} si la transferencia fue exitosa, {false} en caso contrario
     */
    public boolean transferir(double cantidad, String numCuenta)
    {
        if(cuentaExistente(numCuenta))
        {
            Cuenta cuenta = cuentas.get(numCuenta);
            cuentaActual.transferir(cantidad);
            cuenta.depositar(cantidad);
            return true;
        }
        return false;
    }
    /**
     * Cambia el NIP de la cuenta actual.
     * @param nuevo nuevo NIP a asignar
     */
    public void CambiarNIP(String nuevo)
    {
        cuentaActual.CambiarNip(nuevo);
    }
}