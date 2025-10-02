package Practica;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class VerificarEdadTest {
    @ParameterizedTest
    @ValueSource(ints = {19,20,30,23})
    public void pruebaMayorDeEdad(int edad)
    {
        assertTrue(VerificarEdad.esMayorDeEdad(edad));
    }
    /*@Test
    public void pruebaMenorDeEdad()
    {
        assertFalse(VerificarEdad.esMayorDeEdad(12));
    }
    @Test
    public void ErrorNoEsMayor()
    {
        assertTrue(VerificarEdad.esMayorDeEdad(17));
    }
     */
}