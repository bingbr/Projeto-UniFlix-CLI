package iterator;

public class Acervo {
    private AcervoTipoEnum tipo;
    private String titulo;
    private int ano;
    private String genero;
    private double nota;
    private double preco;
    

    public Acervo(AcervoTipoEnum tipo, String titulo, int ano, String genero, double nota, double preco){
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

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getGenero() {
        return genero;
    }

    public double getNota() {
        return nota;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return this.getTipo() + " -> titulo: " + this.getTitulo() + ", ano: " + this.getAno() + ", gênero: " + this.getGenero() + ", avaliação: " + this.getNota() + ", USD $" + this.getPreco();
    }
}