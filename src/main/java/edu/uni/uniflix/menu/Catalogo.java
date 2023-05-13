package edu.uni.uniflix.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.uni.uniflix.Validar;
import edu.uni.uniflix.iterator.*;

public class Catalogo {
    protected AcervoCollection acervo = new AcervoCollectionImpl();

    public void adicionar(Scanner ler) throws Exception {
        int quantidade = Generic.mensagem("\nQuantos filmes ou séries? > ", ler, "Valor", Integer::parseInt);
        for (int i = 0; i < quantidade; i++)
            acervo.adicionar(mensagemDados(ler));
    }

    public void editar(Scanner ler) throws Exception {
        int pos = mensagemPosicao(ler);
        if (Validar.posicao(pos, acervo.tamanho())) {
            acervo.editar((pos - 1), mensagemDados(ler));
            System.out.println("\nItem editado com sucesso.");
        }
    }
    
    public void remover(Scanner ler) throws Exception {
        int posicao = mensagemPosicao(ler);
        if (!acervo.vazio()) {
            if (Validar.posicao(posicao, acervo.tamanho())) {
                acervo.remover(posicao - 1);
                System.out.println("\nItem foi removido com sucesso.");
            }
        } else
            throw new NullPointerException("remover");
    }

    public void exibir() {
        boolean tamanho = acervo.vazio();
        Generic.exibir("FILME(S) OU SÉRIE", tamanho, acervo, AcervoTipoEnum.TODOS);
    }

    private static Acervo mensagemDados(Scanner leia) throws Exception {
        String tipo = Generic.mensagem("\nFilme ou série? > ", leia, "Tipo", String::toString);
        String titulo = Generic.mensagem("Digite o titulo: ", leia, "Titulo", String::toString);
        int ano = Generic.mensagem("Digite o ano: ", leia, "Ano", Integer::parseInt);
        String genero = Generic.mensagem("Digite o gênero: ", leia, "Gênero", String::toString);
        Double nota = Generic.mensagem("Digite a nota: ", leia, "Nota", Double::parseDouble);
        Double preco = Generic.mensagem("Digite o valor do item: ", leia, "Item", Double::parseDouble);
        return new Acervo(ehTipoValido(tipo), Validar.toTitleCase(titulo), ano, Validar.toTitleCase(genero), nota, preco);
    }

    private static AcervoTipoEnum ehTipoValido(String tipo) throws Exception {
        if (tipo.equalsIgnoreCase("Filme")) return AcervoTipoEnum.FILME;
        else if (tipo.equalsIgnoreCase("Serie") || tipo.equalsIgnoreCase("Série")) return AcervoTipoEnum.SERIE;
        else throw new InputMismatchException(tipo);
    }

    private static int mensagemPosicao(Scanner leia) throws Exception {
        return Generic.mensagem("\nDigite a posição do item na lista. (De 1 até a posição limite) > ", leia, "Posição", Integer::parseInt);
    }
}
