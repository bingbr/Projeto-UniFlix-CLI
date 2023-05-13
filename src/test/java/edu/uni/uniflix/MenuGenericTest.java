package edu.uni.uniflix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.uni.uniflix.iterator.*;
import edu.uni.uniflix.menu.Generic;

@DisplayName("Generic")
public class MenuGenericTest {
    @DisplayName("Mensagem válida")
    @Test
    void deveRetornarMensagemCorreta() throws Exception {
        String input = "teste\n";
        Scanner leia = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Function<String, String> argumento = String::toUpperCase;
        Assertions.assertEquals("TESTE", Generic.mensagem("Insira um texto: ", leia, "String", argumento));
    }

    @DisplayName("Mensagem vazia")
    @Test
    void deveRetornarErroQuandoInputEhVazio() {
        String input = "\n";
        Scanner leia = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Function<String, String> argumento = s -> s.toUpperCase();
        Assertions.assertThrows(InputMismatchException.class, () -> Generic.mensagem("Insira um texto: ", leia, "String", argumento));
    }

    @DisplayName("Mensagem inválida")
    @Test
    void deveRetornarErroQuandoInputForInvalido() {
        String input = "não é um número\n";
        Scanner leia = new Scanner(new ByteArrayInputStream(input.getBytes()));
        Function<String, Integer> argumento = Integer::parseInt;
        Assertions.assertThrows(NumberFormatException.class, () -> Generic.mensagem("Insira um número: ", leia, "Integer", argumento));
    }

    @DisplayName("Listar conteúdo")
    @Test
    void deveRetornarListaComElementos() {
        ByteArrayOutputStream conteudoSaida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(conteudoSaida));

        AcervoCollection lista = new AcervoCollectionImpl();
        lista.adicionar(new Acervo(AcervoTipoEnum.TODOS, "Teste", 1999, "Ação", 9.99, 59.99));
        Generic.exibir("TESTE", lista.vazio(), lista, AcervoTipoEnum.TODOS);

        String conteudoEsperado = "\n----- LISTA DE TESTE(S) -----\nTODOS -> Título: Teste, Ano: 1999, Gênero: Ação, Avaliação: 9.99, USD $59.99\n";
        Assertions.assertEquals(conteudoEsperado, conteudoSaida.toString());
    }

    @DisplayName("Lista vazia")
    @Test
    void deveRetornarListaVazia() {
        ByteArrayOutputStream conteudoSaida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(conteudoSaida));

        AcervoCollection lista = new AcervoCollectionImpl();
        Generic.exibir("TESTE", lista.vazio(), lista, AcervoTipoEnum.TODOS);

        String conteudoEsperado = "\n----- LISTA DE TESTE(S) -----\n      A lista está vazia.\n";
        Assertions.assertEquals(conteudoEsperado, conteudoSaida.toString());
    }
}

