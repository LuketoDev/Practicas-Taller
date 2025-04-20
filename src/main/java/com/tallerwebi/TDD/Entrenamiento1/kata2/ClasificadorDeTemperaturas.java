package com.tallerwebi.TDD.Entrenamiento1.kata2;

public class ClasificadorDeTemperaturas {

    public String clasificar(Double temperatura) {

        if (temperatura <= 0) return "CONGELANTE";
        if (temperatura <= 15) return "FRIA";
        if (temperatura <= 25) return "TEMPLADA";
        if (temperatura <= 35) return "CALUROSA";
        return "PELIGROSA";
    }
}
