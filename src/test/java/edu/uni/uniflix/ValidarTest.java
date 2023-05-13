package edu.uni.uniflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Validar")
public class ValidarTest {
    @DisplayName("Posição Válida")
    @Test
    void deveValidarPosicao() throws Exception {
        int tamanho = 5;
        Assertions.assertTrue(Validar.posicao(3, tamanho));
    }

    @DisplayName("Posição Inválida")
    @Test
    void deveInvalidarPosicao() throws Exception {
        int tamanho = 3;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validar.posicao(6, tamanho));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validar.posicao(0, tamanho));
    }

    @DisplayName("Numero Válido")
    @Test
    void deveValidarNumero() throws Exception {
        String valido = "5";
        Assertions.assertTrue(Validar.numero(valido));
    }

    @DisplayName("Numero Inválido")
    @Test
    void deveInvalidarNumero() throws Exception {
        String invalido = "d";
        Assertions.assertThrows(NumberFormatException.class, () -> Validar.numero(invalido));
        Assertions.assertThrows(NumberFormatException.class, () -> Validar.numero(""));
    }

    @DisplayName("TitleCase")
    @Test
    void deveValidarConversaoTitleCaseCorretamente() {
        String input = "linus tech tips";
        String esperado = "Linus Tech Tips";
        Assertions.assertEquals(esperado, Validar.toTitleCase(input));
        Assertions.assertNotEquals(input, Validar.toTitleCase(input));
    }
}