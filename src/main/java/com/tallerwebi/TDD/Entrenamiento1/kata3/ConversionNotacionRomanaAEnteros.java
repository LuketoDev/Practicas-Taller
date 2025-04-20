package com.tallerwebi.TDD.Entrenamiento1.kata3;


import com.tallerwebi.TDD.Entrenamiento1.kata3.excepciones.*;

import java.util.*;

public class ConversionNotacionRomanaAEnteros {
    public Integer romanoAEntero(String numeroRomanoAConvertir) throws NumeroRomanoInvalidoException, LimiteNumeroRomanoException, CadenaVaciaException, CadenaInvalidaException, CadenaNullException {

        if (numeroRomanoAConvertir == null) throw new CadenaNullException("El numero no puede ser nulo");

        numeroRomanoAConvertir = numeroRomanoAConvertir.toUpperCase();

        if (numeroRomanoAConvertir == null || numeroRomanoAConvertir.isEmpty()) throw new CadenaVaciaException("La cadena ingresada esta vacia");

        Boolean esAnotacionRomana = numeroRomanoAConvertir.matches("^[IVXLC]+$");

        if(!esAnotacionRomana) throw new CadenaInvalidaException("La cadena ingresada no es valida en formato Romano");

        validarCantidadDeDigitosRomanos(numeroRomanoAConvertir);

        Integer numeroEnteroFinal = convertirNumeroRomanoAEntero(numeroRomanoAConvertir);

        if (numeroEnteroFinal > 100) throw new LimiteNumeroRomanoException("El numero romano no puede ser mayor a 100");

        return numeroEnteroFinal;
    }

    private Integer convertirNumeroRomanoAEntero(String numeroRomanoAConvertir) {
        List<Integer> numerosRomanoEnFormatoEntero = new ArrayList<>();

        for (Character c : numeroRomanoAConvertir.toCharArray()) {
            Integer numeroEntero = determinarNumeroRomano(c);
            numerosRomanoEnFormatoEntero.add(numeroEntero);
        }

        Integer sumatoria = numerosRomanoEnFormatoEntero
                .stream()
                .reduce((num1, num2) ->{
                    return (num1 < num2)
                        ? num2 - num1
                        : num1 + num2;
                }).get();

        return sumatoria;
    }

    private void validarCantidadDeDigitosRomanos(String numeroRomano) throws NumeroRomanoInvalidoException {

        List<Character> caracteresValidos = Arrays.asList('I', 'V','X', 'L', 'C');

        for (Character c : caracteresValidos) {
            if (numeroRomano.contains(""+c+c+c+c))// para que funcione bien la concatenacion el "" debe ir antes de los c+c+c+c porque sino se sumara su codigo ASCII
                throw new NumeroRomanoInvalidoException("El caracter " + c + "se repite mas de 3 veces seguidas");
        }
    }

    private Integer determinarNumeroRomano(Character digitoRomano) {
        
        Integer numeroEntero = null;
        
        switch (digitoRomano){
            case 'I':
                numeroEntero = 1;
                break;
            case 'V':
                numeroEntero = 5;
                break;
            case 'X':
                numeroEntero = 10;
                break;
            case 'L':
                numeroEntero = 50;
                break;
            case 'C':
                numeroEntero = 100;
                break;
            default:
                break;
        }
        
        return numeroEntero;
    }
}
