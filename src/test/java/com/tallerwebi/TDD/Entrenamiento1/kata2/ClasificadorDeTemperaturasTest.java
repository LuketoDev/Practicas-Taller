package com.tallerwebi.TDD.Entrenamiento1.kata2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ClasificadorDeTemperaturasTest {

    /*
Descripción:
Implementá una función/metodo `clasificarTemperatura(grados: number): string`
que clasifique una temperatura según estas reglas:
- "CONGELANTE" si es menor o igual a 0°C.
- "FRÍA" si es mayor a 0°C y hasta 15°C.
- "TEMPLADA" si está entre 16°C y 25°C inclusive.
- "CALUROSA" si está entre 26°C y 35°C inclusive.
- "PELIGROSA" si es mayor a 35°C.
Ejemplos:
- -3 → "CONGELANTE"
- 10 → "FRÍA"
- 23 → "TEMPLADA"
- 30 → "CALUROSA"
- 42 → "PELIGROSA"
 */

    private ClasificadorDeTemperaturas clasificador;

    @BeforeEach
    public void init(){ this.clasificador = new ClasificadorDeTemperaturas(); }


    @Test
    public void dadoQueExisteUnClasificadorDeTemperaturasCuandoLePidoClasificarLaTemperaturaMenos3GradosEntoncesMeDevuelveCongelante() {
        // Preparacion
        Double temperatura = -3D;

        // Ejecucion
        String clasificacion = this.clasificador.clasificar(temperatura);

        // Validacion
        assertThat(clasificacion, equalTo("CONGELANTE"));
    }

    @Test
    public void dadoQueExisteUnClasificadorDeTemperaturasCuandoLePidoClasificarLaTemperatura10GradosEntoncesMeDevuelveFria() {
        // Preparacion
        Double temperatura = 10D;

        // Ejecucion
        String clasificacion = this.clasificador.clasificar(temperatura);

        // Validacion
        assertThat(clasificacion, equalTo("FRIA"));
    }

    @Test
    public void dadoQueExisteUnClasificadorDeTemperaturasCuandoLePidoClasificarLaTemperatura23GradosEntoncesMeDevuelveTemplada() {
        // Preparacion
        Double temperatura = 23D;

        // Ejecucion
        String clasificacion = this.clasificador.clasificar(temperatura);

        // Validacion
        assertThat(clasificacion, equalTo("TEMPLADA"));
    }

    @Test
    public void dadoQueExisteUnClasificadorDeTemperaturasCuandoLePidoClasificarLaTemperatura30GradosEntoncesMeDevuelveTempladaCalurosa() {
        // Preparacion
        Double temperatura = 30D;

        // Ejecucion
        String clasificacion = this.clasificador.clasificar(temperatura);

        // Validacion
        assertThat(clasificacion, equalTo("CALUROSA"));
    }

    @Test
    public void dadoQueExisteUnClasificadorDeTemperaturasCuandoLePidoClasificarLaTemperatura42GradosEntoncesMeDevuelveTempladaPeligrosa() {
        // Preparacion
        Double temperatura = 42D;

        // Ejecucion
        String clasificacion = this.clasificador.clasificar(temperatura);

        // Validacion
        assertThat(clasificacion, equalTo("PELIGROSA"));
    }

}
