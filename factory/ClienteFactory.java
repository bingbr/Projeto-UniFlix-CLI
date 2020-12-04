package factory;

import modelo.*;

public class ClienteFactory {
    public static Cliente getCliente(int cpf, String nome, String email) {
        return new Usuario(cpf, nome, email); 
    }
}