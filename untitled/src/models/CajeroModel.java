package models;
import java.util.HashMap;
import java.util.Map;
public class CajeroModel
{
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;
    public CajeroModel()
    {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }
    private void inicializarCuentas()
    {
        cuentas.put("12345", new Cuenta("12345", "1111",5000,"Pedro Perez Pereira"));
        cuentas.put("67890", new Cuenta("67890", "1234",3500,"Pobre Pintor Portugues"));
        cuentas.put("09876", new Cuenta("09876", "5678",7350,"Pinta Preciosos Paisajes"));
    }
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
    public Cuenta getCuentaActual()
    {
        return this.cuentaActual;
    }
    public double consultarSaldo()
    {
        return this.cuentaActual != null ? cuentaActual.getSaldo():0;
    }
    public boolean realizarRetiro(double cantidad)
    {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }
    public boolean realizarDeposito(double cantidad)
    {
        if(cuentaActual != null && cantidad > 0)
        {
            cuentaActual.depositar(cantidad);
            return true;
        }
        return false;
    }
    public boolean cuentaExistente(String numeroCuenta)
    {
        return cuentas.containsKey(numeroCuenta);
    }
    public void transferir(double cantidad, String numCuenta)
    {
        if(cuentaExistente(numCuenta))
        {
            Cuenta cuenta = cuentas.get(numCuenta);
            cuentaActual.transferir(cantidad);
            cuenta.depositar(cantidad);
        }
    }
    public void CambiarNIP(String Nuevo)
    {
        cuentaActual.CambiarNip(Nuevo);
    }
    //Tarea: Definir el metodo para transferir COMPLETO
}