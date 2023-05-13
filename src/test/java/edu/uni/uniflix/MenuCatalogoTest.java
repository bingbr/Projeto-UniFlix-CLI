package edu.uni.uniflix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.uni.uniflix.menu.Catalogo;
import edu.uni.uniflix.menu.Filme;
import edu.uni.uniflix.menu.Serie;

@DisplayName("Catalogo")
public class MenuCatalogoTest {
    @DisplayName("Adiciona item corretamente")
    @Test 
    public void deveAdicionarItem() throws Exception {
        Catalogo catalogo = new Catalogo();

        String input = "1\nfilme\nteste\n1999\nação\n9.99\n59.99\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        catalogo.adicionar(new Scanner(in));

        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        catalogo.exibir();

        String esperado = "\n----- LISTA DE FILME(S) OU SÉRIE(S) -----\nFILME -> Título: Teste, Ano: 1999, Gênero: Ação, Avaliação: 9.99, USD $59.99\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Edita item corretamente")
    @Test 
    public void deveEditarItem() throws Exception {
        Catalogo catalogo = new Catalogo();

        String input = "1\nfilme\nteste\n1999\nação\n9.99\n59.99\n";
        ByteArrayInputStream add = new ByteArrayInputStream(input.getBytes());
        catalogo.adicionar(new Scanner(add));

        String novoInput = "1\nfilme\nteste\n2023\nAventura\n9.99\n59.99\n";
        ByteArrayInputStream edit = new ByteArrayInputStream(novoInput.getBytes());
        catalogo.editar(new Scanner(edit));
        
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        catalogo.exibir();

        String esperado = "\n----- LISTA DE FILME(S) OU SÉRIE(S) -----\nFILME -> Título: Teste, Ano: 2023, Gênero: Aventura, Avaliação: 9.99, USD $59.99\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Remove item corretamente")
    @Test 
    public void deveRemoverItem() throws Exception {
        Catalogo catalogo = new Catalogo();

        String input = "1\nfilme\nteste\n1999\nação\n9.99\n59.99\n";
        ByteArrayInputStream add = new ByteArrayInputStream(input.getBytes());
        catalogo.adicionar(new Scanner(add));

        String novoInput = "1\n";
        ByteArrayInputStream rem = new ByteArrayInputStream(novoInput.getBytes());
        catalogo.remover(new Scanner(rem));

        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        catalogo.exibir();

        String esperado = "\n----- LISTA DE FILME(S) OU SÉRIE(S) -----\n      A lista está vazia.\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Exibe filmes corretamente")
    @Test 
    public void deveExibirFilmes() throws Exception {
        Catalogo catalogo = new Catalogo();
        Filme filme = new Filme(catalogo);
        

        String input = "1\nfilme\nteste\n1999\nação\n9.99\n59.99\n";
        ByteArrayInputStream add = new ByteArrayInputStream(input.getBytes());
        catalogo.adicionar(new Scanner(add));

        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        filme.exibir();

        String esperado = "\n----- LISTA DE FILME(S) -----\nFILME -> Título: Teste, Ano: 1999, Gênero: Ação, Avaliação: 9.99, USD $59.99\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Exibe series corretamente")
    @Test 
    public void deveExibirSeries() throws Exception {
        Catalogo catalogo = new Catalogo();
        Serie serie = new Serie(catalogo);
        

        String input = "1\nsérie\ntest\n1999\nação\n9.99\n59.99\n";
        ByteArrayInputStream add = new ByteArrayInputStream(input.getBytes());
        catalogo.adicionar(new Scanner(add));

        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        serie.exibir();

        String esperado = "\n----- LISTA DE SÉRIE(S) -----\nSERIE -> Título: Test, Ano: 1999, Gênero: Ação, Avaliação: 9.99, USD $59.99\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }
}
