package com.calculadora.controller;

import com.calculadora.model.OperacionRequest;
import com.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier frontend
public class CalculadoraController {

    @Autowired
    private CalculadoraService calculadoraService;

    @GetMapping("/")
    public String home() {
        return " Calculadora API funcionando correctamente!";
    }


    @PostMapping("/operar")
    public ResponseEntity<?> operar(@RequestBody OperacionRequest request) {
        try {
            double resultado = calculadoraService.realizarOperacion(
                request.getNum1(),
                request.getNum2(),
                request.getOperacion()
            );
            return ResponseEntity.ok(new ResultadoResponse(resultado));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ErrorResponse(e.getMessage()));
        }
    }

    // Clases auxiliares para respuesta estructurada
    public static class ResultadoResponse {
        private double resultado;

        public ResultadoResponse(double resultado) {
            this.resultado = resultado;
        }

        public double getResultado() { return resultado; }
        public void setResultado(double resultado) { this.resultado = resultado; }
    }

    public static class ErrorResponse {
        private String error;

        public ErrorResponse(String error) {
            this.error = error;
        }

        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
    }
}


