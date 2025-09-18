/**
 * Interfaz que define la Fábrica de Autos.
 * Obliga a implementar el método createCar para crear instancias de autos.
 */
interface CarFactory {
    Car createCar(); // Método que debe devolver un objeto que implemente la interfaz Car
}

/**
 * Interfaz que representa a un Auto.
 * Obliga a implementar el método assemble, que simula el ensamblaje del auto.
 */
interface Car {
    void assemble(); // Método para ensamblar el auto
}

/**
 * Clase que representa un auto tipo Sedán.
 * Implementa la interfaz Car.
 */
class Sedan implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling a sedan car."); // Simula el ensamblaje de un sedán
    }
}

/**
 * Clase que representa un auto tipo SUV.
 * Implementa la interfaz Car.
 */
class SUV implements Car {
    @Override
    public void assemble() {
        System.out.println("Assembling an SUV car."); // Simula el ensamblaje de un SUV
    }
}

/**
 * Fábrica concreta que crea objetos de tipo Sedan.
 * Implementa la interfaz CarFactory.
 */
class SedanFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Sedan(); // Devuelve un objeto Sedan
    }
}

/**
 * Fábrica concreta que crea objetos de tipo SUV.
 * Implementa la interfaz CarFactory.
 */
class SUVFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SUV(); // Devuelve un objeto SUV
    }
}

/**
 * Clase principal que demuestra el uso del patrón Factory Method.
 */
public class Factory_2 {
    public static void main(String[] args) {
        // Crear una fábrica de autos tipo Sedan
        CarFactory sedanFactory = new SedanFactory();
        // Usar la fábrica para crear un auto tipo Sedan
        Car sedan = sedanFactory.createCar();
        sedan.assemble(); // Ensamblar el Sedan

        // Crear una fábrica de autos tipo SUV
        CarFactory suvFactory = new SUVFactory();
        // Usar la fábrica para crear un auto tipo SUV
        Car suv = suvFactory.createCar();
        suv.assemble(); // Ensamblar el SUV
    }
}
