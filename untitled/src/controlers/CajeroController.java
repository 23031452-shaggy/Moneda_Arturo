package controlers;

import models.CajeroModel;
import views.CajeroView;
/**
 * Controlador principal del sistema de cajero automático.
 */
public class CajeroController
{
    /** Modelo del cajero que gestiona las cuentas y operaciones. */
    private CajeroModel model;
    /** Vista del cajero que interactúa con el usuario. */
    private CajeroView view;
    /** Bandera que indica si el sistema del cajero está activo. */
    private boolean sistemaActivo;
    /**
     * Crea un nuevo controlador para el cajero automático.
     * @param model modelo que gestiona la lógica de negocio del cajero
     * @param view vista que maneja la interacción con el usuario
     */
    public CajeroController(CajeroModel model, CajeroView view)
    {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }
    /**
     * Inicia el sistema del cajero, mostrando la pantalla de bienvenida
     * y gestionando el ciclo de autenticación y ejecución de operaciones.
     */
    public void iniciarSistema()
    {
        view.mostrarBienvenida();
        while (sistemaActivo)
        {
            if(autenticarUsuario())
            {
                ejecutarMenuPrincipal();
            }
            else
            {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero");
    }
    /**
     * Solicita al usuario sus credenciales y valida la autenticación.
     *
     * @return {true} si las credenciales son válidas, {false} en caso contrario
     */
    private boolean autenticarUsuario()
    {
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }
    /**
     * Ejecuta el menú principal de opciones disponibles para el usuario autenticado.
     */
    private void ejecutarMenuPrincipal()
    {
        boolean sessionActiva = true;
        while (sessionActiva)
        {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();
            switch (opcion)
            {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    this.realizarRetiro();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 5:
                    cambiarNIP();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    break;
            }
        }
    }
    /**
     * Consulta y muestra el saldo de la cuenta actual.
     */
    public void consultarSaldo()
    {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }
    /**
     * Solicita y procesa un retiro de la cuenta actual.
     */
    public void realizarRetiro()
    {
        double cantidad = view.solicitarCantidad("Retirar ");
        if(cantidad <= 0)
        {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if(model.realizarRetiro(cantidad))
        {
            view.mostrarMensaje("Retiro exitoso de " + cantidad);
        }
        else
        {
            view.mostrarMensaje("Fondos insuficientes");
        }
    }
    /**
     * Solicita y procesa un depósito en la cuenta actual.
     */
    public void realizarDeposito()
    {
        double cantidad = view.solicitarCantidad("Deposito ");
        if(cantidad <= 0)
        {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if(model.realizarDeposito(cantidad))
        {
            view.mostrarMensaje("Deposito exitoso por la cantidad de " + cantidad);
        }
        else
        {
            view.mostrarMensaje("Error en el proceso de deposito");
        }
    }
    /**
     * Solicita y procesa una transferencia hacia otra cuenta.
     */
    public void realizarTransferencia()
    {
        double cantidad = view.solicitarCantidad("Transferir ");
        String numeroCuenta = view.solicitarNumeroCuenta();
        if(cantidad <= 0)
        {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if(model.transferir(cantidad, numeroCuenta))
        {
            view.mostrarMensaje("transferencia realizada con exito ");
        }
        else
        {
            view.mostrarMensaje("Error en el proceso de transferencia");
        }
    }
    /**
     * Cierra la sesión y finaliza la aplicación.
     */
    public void salir()
    {
        view.salir();
    }
    /**
     * Solicita un nuevo NIP al usuario y lo actualiza en la cuenta actual.
     */
    public void cambiarNIP()
    {
        model.CambiarNIP(view.solicitarPin());
    }
}