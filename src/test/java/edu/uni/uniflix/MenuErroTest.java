package edu.uni.uniflix;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.uni.uniflix.menu.Erro;

@DisplayName("Erro")
public class MenuErroTest {
    @DisplayName("IOException ou NumberFormatException")
    @Test
    void deveRetornarIOException() {
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setErr(new PrintStream(resultado));

        Erro.mensagem(new IOException());
        String esperado = "ERRO = Você digitou um valor inválido!\n";
        Assertions.assertEquals(esperado, resultado.toString());

        resultado.reset();
        Erro.mensagem(new NumberFormatException());
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("InputMismatchException")
    @Test
    void deveRetornarInputMismatch() {
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setErr(new PrintStream(resultado));

        Erro.mensagem(new InputMismatchException("CPF"));
        String esperado = "ERRO = CPF inválido(a).\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("NoSuchElementException")
    @Test
    void deveRetornarNoSuchElementException() {
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setErr(new PrintStream(resultado));

        Erro.mensagem(new NoSuchElementException());
        String esperado = "ERRO = Elemento inexistente!\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("IllegalArgumentException")
    @Test
    void deveRetornarIllegalArgumentException() {
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setErr(new PrintStream(resultado));

        resultado.reset();
        Erro.mensagem(new IllegalArgumentException());
        String esperado = "ERRO = A posição inserida é inválida!\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("NullPointerException")
    @Test
    void deveRetornarNullPointerException() {
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setErr(new PrintStream(resultado));

        Erro.mensagem(new NullPointerException("editar"));
        String esperado = "ERRO = Impossível editar item em uma lista vazia!\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Genérico")
    @Test
    void deveRetornarErroGenerico() {
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setErr(new PrintStream(resultado));

        Erro.mensagem(new Exception());
        String esperado = "ERRO = Ops, ocorreu um erro!\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }
}
