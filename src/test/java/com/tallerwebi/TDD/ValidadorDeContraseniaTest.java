package com.tallerwebi.TDD;

import com.tallerwebi.TDD.enums.Fortaleza;
import com.tallerwebi.TDD.excepciones.ContraseniaNullException;
import org.hamcrest.core.IsEqual;
import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.tallerwebi.TDD.ValidadorDeContrasenia;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidadorDeContraseniaTest {

    private ValidadorDeContrasenia validador;

    @BeforeEach
    public void init(){
        validador = new ValidadorDeContrasenia();
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnCaracterEntoncesValidaContraseniaInvalida() throws ContraseniaNullException {
        // Preparacion (hecha en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("a");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.INVALIDO));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringVacioEntoncesLaContraseniaEsInvalida() throws ContraseniaNullException {
        // Preparacion (hecha en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.INVALIDO));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnNullEntoncesObtengoUnContraseniaNullException(){
        // Preparacion (hecha en el init)

        // Ejecucion y validacion (formato de validacion de excepciones junit5)
        assertThrows(ContraseniaNullException.class, () -> this.validador.evaluarFortaleza(null));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringDe8CaracteresEntoncesValidaContraseniaDebil() throws ContraseniaNullException {
        // Preparacion (hecha en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("damian12");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.DEBIL));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringCon8CaracteresY4DeEllosSonNumerosEntoncesValidaContraseniaMediana() throws ContraseniaNullException {
        // Preparacion (hecha en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("dami33n12");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.MEDIANA));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringCon8CaracteresYUnoDeEllosEsUnaÑEntoncesValidaContraseniaMediana() throws ContraseniaNullException {

        // Preparacion (hecho en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("damiannñ");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.MEDIANA));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringCon8CaracteresYUnoDeEllosEsUn$EntoncesValidaContraseniaMediana() throws ContraseniaNullException {

        // Preparacion (hecho en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("damiann$");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.MEDIANA));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringCon8CaracteresYSonTodasÑMayusculasEntoncesValidaContraseniaMediana() throws ContraseniaNullException {

        // Preparacion (hecho en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("ÑÑÑÑÑÑÑÑ");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.MEDIANA));
    }

    @Test
    public void dadoQueExisteUnValidadorCuandoLePasoComoContraseniaUnStringCon8CaracteresQueTieneUn$UnaÑY2YUnaMayusculaEntoncesValidaContraseniaFuerte() throws ContraseniaNullException {

        // Preparacion (hecho en el init)

        // Ejecucion
        Fortaleza fortaleza = this.validador.evaluarFortaleza("Dami$Ñ12");

        // Validacion
        assertThat(fortaleza, is(Fortaleza.FUERTE));
    }
}