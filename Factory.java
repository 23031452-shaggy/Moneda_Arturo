/**
 * Interfaz que define el comportamiento común de todos los vehículos.
 * Obliga a implementar los métodos acelerar, frenar y mostrarInfo.
 */
interface Vehiculo {
    void acelerar();     // Método para simular la aceleración del vehículo
    void frenar();       // Método para simular el frenado del vehículo
    void mostrarInfo();  // Método para mostrar la información detallada del vehículo
}

/**
 * Clase que representa un coche.
 * Implementa la interfaz Vehiculo.
 */
class Coche implements Vehiculo {
    private String marca;   // Marca del coche (ejemplo: Toyota, Honda)
    private String modelo;  // Modelo del coche (ejemplo: Corolla, Civic)

    // Constructor para inicializar el coche con marca y modelo
    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public void acelerar() {
        System.out.println("El coche " + marca + " " + modelo + " está acelerando por la carretera");
    }

    @Override
    public void frenar() {
        System.out.println("El coche está frenando con frenos de disco");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("🚗 Coche: " + marca + " " + modelo + " - 4 ruedas, motor a gasolina");
    }
}

/**
 * Clase que representa una motocicleta.
 * Implementa la interfaz Vehiculo.
 */
class Motocicleta implements Vehiculo {
    private String marca;     // Marca de la motocicleta (ejemplo: Yamaha, Kawasaki)
    private int cilindrada;   // Cilindrada en cc (ejemplo: 250, 600)

    // Constructor para inicializar la motocicleta con marca y cilindrada
    public Motocicleta(String marca, int cilindrada) {
        this.marca = marca;
        this.cilindrada = cilindrada;
    }

    @Override
    public void acelerar() {
        System.out.println("La motocicleta " + marca + " está acelerando con " + cilindrada + "cc");
    }

    @Override
    public void frenar() {
        System.out.println("La motocicleta está frenando con precaución");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("🏍️ Motocicleta: " + marca + " " + cilindrada + "cc - 2 ruedas, ágil y rápida");
    }
}

/**
 * Clase que representa un camión.
 * Implementa la interfaz Vehiculo.
 */
class Camion implements Vehiculo {
    private String marca;           // Marca del camión (ejemplo: Volvo, Mercedes)
    private double capacidadCarga;  // Capacidad de carga en toneladas

    // Constructor para inicializar el camión con marca y capacidad de carga
    public Camion(String marca, double capacidadCarga) {
        this.marca = marca;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public void acelerar() {
        System.out.println("El camión " + marca + " está acelerando lentamente con " + capacidadCarga + " toneladas");
    }

    @Override
    public void frenar() {
        System.out.println("El camión está frenando con sistema de frenos neumático");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("🚛 Camión: " + marca + " - Capacidad: " + capacidadCarga + " toneladas");
    }
}

/**
 * Enumeración que lista los tipos de vehículos soportados por la fábrica.
 */
enum TipoVehiculo {
    COCHE, MOTOCICLETA, CAMION
}

/**
 * Clase que implementa el patrón Factory.
 * Se encarga de centralizar la creación de objetos de tipo Vehiculo.
 */
class VehiculoFactory {

    /**
     * Método que crea un vehículo según el tipo indicado.
     * Los parámetros se pasan como strings y se convierten según el vehículo.
     *
     * @param tipo Tipo de vehículo (COCHE, MOTOCICLETA, CAMION)
     * @param parametros Datos adicionales como marca, modelo, cilindrada o capacidad de carga
     * @return Objeto de tipo Vehiculo
     */
    public static Vehiculo crearVehiculo(TipoVehiculo tipo, String... parametros) {
        switch (tipo) {
            case COCHE:
                if (parametros.length >= 2) {
                    return new Coche(parametros[0], parametros[1]);
                } else {
                    return new Coche("Toyota", "Corolla");  // Valores por defecto
                }

            case MOTOCICLETA:
                if (parametros.length >= 2) {
                    try {
                        int cilindrada = Integer.parseInt(parametros[1]);
                        return new Motocicleta(parametros[0], cilindrada);
                    } catch (NumberFormatException e) {
                        return new Motocicleta(parametros[0], 250); // Valor por defecto
                    }
                } else {
                    return new Motocicleta("Yamaha", 250);
                }

            case CAMION:
                if (parametros.length >= 2) {
                    try {
                        double capacidad = Double.parseDouble(parametros[1]);
                        return new Camion(parametros[0], capacidad);
                    } catch (NumberFormatException e) {
                        return new Camion(parametros[0], 10.0); // Valor por defecto
                    }
                } else {
                    return new Camion("Volvo", 15.0);
                }

            default:
                throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        }
    }

    /**
     * Método auxiliar para crear un vehículo con valores por defecto.
     */
    public static Vehiculo crearVehiculoPorDefecto(TipoVehiculo tipo) {
        return crearVehiculo(tipo);
    }
}

/**
 * Clase que demuestra el uso del patrón Factory.
 */
class FactoryPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN FACTORY ===\n");

        // Creación de vehículos con parámetros personalizados
        Vehiculo coche1 = VehiculoFactory.crearVehiculo(TipoVehiculo.COCHE, "Honda", "Civic");
        Vehiculo moto1 = VehiculoFactory.crearVehiculo(TipoVehiculo.MOTOCICLETA, "Kawasaki", "600");
        Vehiculo camion1 = VehiculoFactory.crearVehiculo(TipoVehiculo.CAMION, "Mercedes", "12.5");

        // Creación de vehículos con valores por defecto
        Vehiculo coche2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.COCHE);
        Vehiculo moto2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.MOTOCICLETA);

        // Guardar todos los vehículos en un arreglo
        Vehiculo[] vehiculos = {coche1, moto1, camion1, coche2, moto2};

        // Mostrar información de cada vehículo
        System.out.println("1. INFORMACIÓN DE VEHÍCULOS:");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInfo();
        }

        // Probar aceleración
        System.out.println("\n2. ACELERANDO TODOS LOS VEHÍCULOS:");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.acelerar();
        }

        // Probar frenado
        System.out.println("\n3. FRENANDO TODOS LOS VEHÍCULOS:");
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.frenar();
        }

        // Creación dinámica basada en entrada de strings
        System.out.println("\n4. CREACIÓN DINÁMICA BASADA EN INPUT:");
        String[] tiposInput = {"COCHE", "MOTOCICLETA", "CAMION"};
        for (String tipoStr : tiposInput) {
            try {
                TipoVehiculo tipo = TipoVehiculo.valueOf(tipoStr);
                Vehiculo vehiculo = VehiculoFactory.crearVehiculoPorDefecto(tipo);
                System.out.print("Creado dinámicamente: ");
                vehiculo.mostrarInfo();
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de vehículo no válido: " + tipoStr);
            }
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}

/**
 * Clase que representa una bicicleta.
 * También implementa la interfaz Vehiculo, pero no está integrada en la fábrica.
 */
class Bicicleta implements Vehiculo {
    private String tipo;           // Tipo de bicicleta (ejemplo: montaña, ruta)
    private int numVelocidades;    // Número de velocidades

    public Bicicleta(String tipo, int numVelocidades) {
        this.tipo = tipo;
        this.numVelocidades = numVelocidades;
    }

    @Override
    public void acelerar() {
        System.out.println("La bicicleta " + tipo + " está siendo pedaleada");
    }

    @Override
    public void frenar() {
        System.out.println("La bicicleta está frenando con frenos de mano");
    }

    @Override
    public void mostrarInfo() {
        System.out.println("🚲 Bicicleta: " + tipo + " - " + numVelocidades + " velocidades, ecológica");
    }
}
