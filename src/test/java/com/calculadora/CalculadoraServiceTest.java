package com.calculadora.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {

    private CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {

        calculadoraService = new CalculadoraService();
    }

    @Test
    void testSuma() {
        // Prueba que 5 + 3 sea igual a 8
        double resultado = calculadoraService.realizarOperacion(5, 3, "suma");
        assertEquals(8, resultado);
    }

    @Test
    void testResta() {

        double resultado = calculadoraService.realizarOperacion(10, 4, "resta");
        assertEquals(6, resultado);
    }
    
    @Test
    void testMultiplicacion() {

        double resultado = calculadoraService.realizarOperacion(7, 2, "multiplicacion");
        assertEquals(14, resultado);
    }

    @Test
    void testDivision() {

        double resultado = calculadoraService.realizarOperacion(10, 2, "division");
        assertEquals(5, resultado);
    }

    @Test
    void testDivisionPorCero() {
        // Prueba que la división por cero lance la excepción correcta
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.realizarOperacion(10, 0, "division");
        });

        // Opcional: Verifica que el mensaje de error sea el esperado
        String expectedMessage = "División por cero no permitida";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

