class Configuracion
{
    private static Configuracion instancia;
    private String baseDatosUrl;
    private String usuario;
    private String password;
    private Configuracion()
    {
        this.baseDatosUrl = "jdbc:mysql://localhost:3306/mi_base";
        this.usuario = "admin";
        this.password = "12345";
    }
    public static Configuracion getInstancia()
    {
        if(instancia == null)
        {
            instancia = new Configuracion();
        }
        return instancia;
    }
    public String getBaseDatosUrl()
    {
        return baseDatosUrl;
    }
    public void setBaseDatosUrl(String baseDatosUrl)
    {
        this.baseDatosUrl = baseDatosUrl;
    }
    public String getUsuario()
    {
        return usuario;
    }
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    public void mostrarConfiguracion()
    {
        System.out.println("Base de datos URL: " + baseDatosUrl);
        System.out.println("Usuario: " + usuario);
        System.out.println("Password: " + password);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        Configuracion config1 = Configuracion.getInstancia();
        config1.mostrarConfiguracion();
        Configuracion config2 = Configuracion.getInstancia();
        config2.setBaseDatosUrl("jdbc:mysql//localhost:3306/nueva_base");
        config2.setUsuario("root");
        config2.setPassword("nueva_clave");
        System.out.println("\ndespues de modificar:");
        config1.mostrarConfiguracion();
        System.out.println("\n¿config1 y config2 son el mismo objeto? " + (config1 == config2));
    }
}
