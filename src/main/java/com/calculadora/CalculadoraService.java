package com.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public double realizarOperacion(double num1, double num2, String operacion) {
        return switch (operacion.toLowerCase()) {
            case "suma" -> num1 + num2;
            case "resta" -> num1 - num2;
            case "multiplicacion" -> num1 * num2;
            case "division" -> {
                if (num2 == 0) {
                    throw new IllegalArgumentException("División por cero no permitida");
                }
                yield num1 / num2;
            }
            default -> throw new IllegalArgumentException("Operación no soportada: " + operacion);
        };
    }
}


