package edu.uni.uniflix.menu;

import java.util.Scanner;

import edu.uni.uniflix.Validar;

public class Principal {
    private static final int OPCAO_SAIR = 6;
    private Scanner ler;
    private Usuario usuario = new Usuario();
    private Catalogo catalogo = new Catalogo();
    private Filme filme = new Filme(catalogo);
    private Serie serie = new Serie(catalogo);
    private Moeda dolar = new Moeda();
    
    private int escolha = 0;

    public Principal(Scanner ler) {
        this.ler = ler;
    }
    
    private enum Tipo {
        INICIO, EXIBIR, SUB_EXIBIR, EDITAR_REMOVER;
    }

    public void iniciar() {
        do {
            System.out.print(
                "\nDigite 1 - Adicionar usuários.			Digite 2 - Adicionar filmes/séries." +
                "\nDigite 3 - Exibir lista de usuários/catálogo.	Digite 4 - Editar ou Remover usuário ou filme/série." +
                "\nDigite 5 - Converter preço de dólar pra real.	Digite 6 - SAIR" +
                "\n> ");
            opcoes(Tipo.INICIO);
        } while (escolha != OPCAO_SAIR);
    }

    private void exibir() {
        System.out.print(
            "\nDigite 1 - Exibir usuários.	Digite 2 - Exibir catálogo." +
            "\n> ");
        opcoes(Tipo.EXIBIR);
    }

    private void exibirSub() {
        System.out.print(
            "\nDigite 1 - Exibir todo o catálogo.	Digite 2 - Exibir filmes." +
            "\nDigite 3 - Exibir séries." +
            "\n> ");
        opcoes(Tipo.SUB_EXIBIR);
    }

    private void editarOuRemover() {
        System.out.print(
            "\nDigite 1 - Remover usuário.	Digite 2 - Remover item do catálogo." +
            "\nDigite 3 - Editar usuário.	Digite 4 - Editar item do catálogo." +
            "\n> ");
        opcoes(Tipo.EDITAR_REMOVER);
    }

    private void opcoes(Tipo tipo) {
        try {
            String input = ler.nextLine();
            if (Validar.numero(input)) {
                escolha = Integer.parseInt(input);
                switch (tipo) {
                    case INICIO -> opcoesInicio();
                    case EXIBIR -> opcoesExibir();
                    case SUB_EXIBIR -> opcoesSubExibir();
                    case EDITAR_REMOVER -> opcoesEditarouRemover();
                }
            }
        } catch (Exception ex) {
            Erro.mensagem(ex);
        }
    }

    private void opcoesInicio() throws Exception {
        switch (escolha) {
            case 1 -> usuario.adicionar(ler);
            case 2 -> catalogo.adicionar(ler);
            case 3 -> exibir();
            case 4 -> editarOuRemover();
            case 5 -> dolar.valor(ler);
            case OPCAO_SAIR -> {
                ler.close();
                System.out.println("Finalizando...");
                System.exit(0);
            }
            default -> Erro.mensagem(new NumberFormatException());
        }
    }

    private void opcoesExibir() {
        switch (escolha) {
            case 1 -> usuario.exibir();
            case 2 -> exibirSub();
            default -> Erro.mensagem(new NumberFormatException());
        }
    }

    private void opcoesSubExibir() {
        switch (escolha) {
            case 1 -> catalogo.exibir();
            case 2 -> filme.exibir();
            case 3 -> serie.exibir();
            default -> Erro.mensagem(new NumberFormatException());
        }
    }
    
    private void opcoesEditarouRemover() throws Exception {
        switch (escolha) {
            case 1 -> usuario.remover(ler);
            case 2 -> catalogo.remover(ler);
            case 3 -> usuario.editar(ler);
            case 4 -> catalogo.editar(ler);
            default -> Erro.mensagem(new NumberFormatException());
        }
    }
}
