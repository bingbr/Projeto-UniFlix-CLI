package edu.uni.uniflix.modelo;

public abstract class Cliente {
    public abstract int getCpf();
    public abstract String getNome();
    public abstract String getEmail();

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + ", CPF: " + this.getCpf() + ", E-mail: " + this.getEmail();
    }
}
