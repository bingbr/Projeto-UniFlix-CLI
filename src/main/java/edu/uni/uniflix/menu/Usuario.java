package edu.uni.uniflix.menu;

import java.util.LinkedList;
import java.util.Scanner;

import edu.uni.uniflix.Validar;
import edu.uni.uniflix.factory.ClienteFactory;
import edu.uni.uniflix.modelo.Cliente;

public class Usuario {
    private LinkedList<Cliente> usuarios = new LinkedList<>();

    public void adicionar(Scanner ler) throws Exception {
        int quantidade = Generic.mensagem("\nQuantos usuarios? > ", ler, "Valor", Integer::parseInt);
        for (int i = 0; i < quantidade; i++)
            usuarios.push(mensagemDados(ler));
    }

    public void editar(Scanner ler) throws Exception {
        int pos = mensagemPosicao(ler);
        if (Validar.posicao(pos, usuarios.size())) {
            usuarios.set((pos - 1), mensagemDados(ler));
            System.out.println("\nUsuário editado com sucesso.");
        }
    }

    public void remover(Scanner ler) throws Exception {
        int posicao = mensagemPosicao(ler);
        if (!usuarios.isEmpty()) {
            if (Validar.posicao(posicao, usuarios.size())) {
                usuarios.remove((posicao - 1));
                System.out.println("\nUsuário foi removido com sucesso.");
            }
        } else
            throw new NullPointerException("remover");
    }
    
    public void exibir() {
        System.out.println("\n----- LISTA DE USUÁRIO(S) -----");
        if (!usuarios.isEmpty()) 
            for (Cliente usuario : usuarios)
                System.out.println(usuario);
        else 
            System.out.println("      A lista está vazia.");
    }

    private static Cliente mensagemDados(Scanner leia) throws Exception {
        int cpf = Generic.mensagem("\nDigite o CPF (APENAS OS NÚMEROS): ", leia, "CPF", Integer::parseInt);
        String nome = Generic.mensagem("Digite o Nome: ", leia, "Nome", String::toString);
        String email = Generic.mensagem("Digite o E-mail: ", leia, "E-mail", String::toString);
        return ClienteFactory.novoCliente(cpf, Validar.toTitleCase(nome), email);
    }

    private static int mensagemPosicao(Scanner leia) throws Exception {
        return Generic.mensagem("\nDigite a posição do usuário na lista. (De 1 até a posição limite) > ", leia, "Posição", Integer::parseInt);
    }
}