package edu.uni.uniflix.menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

import edu.uni.uniflix.iterator.*;

public class Generic {
    public static <T> T mensagem(String texto, Scanner ler, String nome, Function<String, T> argumento) throws Exception {
        while (true) {
            System.out.print(texto);
            String dado = ler.nextLine();
            if (!dado.isEmpty())
                return argumento.apply(dado);
            else
                throw new InputMismatchException(nome);
        }
    }
    
    public static void exibir(String nome, boolean vazio, AcervoCollection acervo, AcervoTipoEnum tipo) {
        System.out.println("\n----- LISTA DE " + nome + "(S) -----");
        AcervoIterator conteudo = acervo.iterator(tipo);
        if (!vazio)
            while (conteudo.hasNext())
                System.out.println(conteudo.next().toString());
        else
            System.out.println("      A lista está vazia.");
    }
}
