package com.tallerwebi.TDD.Entrenamiento1.kata3;

import com.tallerwebi.TDD.Entrenamiento1.kata3.excepciones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversionNotacionRomanaAEnterosTest {

/*
 Kata 3: Conversor de Notación Romana a Enteros
 Descripción:
    Implementá una función/metodo `romanoAEntero(romano: string): number`
    que convierta números romanos válidos entre I y C (1 a 100) a su valor numérico entero.
 Reglas básicas:
 - Soportar los símbolos: I, V, X, L, C.
 - Solo deben manejarse valores hasta 100 (C).
 - Validar que el string sea una combinación romana válida (si no lo es, lanzar un error).

 Ejemplos:
 - "I" → 1
 - "IV" → 4
 - "XIII" → 13
 - "XL" → 40
 - "XCIX" → 99
 - "C" → 100
 - "IIII" → Error
 - "CI" → Error
 */

    private ConversionNotacionRomanaAEnteros conversor;

    @BeforeEach
    public void init() { this.conversor = new ConversionNotacionRomanaAEnteros(); }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeIEntoncesObtengo1 () throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {
        // Preparacion

        String numeroRomanoAConvertir = "I";

        // Ejecucion

        Integer numeroEnteroConvertido = this.conversor.romanoAEntero(numeroRomanoAConvertir);

        // Validacion

        assertThat(numeroEnteroConvertido, equalTo(1));

    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeIVEntoncesObtengo4 () throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {
        // Preparacion

        String numeroRomanoAConvertir = "IV";

        // Ejecucion

        Integer numeroEnteroConvertido = conversor.romanoAEntero(numeroRomanoAConvertir);

        // Validacion

        assertThat(numeroEnteroConvertido, equalTo(4));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeXIIIEntoncesObtengo13 () throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {
        // Preparacion

        String numeroRomanoAConvertir = "XIII";

        // Ejecucion

        Integer numeroEnteroConvertido = conversor.romanoAEntero(numeroRomanoAConvertir);

        // Validacion

        assertThat(numeroEnteroConvertido, equalTo(13));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeXLEntoncesObtengo40 () throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {
        // Preparacion

        String numeroRomanoAConvertir = "XL";

        // Ejecucion

        Integer numeroEnteroConvertido = conversor.romanoAEntero(numeroRomanoAConvertir);

        // Validacion

        assertThat(numeroEnteroConvertido, equalTo(40));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeXICXEntoncesObtengo99 () throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {
        // Preparacion

        String numeroRomanoAConvertir = "XICX";

        // Ejecucion

        Integer numeroEnteroConvertido = conversor.romanoAEntero(numeroRomanoAConvertir);

        // Validacion

        assertThat(numeroEnteroConvertido, equalTo(99));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeCEntoncesObtengo100 () throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {
        // Preparacion

        String numeroRomanoAConvertir = "C";

        // Ejecucion

        Integer numeroEnteroConvertido = conversor.romanoAEntero(numeroRomanoAConvertir);

        // Validacion

        assertThat(numeroEnteroConvertido, equalTo(100));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeIIIIEntoncesObtengoNumeroRomanoInvalidoException() {
        // Preparacion

        String numeroRomanoAConvertir = "IIII";

        // Ejecucion y validacion

        assertThrows(NumeroRomanoInvalidoException.class, () -> this.conversor.romanoAEntero(numeroRomanoAConvertir));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeCIEntoncesObtengoLimiteNumeroRomanoException() {
        // Preparacion

        String numeroRomanoAConvertir = "CI";

        // Ejecucion y validacion

        assertThrows(LimiteNumeroRomanoException.class, () -> this.conversor.romanoAEntero(numeroRomanoAConvertir));
    }

    // test echos por mi:

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeUnaCadenaVaciaEntoncesObtengoCadenaVaciaException() {
        // Preparacion

        String numeroRomanoAConvertir = "";

        // Ejecucion y validacion

        assertThrows(CadenaVaciaException.class, () -> this.conversor.romanoAEntero(numeroRomanoAConvertir));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeASDCVEntoncesObtengoCadenaInvalidaException() {
        // Preparacion

        String numeroRomanoAConvertir = "ASDCV";

        // Ejecucion y validacion

        assertThrows(CadenaInvalidaException.class, () -> this.conversor.romanoAEntero(numeroRomanoAConvertir));
    }

    @Test
    public void dadoQueExisteUnConversorDeNotacionRomanaAEnterosCuandoLePidoHacerLaConversionDeNullEntoncesObtengoCadenaNullException() {
        // Preparacion

        String numeroRomanoAConvertir = null;

        // Ejecucion y validacion

        assertThrows(CadenaNullException.class, () -> this.conversor.romanoAEntero(numeroRomanoAConvertir));
    }

}
