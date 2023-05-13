package edu.uni.uniflix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.uni.uniflix.menu.Moeda;

@DisplayName("Preco")
public class MenuMoedaTest {
    @DisplayName("Converte corretamente")
    @Test
    public void deveRetornarPrecoConvertido() throws Exception {
        Moeda dolar = new Moeda();

        String input = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        dolar.valor(new Scanner(in));

        String esperado = "\nDigite o preço em dólar do item: O preço em real é de R$ 4.94\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }
}
