package edu.uni.uniflix;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import edu.uni.uniflix.menu.Usuario;

@DisplayName("Usuario")
public class MenuUsuarioTest {
    @DisplayName("Adiciona corretamente")
    @Test 
    public void deveAdicionarUsuario() throws Exception {
        Usuario user = new Usuario();

        String input = "1\n123\nteste\ntest@localhost\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        user.adicionar(new Scanner(in));
    
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        user.exibir();

        String esperado = "\n----- LISTA DE USUÁRIO(S) -----\nNome: Teste, CPF: 123, E-mail: test@localhost\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Edita corretamente")
    @Test 
    public void deveEditarUsuario() throws Exception {
        Usuario user = new Usuario();

        String input = "1\n123\nteste\ntest@localhost\n";
        ByteArrayInputStream add = new ByteArrayInputStream(input.getBytes());
        user.adicionar(new Scanner(add));

        String novoInput = "1\n321\ntest\ntest@localhost\n";
        ByteArrayInputStream edit = new ByteArrayInputStream(novoInput.getBytes());
        user.editar(new Scanner(edit));
        
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        user.exibir();

        String esperado = "\n----- LISTA DE USUÁRIO(S) -----\nNome: Test, CPF: 321, E-mail: test@localhost\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }

    @DisplayName("Remove corretamente")
    @Test 
    public void deveRemoverUsuario() throws Exception {
        Usuario user = new Usuario();

        String input = "1\n123\nteste\ntest@localhost\n";
        ByteArrayInputStream add = new ByteArrayInputStream(input.getBytes());
        user.adicionar(new Scanner(add));

        String novoInput = "1\n";
        ByteArrayInputStream rem = new ByteArrayInputStream(novoInput.getBytes());
        user.remover(new Scanner(rem));
        
        ByteArrayOutputStream resultado = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultado));
        user.exibir();

        String esperado = "\n----- LISTA DE USUÁRIO(S) -----\n      A lista está vazia.\n";
        Assertions.assertEquals(esperado, resultado.toString());
    }
}
