public class Cliente
{
    public static void main(String[] args)
    {
        VehiculoFactory factory = new VehiculoFactory();
        Vehiculo coche = factory.crearVehiculo("COCHE");
        coche.conducir();
        Vehiculo moto = factory.crearVehiculo("MOTO");
        moto.conducir();
        Vehiculo camion = factory.crearVehiculo("CAMION");
        camion.conducir();
    }
}
