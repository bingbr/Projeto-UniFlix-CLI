package edu.uni.uniflix;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Validar {
    public static boolean posicao(int posicao, int tamanho) throws Exception {
        if (posicao <= tamanho && posicao > 0) 
            return true;
        else 
            throw new IllegalArgumentException();
    }

    public static boolean numero(String numero) throws Exception {
        if (!numero.isEmpty() && numero.matches("^\\d+$"))
            return true;
        else
            throw new NumberFormatException();
    }

    public static String toTitleCase(String texto) {
        return Arrays.stream(texto.split("\\s+"))
                .map(letra -> Character.toTitleCase(letra.charAt(0)) + letra.substring(1))
                .collect(Collectors.joining(" "));
    }
}
