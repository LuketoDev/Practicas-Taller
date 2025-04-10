package com.tallerwebi.TDD;

import com.tallerwebi.TDD.enums.Fortaleza;
import com.tallerwebi.TDD.excepciones.ContraseniaNullException;

/***
 * Debe validar si la fortaleza de la contraseña es DEBIL, MEDIANA o FUERTE
 * 1. Debo contruir un metodo que valide la contraseña en base a ciertas reglas.
 * ¿Cuales son las reglas?
 *
 * FUERTE: Almenos 8 caracteres, 2 de ellos que sean al menos 2 numeros, ademas se necesita almenos una letra ñ, un $ y almenos una Mayuscula
 * MEDIANA: almenos 8 caracteres que de esos al menos 4 sean numeros o sino una letra ñ o un $ en lugar de los numeros
 * DEBIL: que tenga al menos 8 caracteres
 * INVALIDO: menos de 8 caracteres
 */

public class ValidadorDeContrasenia {

    public ValidadorDeContrasenia(){}

    public Fortaleza evaluarFortaleza(String contrasenia) throws ContraseniaNullException {
        if (contrasenia == null) throw new ContraseniaNullException("Se ingreso un NULL");

        if(contrasenia.length() < 8) return Fortaleza.INVALIDO;

        int cantidadDeNumeros = 0;
        boolean contieneMayuscula = false;
        boolean contieneEnie = contrasenia.toLowerCase().contains("ñ");
        boolean contiene$ = contrasenia.contains("$");

        for(char caracter : contrasenia.toCharArray()){
            // contieneMayuscula = contieneMayuscula || Character.isUpperCase(contrasenia.charAt(i)); // otra forma
            if (!contieneMayuscula) contieneMayuscula = Character.isUpperCase(caracter);
            if(Character.isDigit(caracter)) cantidadDeNumeros++;
        }

        boolean esDebil = cantidadDeNumeros < 4 && !contieneEnie && !contiene$;
        boolean esFuerte = cantidadDeNumeros >= 2 && contieneEnie && contiene$ && contieneMayuscula;
        boolean esMediana = !esDebil && !esFuerte;

        if (esDebil) return Fortaleza.DEBIL;
        if (esMediana) return  Fortaleza.MEDIANA;

        return Fortaleza.FUERTE;
    }
}
