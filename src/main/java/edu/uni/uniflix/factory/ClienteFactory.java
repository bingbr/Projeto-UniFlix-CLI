package edu.uni.uniflix.factory;

import edu.uni.uniflix.modelo.Cliente;
import edu.uni.uniflix.modelo.Usuario;

public class ClienteFactory {
    public static Cliente novoCliente(int cpf, String nome, String email) {
        return new Usuario(cpf, nome, email); 
    }
}