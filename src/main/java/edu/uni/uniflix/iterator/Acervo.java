package edu.uni.uniflix.iterator;

public class Acervo {
    private AcervoTipoEnum tipo;
    private String titulo;
    private int ano;
    private String genero;
    private double nota;
    private double preco;
    
    public Acervo(AcervoTipoEnum tipo, String titulo, int ano, String genero, double nota, double preco) {
        this.tipo = tipo;
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.nota = nota;
        this.preco = preco;
    }

    public AcervoTipoEnum getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return this.tipo + " -> Título: " + this.titulo + ", Ano: " + this.ano + ", Gênero: " + this.genero + ", Avaliação: " + this.nota + ", USD $" + this.preco;
    }
}