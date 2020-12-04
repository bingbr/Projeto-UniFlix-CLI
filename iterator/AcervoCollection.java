package iterator;

public interface AcervoCollection {
    public void adicionarAcervo(Acervo ac);
    public void removerAcervo(int posicao);
    public void editarAcervo(int posicao, Acervo ac);
    public int tamanhoAcervo();
    public AcervoIterator iterator(AcervoTipoEnum tipo);
}
