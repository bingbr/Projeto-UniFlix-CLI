package edu.uni.uniflix.modelo;

public class Usuario extends Cliente{
    private int cpf;
    private String nome;
    private String email;

    public Usuario(int cpf, String nome, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public int getCpf() {
        return cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEmail() {
        return email;
    }
}